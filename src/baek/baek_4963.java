package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class baek_4963 {
    static int w, h, count;
    static int map[][];
    static boolean visit[][];
    static int dx[] = {-1, 1, 0, 0, 1, -1, -1, 1};
    static int dy[] = {0, 0, -1, 1, 1, 1, -1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String token[] = br.readLine().split(" ");
            w = Integer.parseInt(token[0]);
            h = Integer.parseInt(token[1]);
            if (w == 0 && h == 0) break;
            map = new int[h][w];
            visit = new boolean[h][w];
            count = 0;

            for (int i = 0; i < h; i++) {
                token = br.readLine().split(" ");
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(token[j]);
                }
            }

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (!visit[i][j] && map[i][j] == 1) {
                        BFS(i, j);
                        count++;
                    }
                }
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }

    public static void BFS(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});

        while (!q.isEmpty()) {
            x = q.peek()[0];
            y = q.peek()[1];
            visit[x][y] = true;
            q.poll();

            for (int i = 0; i < 8; i++) {
                int ix = x + dy[i];
                int iy = y + dx[i];

                if (ix >= 0 && iy >= 0 && ix < h && iy < w) {
                    if (!visit[ix][iy] && map[ix][iy] == 1) {
                        visit[ix][iy] = true;
                        q.offer(new int[]{ix, iy});
                    }
                }
            }
        }
    }
}
