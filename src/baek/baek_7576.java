package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class baek_7576 {
    static int M, N;
    static boolean visit[][];
    static int map[][];
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};
    static Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String token[] = br.readLine().split(" ");
        M = Integer.parseInt(token[0]);     //상자 가로
        N = Integer.parseInt(token[1]);     //상자 세로

        visit = new boolean[N][M];
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            token = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(token[j]);
                if (map[i][j] == 1) q.offer(new int[]{i, j});
            }
        }

        BFS();

        int max = 0;
        boolean bl = true;

        //0이 있는지 검사 (토마토가 익지 않았는지 검사)
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {   //익지 않은게 있다면 -1
                    bl = false;
                    break;
                } else {
                    if (map[i][j] > max) max = map[i][j];
                }
            }
        }

        if (bl) {
            System.out.println(max - 1);
        } else {
            System.out.println("-1");
        }
    }

    public static void BFS() {
        while (!q.isEmpty()) {
            int x = q.peek()[0];
            int y = q.peek()[1];
            q.poll();
            visit[x][y] = true;

            for (int i = 0; i < 4; i++) {
                int ix = x + dx[i];
                int iy = y + dy[i];

                if (ix >= 0 && iy >= 0 && ix < N && iy < M) {
                    if (!visit[ix][iy] && map[ix][iy] == 0) {
                        visit[ix][iy] = true;
                        map[ix][iy] = map[x][y] + 1;
                        q.offer(new int[]{ix, iy});
                    }
                }
            }
        }
    }

}
