package baek;

import java.io.*;
import java.util.*;

public class baek_12852 {

    static int[] dp;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        dp = new int[n + 2];
        parent = new int[n + 2];
        dp[2] = 1;
        parent[2] = 1;

        solve(n);

        for (int cur = n; cur >= 1; cur = parent[cur]) {
            sb.append(cur).append(" ");
        }

//        System.out.println("Arrays.toString(parent) = " + Arrays.toString(parent));
        System.out.println(dp[n]);
        System.out.println(sb);
    }

    private static int solve(int n) {
        if (n == 1) return 0;
        if (n == 2) return 1;
        if (n > 0 && dp[n] != 0) return dp[n];

        int result = solve(n - 1) + 1;
        parent[n] = n - 1;

        if (n % 2 == 0) {
            int no = solve(n / 2) + 1;
            if (no < result) {
                result = no;
                parent[n] = n / 2;
            }
        }
        if (n % 3 == 0) {
            int no = solve(n / 3) + 1;
            if (no < result) {
                result = no;
                parent[n] = n / 3;
            }
        }

        return dp[n] = result;
    }
}
