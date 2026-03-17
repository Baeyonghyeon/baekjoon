package baek;

import java.io.*;
import java.util.*;

public class baek_1446 {

    static int n, d;
    static List<List<int[]>> shortcuts;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        shortcuts = new ArrayList<>();
        dp = new int[d + 1];

        for (int i = 0; i <= d; i++) {
            shortcuts.add(new ArrayList<>());
            dp[i] = i;
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            if (end > d) continue;
            if (end - start <= dist) continue;

            shortcuts.get(start).add(new int[]{end, dist});
        }

        solve();
        System.out.println(dp[d]);
    }

    static void solve() {
        for (int i = 0; i <= d; i++) {
            if (i > 0) {
                dp[i] = Math.min(dp[i], dp[i - 1] + 1);
            }

            for (int[] shortcut : shortcuts.get(i)) {
                int end = shortcut[0];
                int dist = shortcut[1];
                dp[end] = Math.min(dp[end], dp[i] + dist);
            }
        }
    }
}