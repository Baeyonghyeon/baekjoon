package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baek_4179 {

    static int[] yi = new int[]{-1, 1, 0, 0};
    static int[] xi = new int[]{0, 0, -1, 1};
    static int[][] map;
    static boolean[][] visit;
    static int r, c;
    static Queue<int[]> user = new LinkedList<>();
    static Queue<int[]> fire = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new int[r][c];
        visit = new boolean[r][c];

        /**
         * # -> -1 벽
         * F -> -2 불
         * . -> 0 땅
         */
        for (int i = 0; i < r; i++) {
            String input = br.readLine();

            for (int j = 0; j < c; j++) {
                char ch = input.charAt(j);

                if (ch == '#') map[i][j] = -1;
                else if (ch == 'F') {
                    map[i][j] = -2;
                    visit[i][j] = true;
                    fire.offer(new int[]{0, i, j});
                } else if (ch == 'J') {
                    map[i][j] = 1;
                    visit[i][j] = true;
                    user.offer(new int[]{0, i, j});
                }
            }
        }

        String result = solve();

        System.out.println(result);
    }


    /**
     * 1. 불 확산
     * 2. 이동 가능한지 확인.
     * 2-1 이동 가능하다면 yy 가 0 인지 또는 r 인지 , xx가 0 또는 c 인지 -> count 더하고 마무리.
     * 2-2 이동 불가능하다? 불인지 , 벽인지
     */
    private static String solve() {
        String result = "IMPOSSIBLE";

        int round = 0;
        boolean bl = true;

        while (!user.isEmpty() && bl) {
            // 불 확산
            while (!fire.isEmpty() && fire.peek()[0] == round) {
                int[] poll = fire.poll();
                int count = poll[0];
                int y = poll[1];
                int x = poll[2];

                for (int i = 0; i < 4; i++) {
                    int fy = y + yi[i];
                    int fx = x + xi[i];

                    if (fy < 0 || fx < 0 || fy >= r || fx >= c || visit[fy][fx] || map[fy][fx] == -1 || map[fy][fx] == -2)
                        continue;

                    visit[fy][fx] = true;
                    map[fy][fx] = -2;

                    fire.offer(new int[]{count + 1, fy, fx});
                }
            }

            // 유저 이동 가능한지 확인
            while (!user.isEmpty() && user.peek()[0] == round) {
                int[] poll = user.poll();
                int count = poll[0];
                int y = poll[1];
                int x = poll[2];

                if (y == 0 || x == 0 || y == r - 1 || x == c - 1) {
                    result = String.valueOf(map[y][x]);
                    break;
                }

                for (int i = 0; i < 4; i++) {
                    int uy = y + yi[i];
                    int ux = x + xi[i];

                    if (uy < 0 || uy < 0 || uy >= r || ux >= c || visit[uy][ux] || map[uy][ux] == -1 || map[uy][ux] == -2)
                        continue;

                    visit[uy][ux] = true;
                    map[uy][ux] = map[y][x] + 1;

                    if (uy == 0 || ux == 0 || uy == r - 1 || ux == c - 1) {
                        result = String.valueOf(map[uy][ux]);
                        bl = false;
                        break;
                    } else {
                        user.offer(new int[]{count + 1, uy, ux});
                    }
                }

            }

            round++;
        }

        return result;
    }
}
