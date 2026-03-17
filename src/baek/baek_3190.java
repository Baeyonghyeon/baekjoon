package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baek_3190 {

    static int[] yi = new int[]{-1, 0, 1, 0};
    static int[] xi = new int[]{0, 1, 0, -1};
    static int dire = 101;
    static int time = 1;
    static Queue<String[]> nextMove = new LinkedList<>();
    static Queue<int[]> tail = new LinkedList<>();
    static int[][] map;
    static int n;
    static int k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        map = new int[n + 1][n + 1];

        k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            map[y][x] = -1;
        }

        int l = Integer.parseInt(br.readLine());
        for (int i = 0; i < l; i++) {
            st = new StringTokenizer(br.readLine());
            nextMove.offer(new String[]{st.nextToken(), st.nextToken()});
        }

        solve();

        System.out.println(time);
    }

    /**
     * 1. 다음칸으로 이동
     * 2. 벽이거나, 내 몸통이면 종료.
     * 3. 사과가 있다면 꼬리그대로, 사과없으면 꼬리 짜르기
     * 4. 방향전환
     */
    private static void solve() {
        int x = 1;
        int y = 1;
        map[y][x] = 1;
        tail.offer(new int[]{y, x});

        while (true) {
            y += yi[dire % 4];
            x += xi[dire % 4];
//            System.out.println(y + " : " + x + " : " + dire);

            if (y <= 0 || x <= 0 || n + 1 <= y || n + 1 <= x || map[y][x] == 1) break;

            if (map[y][x] == 0) {
                int[] poll = tail.poll();
                map[poll[0]][poll[1]] = 0;
            }

            tail.offer(new int[]{y, x});
            map[y][x] = 1;

            if (!nextMove.isEmpty() && Integer.parseInt(nextMove.peek()[0]) == time) {
                String[] poll = nextMove.poll();

                if (poll[1].equals("L")) dire--;
                else dire++;
            }

            time++;
//            for (int i = 1; i < n + 1; i++) {
//                System.out.println("Arrays.toString(map[" + i + "]) = " + Arrays.toString(map[i]));
//            }

        }
    }
}
