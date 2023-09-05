package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public class baek_1463 {
    static Integer[] ary;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());
        ary = new Integer[X + 1];
        ary[0] = ary[1] = 0;
        System.out.println(re(X));

    }

    private static int re(int n) {
        if (Objects.isNull(ary[n])) {
            if (n % 6 == 0) {
                ary[n] = Math.min(re(n / 3), Math.min(re(n / 2), re(n-1))) + 1;
            } else if (n % 3 == 0) {
                ary[n] = Math.min(re(n / 3), re(n - 1)) + 1;
            } else if (n % 2 == 0) {
                ary[n] = Math.min(re(n / 2), re(n - 1)) + 1;
            } else {
                ary[n] = re(n - 1) + 1;
            }
        }

        return ary[n];
    }
}
