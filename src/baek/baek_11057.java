package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baek_11057 {

    static int[][] dp;
    static final int MOD = 10_007;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        dp = new int[n + 1][10];

        for (int j = 0; j <= 9; j++) {
            dp[1][j] = 1;
        }
        
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= 9; j++) {
                for (int k = 0; k <= j; k++) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][k]) % MOD;
                }
            }
        }

        int result = 0;
        for (int j = 0; j <= 9; j++) {
            result = (result + dp[n][j]) % MOD;
        }

        System.out.println(result);
    }
}