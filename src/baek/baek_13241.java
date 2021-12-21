package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baek_13241 {
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String token[] = br.readLine().split(" ");
        long x = Long.parseLong(token[0]);
        long y = Long.parseLong(token[1]);
        sb.append(lcm(x, y));
        System.out.println(sb);
    }

    //최대공약수 (유클리드 호제법)  x<y 가정
    public static long gcd(long x, long y) {
        if (y == 0) {
            return x;
        }
        return gcd(y, x % y);
    }

    //최소공배수 (0제외한 두 수의곱 / 최대공약수)
    public static long lcm(long x, long y) {
        return (x * y) / gcd(x, y);
    }
}
