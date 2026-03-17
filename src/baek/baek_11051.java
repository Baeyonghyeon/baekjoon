package baek;

import java.io.*;
import java.util.*;

public class baek_11051 {
    public static void main(String[] args) throws Exception {
        final int MOD = 10_007;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] D = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            D[i][0] = 1;
            D[i][1] = i;
            D[i][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                D[i][j] = (D[i - 1][j - 1] % MOD + D[i - 1][j] % MOD) % MOD;
            }
        }

        System.out.println(D[n][k]);
    }
}
