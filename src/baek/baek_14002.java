package baek;

import java.io.*;
import java.util.*;

public class baek_14002 {

    static int[] arr;
    static int[] dp;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        arr = new int[n];
        dp = new int[n];
        parent = new int[n];
        Arrays.fill(parent, -1);

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            dp[i] = 1;

            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    if (dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                        parent[i] = j;
                    }
                }
            }
        }

        int maxLen = 0;
        int maxIdx = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] > maxLen) {
                maxLen = dp[i];
                maxIdx = i;
            }
        }

        List<Integer> result = new ArrayList<>();
        int idx = maxIdx;
        while (idx != -1) {
            result.add(arr[idx]);
            idx = parent[idx];
        }
        Collections.reverse(result);

        System.out.println(maxLen);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}