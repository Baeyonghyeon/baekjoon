package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baek_10844 {

    static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new long[n + 1][10];

        solve(n);

        long result = 0;
        for (int i = 0; i < 10; i++) {
            result += dp[n][i] % 1_000_000_000;
        }

        System.out.println(result % 1_000_000_000);
    }

    private static void solve(int n) {
        for (int i = 1; i <= 9; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < 10; j++) {

                if (j == 0) dp[i][j] = dp[i - 1][1] % 1_000_000_000;
                else if (j == 9) dp[i][j] = dp[i - 1][8] % 1_000_000_000;
                else dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % 1_000_000_000;
            }
        }
    }
}
