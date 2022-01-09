package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class baek_1012 {
    static int M, N, K, count;
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};
    static int map[][];
    static boolean visit[][];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine()); //테스트 케이스
        while (T-- > 0) {
            String token[] = br.readLine().split(" ");
            M = Integer.parseInt(token[0]); //가로길이
            N = Integer.parseInt(token[1]); //세로길이
            K = Integer.parseInt(token[2]); //배추가 심어져 있는 개수
            count = 0;

            visit = new boolean[M][N];
            map = new int[M][N];

            while (K-- > 0) {
                String token2[] = br.readLine().split(" ");
                int x = Integer.parseInt(token2[0]);
                int y = Integer.parseInt(token2[1]);
                map[x][y] = 1;
            }

            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visit[i][j] && map[i][j] == 1) {
                        count++;
                        BFS(i, j);
                        //DFS(i, j);
                    }
                }
            }

            sb.append(count).append("\n");
        }

        System.out.print(sb);

    }

    public static void BFS(int x, int y) {
        Queue<int[]> q = new LinkedList<int[]>();
        q.offer(new int[]{x, y});

        while (!q.isEmpty()) {
            x = q.peek()[0];
            y = q.peek()[1];
            visit[x][y] = true;
            q.poll();
            for (int i = 0; i < 4; i++) {
                int ix = x + dx[i];
                int iy = y + dy[i];

                if (ix >= 0 && iy >= 0 && ix < M && iy < N) {
                    if (!visit[ix][iy] && map[ix][iy] == 1) {
                        q.offer(new int[]{ix, iy});
                        visit[ix][iy] = true;
                    }
                }
            }
        }

    }

    public static void DFS(int x, int y) {
        visit[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int ix = x + dx[i];
            int iy = y + dy[i];

            if (ix >= 0 && iy >= 0 && ix < M && iy < N){
                if (!visit[ix][iy] && map[ix][iy] == 1){
                    DFS(ix, iy);
                }
            }
        }
    }
}
