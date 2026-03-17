package baek;

import java.io.*;
import java.util.*;

public class baek_12100 {

    static int n;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;
        solve(map, count);

        System.out.println(max);
    }

    private static int[][] deepCopy(int[][] original) {
        int[][] copy = new int[n][n];
        for (int i = 0; i < n; i++) {
            copy[i] = original[i].clone();
        }
        return copy;
    }

    private static void solve(int[][] map, int count) {
        if (count == 5) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] > max) max = map[i][j];
                }
            }
            return;
        }

        for (int i = 0; i < 4; i++) {
            int[][] newMap = deepCopy(map);
            simulation(newMap, i);

            solve(newMap, count + 1);
        }
    }

    private static void simulation(int[][] newMap, int direction) {
        if (direction == 0) { // 왼쪽
            for (int i = 0; i < n; i++) {
                Queue<Integer> q = new LinkedList<>();

                for (int j = 0; j < n; j++) {
                    if (newMap[i][j] != 0) q.offer(newMap[i][j]);
                }

                int col = 0;
                while (!q.isEmpty()) {
                    int poll = q.poll();

                    if (!q.isEmpty() && poll == q.peek()) {
                        newMap[i][col] = poll * 2;
                        q.poll();
                    } else {
                        newMap[i][col] = poll;
                    }

                    col++;
                }

                for (int j = col; j < n; j++) {
                    newMap[i][j] = 0;
                }
            }
        }

        if (direction == 1) { //오른쪽
            for (int i = n - 1; i >= 0; i--) {
                Queue<Integer> q = new LinkedList<>();

                for (int j = n - 1; j >= 0; j--) {
                    if (newMap[i][j] != 0) q.offer(newMap[i][j]);
                }

                int col = n - 1;
                while (!q.isEmpty()) {
                    int poll = q.poll();

                    if (!q.isEmpty() && poll == q.peek()) {
                        newMap[i][col] = poll * 2;
                        q.poll();
                    } else {
                        newMap[i][col] = poll;
                    }

                    col--;
                }

                for (int j = col; j >= 0; j--) {
                    newMap[i][j] = 0;
                }
            }
        }

        if (direction == 2) { // 위
            for (int i = 0; i < n; i++) {
                Queue<Integer> q = new LinkedList<>();

                for (int j = 0; j < n; j++) {
                    if (newMap[j][i] != 0) q.offer(newMap[j][i]);
                }

                int row = 0;
                while (!q.isEmpty()) {
                    int poll = q.poll();

                    if (!q.isEmpty() && poll == q.peek()) {
                        newMap[row][i] = poll * 2;
                        q.poll();
                    } else {
                        newMap[row][i] = poll;
                    }

                    row++;
                }

                for (int j = row; j < n; j++) {
                    newMap[j][i] = 0;
                }
            }
        }

        if (direction == 3) { // 아래
            for (int i = n - 1; i >= 0; i--) {
                Queue<Integer> q = new LinkedList<>();

                for (int j = n - 1; j >= 0; j--) {
                    if (newMap[j][i] != 0) q.offer(newMap[j][i]);
                }

                int row = n - 1;
                while (!q.isEmpty()) {
                    int poll = q.poll();

                    if (!q.isEmpty() && poll == q.peek()) {
                        newMap[row][i] = poll * 2;
                        q.poll();
                    } else {
                        newMap[row][i] = poll;
                    }

                    row--;
                }

                for (int j = row; j >= 0; j--) {
                    newMap[j][i] = 0;
                }
            }
        }
    }

}
