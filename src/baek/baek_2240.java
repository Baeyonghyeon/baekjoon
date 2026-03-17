package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek_2240 {

    static int[] arr;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        arr = new int[t + 1];
        dp = new int[t + 1][w + 1];
        dp[0][0] = 0;

        // 움직였을 경우 항상 %2 했을때 항상 홀수가 나옴. 편하게 하려고 사전작업
        for (int i = 1; i <= t; i++) {
            arr[i] = Integer.parseInt(br.readLine()) - 1;
        }

        solve(t, w);

        int max = 0;
        for (int i = 0; i <= w; i++) {
            max = Math.max(dp[t][i], max);
        }

        System.out.println(max);
    }

    private static void solve(int t, int w) {

        for (int i = 1; i <= t; i++) {
            for (int j = 0; j <= w; j++) {
                int work = j % 2;
                int plum = arr[i] == work ? 1 : 0;

                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + plum;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1]) + plum;
                }
            }
        }
    }

}
