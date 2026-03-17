package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baek_2156 {

    static int[] arr;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        dp = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = arr[0];
        if (n >= 2) dp[1] = arr[0] + arr[1];
        if (n >= 3) dp[2] = Math.max(dp[1], Math.max(arr[0] + arr[2], arr[1] + arr[2]));


        /**
         * i 를 선택하고 이전걸 선택했다면 dp[i] = arr[i-1] + dp[i-3] + arr[i]
         * i 를 선택하고 이전걸 선택하지 않았다면 dp[i] = dp[i-2] + arr[i]
         * i 를 선택하지 않았다면 dp[i] = dp[i-1]
         */

        for (int i = 3; i < n; i++) {
            dp[i] = Math.max(dp[i - 1],
                    Math.max(dp[i - 2] + arr[i], arr[i - 1] + dp[i - 3] + arr[i]));
        }

        System.out.println(dp[n - 1]);
    }
}
