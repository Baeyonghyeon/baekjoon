package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek_14499 {

    static int[] yi = new int[]{0, 0, 0, -1, 1};
    static int[] xi = new int[]{0, 1, -1, 0, 0};
    static int[][] map;
    static int[][] dice;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] diceStart = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        int k = Integer.parseInt(st.nextToken());

        dice = new int[4][4];
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());

        StringBuilder sb = solve(st, diceStart, n, m);

        System.out.println(sb);
    }

    /**
     * 1. map 이동되는지 확인한다.
     * 2. 주사위 굴림.
     * 3. 주사위 바닥 값 넣기.
     */
    private static StringBuilder solve(StringTokenizer st, int[] diceStart, int n, int m) {
        StringBuilder sb = new StringBuilder();
        int y = diceStart[0];
        int x = diceStart[1];

        while (st.hasMoreElements()) {
            int dire = Integer.parseInt(st.nextToken());

            if ((y + yi[dire] < 0) || (x + xi[dire] < 0) || (y + yi[dire] >= n) || (x + xi[dire] >= m)) continue;

            y += yi[dire];
            x += xi[dire];

            if (dire == 1) {
                int temp = dice[1][3];
                for (int i = 3; i > 0; i--) {
                    dice[1][i] = dice[1][i - 1];
                }

                dice[1][0] = temp;
                dice[3][1] = dice[1][3];
            }

            if (dire == 2) {
                int temp = dice[1][0];
                for (int i = 0; i < 3; i++) {
                    dice[1][i] = dice[1][i + 1];
                }

                dice[1][3] = temp;
                dice[3][1] = dice[1][3];
            }

            if (dire == 3) {
                int temp = dice[0][1];
                for (int i = 0; i < 3; i++) {
                    dice[i][1] = dice[i + 1][1];
                }

                dice[3][1] = temp;
                dice[1][3] = dice[3][1];

            }

            if (dire == 4) {
                int temp = dice[3][1];
                for (int i = 3; i > 0; i--) {
                    dice[i][1] = dice[i - 1][1];
                }

                dice[0][1] = temp;
                dice[1][3] = dice[3][1];
            }

//            System.out.println("map[" + y + "][" + x + "] = " + map[y][x]);
            if (map[y][x] == 0) {
                map[y][x] = dice[1][1];

            } else {
                dice[1][1] = map[y][x];
                map[y][x] = 0;
            }

            sb.append(dice[3][1]).append("\n");
        }

        return sb;
    }


}
