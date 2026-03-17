package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public class baek_20310 {

    static String[] split;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String s = br.readLine();

        int one = 0;
        int zero = 0;

        split = s.split("");

        for (String i : split) {
            if (Objects.equals("1", i)) one++;
            else zero++;
        }

        one /= 2;
        zero /= 2;

        solve(one, zero);

        for (String i : split) {
            if (!Objects.equals(i, "-1")) sb.append(i);
        }

        System.out.println(sb);
    }

    private static void solve(int one, int zero) {
        int start = 0;
        int end = split.length - 1;

        while (one > 0) { // 1
            if (Objects.equals(split[start], "1")) {
                split[start] = "-1";
                one--;
            }

            start++;
        }

        while (zero > 0) { // 1
            if (Objects.equals(split[end], "0")) {
                split[end] = "-1";
                zero--;
            }

            end--;
        }
    }
}
