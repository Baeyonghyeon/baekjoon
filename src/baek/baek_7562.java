package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class baek_7562 {
    static int T, I;
    static int map[][];
    static boolean visit[][];
    static int dx[] = {1, 2, -1, -2, -1, -2, 1, 2};
    static int dy[] = {2, 1, 2, 1, -2, -1, -2, -1};
    static Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            I = Integer.parseInt(br.readLine());
            map = new int[I][I];
            visit = new boolean[I][I];
            String token[] = br.readLine().split(" ");      //Knight Start_Location
            String token2[] = br.readLine().split(" ");     //Knight finish_Location
            BFS(Integer.parseInt(token[0]), Integer.parseInt(token[1]));

            sb.append(map[Integer.parseInt(token2[0])][Integer.parseInt(token2[1])]).append("\n");
        }

        System.out.println(sb);
    }

    public static void BFS(int x, int y) {
        q.offer(new int[]{x, y});

        while (!q.isEmpty()) {
            x = q.peek()[0];
            y = q.peek()[1];
            visit[x][y] = true;
            q.poll();

            for (int i = 0; i < 8; i++) {
                int ix = x + dx[i];
                int iy = y + dy[i];

                if (ix >= 0 && iy >= 0 && ix < I && iy < I) {
                    if (!visit[ix][iy]) {
                        visit[ix][iy] = true;
                        map[ix][iy] = map[x][y] + 1;
                        q.offer(new int[]{ix, iy});
                    }
                }
            }
        }
    }
}
