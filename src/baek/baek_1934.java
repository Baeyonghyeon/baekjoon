package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baek_1934 {
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String token[] = br.readLine().split(" ");
            int x = Integer.parseInt(token[0]);
            int y = Integer.parseInt(token[1]);
            sb.append(lcm(x,y)).append("\n");
        }
        System.out.println(sb);
    }

    //최대공약수 (유클리드 호제법)  x<y 가정
    public static int gcd(int x, int y) {
        if (y == 0) {
            return x;
        }
        return gcd(y, x % y);
    }

    //최소공배수 (0제외한 두 수의곱 / 최대공약수)
    public static int lcm(int x, int y) {
        return (x * y) / gcd(x, y);
    }
}
