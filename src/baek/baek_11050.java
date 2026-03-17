package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek_11050 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String token[] = br.readLine().split(" ");
//        int N = Integer.parseInt(token[0]);
//        int K = Integer.parseInt(token[1]);
//
//        System.out.println(factorial(N)/(factorial(N-K)*factorial(K)));
//    }
//
//    static int factorial(int N) {
//        if (N <= 1) return 1;
//
//        return N * factorial(N - 1);
//    }

    public static void main(String[] args) throws Exception {
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
                D[i][j] = D[i - 1][j - 1] + D[i - 1][j];
            }
        }

        System.out.println(D[n][k]);
    }
}
