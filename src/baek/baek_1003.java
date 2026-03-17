package baek;

import java.util.*;
import java.io.*;

public class baek_1003 {

    static int[][] dp = new int[41][2];
    static boolean[] visit = new boolean[41];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        init();
        solve(40);

        for (int i = t; i > 0; i--) {
            int n = Integer.parseInt(br.readLine());

            sb.append(dp[n][0]).append(" ").append(dp[n][1]).append("\n");
        }

        System.out.println(sb);
    }

    private static void init() {
        dp[0][1] = 0;
        dp[0][0] = 1;
        dp[1][1] = 1;
        dp[1][0] = 0;
    }

    private static int[] solve(int n) {
        if (n == 0) return dp[0];
        if (n == 1) return dp[1];
        if (visit[n]) return dp[n];

        int[] res1 = solve(n - 1);
        int[] res2 = solve(n - 2);

        dp[n][0] = res1[0] + res2[0];
        dp[n][1] = res1[1] + res2[1];
        visit[n] = true;

        return dp[n];
    }
}
