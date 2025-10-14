package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baek_11727 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long result = 0;
        long[] value = new long[3];
        value[0] = 1;
        value[1] = 3;

        if (n < 3) {
            System.out.println(value[n-1]);
        } else {
            for (int i = 3; i <= n; i++) {
                result = (((2 * value[0]) % 10007) + (value[1] % 10007)) % 10007;
                value[0] = value[1];
                value[1] = result;
            }

            System.out.println(result);
        }
    }
}
