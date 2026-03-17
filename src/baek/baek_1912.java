package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek_1912 {

    static int[] arr;
    static int[] dp;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        arr = new int[n + 1];
        dp = new int[n + 1];
        visit = new boolean[n + 1];

        for (int i = 1; i < n+1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[1] = arr[1];

        solve(n);

//        System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));
//        System.out.println("Arrays.toString(dp) = " + Arrays.toString(dp));

        int max = Integer.MIN_VALUE;
        for (int i = 1; i < n + 1; i++) {
            if (dp[i] > max) max = dp[i];
        }

        System.out.println(max);
    }

    private static int solve(int n) {
        if (n == 1) return dp[n];
        if (visit[n]) return dp[n];

        int max = Math.max(solve(n - 1) + arr[n], arr[n]);
        dp[n] = max;
        visit[n] = true;

        return max;
    }
}
