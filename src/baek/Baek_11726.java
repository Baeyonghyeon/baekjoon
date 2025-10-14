package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_11726 {

    // 2 x n 값을 구해서 들어갈 경우의 수를 구한다.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        long count = 0;

        if (n == 1) {
            count = 1;
        } else if (n == 2) {
            count = 2;
        } else {
            long a = 1;
            long b = 2;

            for (int i = 3; i <= n; i++) {
                count = (a + b) % 10007;
                a = b;
                b = count;
            }
        }

        System.out.println(count);
    }
}
