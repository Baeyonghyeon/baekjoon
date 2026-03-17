package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baek_1932 {

    static int[][] arr;
    static int[][] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        result = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j <= i; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        result[0][0] = arr[0][0];

        for (int i = 1; i < n; i++) {
            result[i][0] = result[i - 1][0] + arr[i][0];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= i; j++) {
                result[i][j] = Math.max(result[i - 1][j - 1] + arr[i][j], result[i - 1][j] + arr[i][j]);
            }
        }

        int max = Arrays.stream(result[n - 1]).max().getAsInt();
//        System.out.println("Arrays.toString(result[n - 1]) = " + Arrays.toString(result[n - 1]));

        System.out.println(max);
    }
}
