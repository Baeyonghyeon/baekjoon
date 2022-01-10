package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class baek_1697 {
    static int N,K;
    static int map[];
    static boolean visit[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String token[] = br.readLine().split(" ");
        N = Integer.parseInt(token[0]);     //수빈이 위치
        K = Integer.parseInt(token[1]);     //동생 위치

        map = new int[100001];
        visit = new boolean[100001];

        BFS(N);

        System.out.println(map[K]);
    }

    public static void BFS(int N){
        Queue<Integer> q = new LinkedList<>();
        q.offer(N);

        while (!q.isEmpty()){
            N = q.poll();
            visit[N] = true;
            int dx[] = {-1, 1, 2*N};

            for(int i=0; i<3; i++){
                int ix;
                if(i==2) {
                    ix = dx[i];
                }else{
                    ix = N + dx[i];
                }

                if(ix >= 0 && ix < 100001){
                    if(!visit[ix] && map[ix] == 0){
                        q.offer(ix);
                        map[ix] = map[N] +1;
                        visit[ix] = true;
                    }
                }
            }
        }
    }
}
