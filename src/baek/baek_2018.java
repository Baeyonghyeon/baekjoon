package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baek_2018 {

    static int[] sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int start = 0;
        int end = 0;
        sum = new int[N + 1];
        int count = 0;

        for (int i = 1; i < N + 1; i++) {
            sum[i] = sum[i - 1] + i;
        }

        while (start < N) {
            if (sum[end] - sum[start] < N) {
                end++;
            } else if (sum[end] - sum[start] > N) {
                start++;
            } else {
                count++;
                start++;
            }
        }

        System.out.println(count);
    }
}
