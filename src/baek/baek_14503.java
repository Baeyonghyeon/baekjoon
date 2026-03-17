package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek_14503 {

    static int[] yi = new int[]{-1, 0, 1, 0};
    static int[] xi = new int[]{0, 1, 0, -1};
    static int[][] arr;
    static int n, m;
    static int[] position;
    static int direction;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        st = new StringTokenizer(br.readLine());
        position = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        direction = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(solve());
    }

    static int solve() {
        int count = 0;

        while (true) {
            int y = position[0];
            int x = position[1];

            if (arr[y][x] == 0) {
                arr[y][x] = 2;
                count++;
            }

            if (checkClean(y, x)) {
                int yy = y + yi[direction] * -1;
                int xx = x + xi[direction] * -1;

                if (yy < 0 || xx < 0 || yy >= n || xx >= m || arr[yy][xx] == 1) break;

                position[0] = yy;
                position[1] = xx;

            } else {
                direction = (4 + direction - 1) % 4;
                int yy = y + yi[direction];
                int xx = x + xi[direction];

                if (yy < 0 || xx < 0 || yy >= n || xx >= m || arr[yy][xx] != 0) continue;

                position[0] = yy;
                position[1] = xx;
            }
        }

        return count;
    }

    static boolean checkClean(int y, int x) {
        boolean clean = true;

        for (int i = 0; i < 4; i++) {
            int yy = y + yi[i];
            int xx = x + xi[i];

            if (yy < 0 || xx < 0 || yy >= n || xx >= m || arr[yy][xx] != 0) continue;

            clean = false;
        }

        return clean;
    }
}
