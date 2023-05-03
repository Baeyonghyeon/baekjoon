package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baek_2018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int start = 0;
        int end = 1;
        int count = 1;
        long sum = 1;

        while (end < N && start < N) {
            if (sum == N) {
                count++;
                end++;
                sum += end;
            } else if (sum < N) {
                end++;
                sum += end;
            } else {
                start++;
                sum -= start;
            }
        }
        System.out.println(count);
    }
}
