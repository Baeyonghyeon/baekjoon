package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class baek_14502 {

    static int[] yi = new int[]{-1, 1, 0, 0};
    static int[] xi = new int[]{0, 0, -1, 1};
    static int[][] arr;
    static int[][] copyArr;
    static boolean[][] visit;
    static int wall, n, m;
    static List<int[]> virus;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        wall = 3;
        virus = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());

                if (arr[i][j] == 2) virus.add(new int[]{i, j});
            }
        }

        solve();
    }

    /**
     * 64C3(순환해서 벽을 넣는 모든 경우의 수) * 2(bfs 안전구역 탐색)
     */
    static void solve() {
        int maxSafe = 0;

        for (int i = 0; i < n * m; i++) {
            int y1 = i / m;
            int x1 = i % m;
            if (arr[y1][x1] != 0) continue;

            for (int j = i + 1; j < n * m; j++) {
                int y2 = j / m;
                int x2 = j % m;
                if (arr[y2][x2] != 0) continue;

                for (int k = j + 1; k < n * m; k++) {
                    int y3 = k / m;
                    int x3 = k % m;
                    if (arr[y3][x3] != 0) continue;

                    arr[y1][x1] = 1;
                    arr[y2][x2] = 1;
                    arr[y3][x3] = 1;

                    maxSafe = Math.max(maxSafe, checkSafetySector());

                    arr[y1][x1] = 0;
                    arr[y2][x2] = 0;
                    arr[y3][x3] = 0;
                }
            }
        }

        System.out.println(maxSafe);
    }

    static int checkSafetySector() {
        visit = new boolean[n][m];
        arrDeepCopy();
        Queue<int[]> q = new LinkedList<>();
        int count = 0;

        for (int[] v : virus) {
            q.offer(new int[]{v[0], v[1]});
        }

        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int y = poll[0];
            int x = poll[1];

            visit[y][x] = true;

            for (int i = 0; i < 4; i++) {
                int yy = y + yi[i];
                int xx = x + xi[i];

                if (yy < 0 || xx < 0 || yy >= n || xx >= m || copyArr[yy][xx] != 0 || visit[yy][xx]) continue;

                copyArr[yy][xx] = 2;
                visit[yy][xx] = true;
                q.offer(new int[]{yy, xx});
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (copyArr[i][j] == 0) count++;
            }
        }

        return count;
    }

    static void arrDeepCopy() {
        copyArr = new int[n][m];

        for (int i = 0; i < n; i++) {
            copyArr[i] = arr[i].clone();
        }
    }
}
