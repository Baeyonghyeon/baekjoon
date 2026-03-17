package baek;

import java.io.*;
import java.util.*;

public class baek_14890 {

    static int[][] arr;
    static int n, l;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());

        int count = 0;

        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            count += solve(i);

//            System.out.println("count = " + count);
        }

        System.out.println(count);
    }

    private static int solve(int line) {
        int result = 0;

        // 가로 검증
        int current = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[line][0]);
        boolean bl = true;

        while (++current < n && bl) {

            int diff = arr[line][current - 1] - arr[line][current];

            if (diff == 1) { // 내리막
                for (int i = 0; i < l; i++) {
                    if (current + i >= n || (arr[line][current] - arr[line][current + i] != 0)) {
                        bl = false;
                        break;
                    }
                }
                current += l - 1;
                stack.clear();

            } else if (diff == -1) { // 오르막
                for (int i = 0; i < l; i++) {
                    if (stack.isEmpty() || stack.pop() - arr[line][current] != -1) {
                        bl = false;
                        break;
                    }
                }
                stack.push(arr[line][current]);

            } else if (diff == 0) {
                stack.push(arr[line][current]);

            } else {
                bl = false;
            }
        }

        if (bl) result++;


//         세로 검증
        current = 0;
        stack = new Stack<>();
        stack.push(arr[0][line]);
        bl = true;

        while (++current < n && bl) {
            int diff = arr[current - 1][line] - arr[current][line];

            if (diff == 1) { // 내리막
                for (int i = 0; i < l; i++) {
                    if (current + i >= n || (arr[current][line] - arr[current + i][line] != 0)) {
                        bl = false;
                        break;
                    }
                }
                current += l - 1;
                stack.clear();

            } else if (diff == -1) { // 오르막
                for (int i = 0; i < l; i++) {
                    if (stack.isEmpty() || stack.pop() - arr[current][line] != -1) {
                        bl = false;
                        break;
                    }
                }

                stack.push(arr[current][line]);

            } else if (diff == 0) {
                stack.push(arr[current][line]);

            } else {
                bl = false;
            }
        }

        if (bl) result++;

        return result;
    }
}
