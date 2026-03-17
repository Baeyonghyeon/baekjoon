package baek;

import java.io.*;
import java.util.*;

public class baek_14889 {

    static int n;
    static int[][] arr;
    static boolean[] select;
    static int minDiff = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n][n];
        select = new boolean[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve(0, 0);
        System.out.println(minDiff);
    }

    static void solve(int idx, int count) {
        if (count == n / 2) {
            calculateDiff();
            return;
        }

        if (idx == n) {
            return;
        }

        select[idx] = true;
        solve(idx + 1, count + 1);

        select[idx] = false;
        solve(idx + 1, count);
    }

    static void calculateDiff() {
        int startSum = 0;
        int linkSum = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (select[i] && select[j]) {
                    startSum += arr[i][j] + arr[j][i];
                }

                else if (!select[i] && !select[j]) {
                    linkSum += arr[i][j] + arr[j][i];
                }
            }
        }

        int diff = Math.abs(startSum - linkSum);
        minDiff = Math.min(minDiff, diff);
    }
}