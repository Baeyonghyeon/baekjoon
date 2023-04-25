package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class baek_1260 {
    static StringBuilder sb = new StringBuilder();
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken()); //정점의 개수
        int M = Integer.parseInt(st.nextToken()); //간선의 개수
        int V = Integer.parseInt(st.nextToken()); //탐색을 시작할 번호
        

        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }
        visit = new boolean[N + 1];

        //edge넣기
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            put(x, y);
        }
        //값이 순서대로 들어가지 않아 정렬해줌
        for(int i=0; i<N+1; i++){
            Collections.sort(graph.get(i));
        }

        dfs(V);
        blset();    //visit배열 초기화
        sb.append("\n");
        bfs(V);

        System.out.println(sb);
    }

    private static void blset() {
        Arrays.fill(visit, false);
    }

    private static void put(int x, int y) {
        graph.get(x).add(y);
        graph.get(y).add(x);
    }

    public static void dfs(int V) {
        visit[V] = true;
        sb.append(V).append(" ");
        for (int i : graph.get(V)) {
            if (!visit[i]) dfs(i);
        }
    }

    private static void bfs(int V) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(V);
        visit[V] = true;
        while (!q.isEmpty()) {
            int x = q.poll();
            sb.append(x).append(" ");
            for (int i : graph.get(x)) {
                if (!visit[i]) {
                    q.offer(i);
                    visit[i] = true;
                }
            }
        }

    }
}
