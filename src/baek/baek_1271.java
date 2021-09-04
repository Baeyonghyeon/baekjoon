package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class baek_1271 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BigInteger calculate;
        BigInteger remainder;
        String token[] = br.readLine().split(" ");
        BigInteger n = new BigInteger(token[0]);
        BigInteger m = new BigInteger(token[1]);    //생명체 수

        calculate = n.divide(m);
        remainder = n.remainder(m);

        StringBuilder sb = new StringBuilder();
        sb.append(calculate).append('\n').append(remainder);
        System.out.println(sb);
    }
}
