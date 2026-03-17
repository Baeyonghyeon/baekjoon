package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek_14500 {

    static int[] yi = new int[]{1, -1, 0, 0};
    static int[] xi = new int[]{0, 0, 1, -1};
    static int[][] arr;
    static boolean[][] visit;
    static int max = 0;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        visit = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visit[i][j] = true;
                solve(i, j, 1, arr[i][j]);
                visit[i][j] = false;
            }
        }

        System.out.println(max);
    }

    static void solve(int y, int x, int depth, int sum) {
        if (depth == 4) {
            max = Math.max(sum, max);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int ny = y + yi[i];
            int nx = x + xi[i];

            if (ny < 0 || nx < 0 || ny >= n || nx >= m || visit[ny][nx]) continue;

            // ㅗ 처리
            if (depth == 2) {
                visit[ny][nx] = true;
                solve(y, x, depth + 1, sum + arr[ny][nx]);
                visit[ny][nx] = false;
            }

            visit[ny][nx] = true;
            solve(ny, nx, depth + 1, sum + arr[ny][nx]);
            visit[ny][nx] = false;
        }
    }
}
