package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baek_1850 {
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String token[] = br.readLine().split(" ");
        long x = Long.parseUnsignedLong(token[0]);
        long y = Long.parseUnsignedLong(token[1]);
        long cnt = gcd(x, y);
        for(int i=0; i<cnt; i++){
            sb.append("1");
        }
        System.out.println(sb);
    }
    //최대공약수 (유클리드 호제법)  x<y 가정
    public static long gcd(long x, long y) {
        if (y == 0) {
            return x;
        }
        return gcd(y, x % y);
    }
}
