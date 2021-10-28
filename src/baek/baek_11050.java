package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baek_11050 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String token[] = br.readLine().split(" ");
        int N = Integer.parseInt(token[0]);
        int K = Integer.parseInt(token[1]);

        System.out.println(factorial(N)/(factorial(N-K)*factorial(K)));
    }

    static int factorial(int N) {
        if (N <= 1) return 1;

        return N * factorial(N - 1);
    }
}
