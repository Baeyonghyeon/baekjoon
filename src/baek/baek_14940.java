package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baek_14940 {

    static int n, m;
    static boolean bl;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static boolean[][] visit;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visit = new boolean[n][m];
        map = new int[n][m];
        int startX = 0;
        int startY = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int token = Integer.parseInt(st.nextToken());
                map[i][j] = token;

                if (token == 0) {
                    visit[i][j] = true;
                }

                if (token == 1) {
                    map[i][j] = -1;
                }

                if (token == 2) {
                    startX = j;
                    startY = i;
                    map[startY][startX] = 0;
                    visit[startY][startX] = true;
                }
            }
        }

        BFS(startX, startY);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int x = map[i][j];

                sb.append(x).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void BFS(int startX, int startY) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{startY, startX});

        while (!q.isEmpty()) {
            int x = q.peek()[1];
            int y = q.poll()[0];
            visit[y][x] = true;

            for (int i = 0; i < 4; i++) {
                int xi = dx[i] + x;
                int yi = dy[i] + y;

                if (xi >= 0 && xi < m && yi >= 0 && yi < n) {
                    if (!visit[yi][xi] && map[yi][xi] == -1) {
                        q.offer(new int[]{yi, xi});
                        map[yi][xi] += map[y][x] + 2;
                    }
                }
            }
        }
    }
}
