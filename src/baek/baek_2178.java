package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class baek_2178 {
    static int N, M;
    static int map[][];
    static boolean visit[][];
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String token[] = br.readLine().split(" ");
        N = Integer.parseInt(token[0]);
        M = Integer.parseInt(token[1]);
        map = new int[N][M];
        visit = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String token2[] = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(token2[j]);
            }
        }

        BFS(0, 0);

        System.out.println(map[N-1][M-1]);

    }

    public static void BFS(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});

        while (!q.isEmpty()) {
            x = q.peek()[0];
            y = q.peek()[1];
            visit[x][y] = true;

            q.poll();

            for (int i = 0; i < 4; i++) {
                int ix = x + dx[i];
                int iy = y + dy[i];

                if (ix >= 0 && iy >= 0 && ix < N && iy < M) {
                    if (map[ix][iy] != 0 && !visit[ix][iy]) {
                        q.offer(new int[]{ix, iy});
                        map[ix][iy] = map[x][y]+1;
                        visit[ix][iy] = true;
                    }
                }
            }
        }
    }

}
