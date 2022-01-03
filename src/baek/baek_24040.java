package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baek_24040 {
    public static Long a, b, value;
    public static boolean bl = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        long T = Integer.parseInt(br.readLine());

        for (int j = 0; j < T; j++) {
            long N = Long.parseLong(br.readLine());

            if (N % 3 == 2 || N % 9 == 0)
                sb.append("TAK").append("\n");
            else
                sb.append("NIE").append("\n");
        }

        System.out.print(sb);
    }
}
