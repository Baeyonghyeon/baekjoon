package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class baek_1009 {

    public static StringBuilder sb = new StringBuilder();
    static int value;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int result = 1;

            String token[] = br.readLine().split(" ");
            int a = Integer.parseInt(token[0]);
            int b = Integer.parseInt(token[1]);

            if (a % 10 == 0 || a % 10 == 1 || a % 10 == 5 || a % 10 == 6) { //규칙이 한개라 바로 답 나옴
                result = a % 10;
            } else if (a % 10 == 2 || a % 10 == 3 || a % 10 == 7 || a % 10 == 8) { // 규칙이 4개
                value = b % 4;
                if (value == 0) {
                    value += 4;
                }
            } else if (a % 10 == 4 || a % 10 == 9) {     // 규칙 2개
                value = b % 2;
                if (value == 0) {
                    value += 2;
                }
            }

            if (result == 0) {
                sb.append("10").append("\n");
            } else {
                for (int j = 0; j < value; j++) {
                    result = (result * a) % 10;
                }
                sb.append(result).append("\n");
            }
        }

        System.out.println(sb);
    }
}
