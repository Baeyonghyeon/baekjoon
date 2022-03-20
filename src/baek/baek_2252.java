package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class baek_2252 {
    static int N,M;
    static ArrayList<Integer>[] Map; //인접리스트
    static boolean Visit[];
    static int InDegree[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Map = new ArrayList[N+1];
        Visit = new boolean[N+1];
        InDegree = new int[N+1];

        //그래프 초기화
        for(int i=0; i<=N ; i++){
            Map[i] = new ArrayList<>();
        }

        //진입차수가 0이 되어 탐색순서가 도달한 정점을 담는 큐
        ArrayDeque<Integer> dq = new ArrayDeque<>();

        //그래프 정의
        // 먼저 출력되어야 하는 학생 > 나중에 출력 되어야 하는 학생 순서로 그래프를 구성함
        // 나중에 출력되어야 하는 학생들의 경우엔 진입차수 1 증가시킴
        int from, to;
        for(int i=1; i<= M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());
            Map[from].add(to);
            InDegree[to]++;
        }

        //최초 탐색을 할 학생을 찾는다.
        for(int i=1; i<=M; i++){
            if(InDegree[i] == 0) dq.addLast(i);
        }

        int seq =0; // 마지막 공백을 출력하지 않기 위한 변수
        // Queue가 빌때까지 수행된다.
        while (dq.isEmpty() == false){
            int now = dq.pollLast(); // 현재 탐색 위치
            seq++;
            // 바로 출력
            if(seq == N){
                sb.append(now);
            }else{
                sb.append(now).append(" ");
            }

            //인접한 노드들을 검사한다.
            //이때 진입차수가 0보다 큰 정점들만 탐색한다(0이면 이미 큐에 있음)
            //진입차수를 하나씩 내려주고, 0이 되었다면 큐에 넣어준다.
            for(int next : Map[now]){
                if(InDegree[next] > 0){
                    InDegree[next]--;
                    if(InDegree[next] == 0){
                        dq.addLast(next);
                    }
                }
            }
        }
    }
}
