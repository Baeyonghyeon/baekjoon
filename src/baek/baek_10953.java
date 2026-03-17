package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baek_10953 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            String[] split = br.readLine().split(",");

            int a = Integer.parseInt(split[0]);
            int b = Integer.parseInt(split[1]);

            System.out.println(a + b);
        }
    }
}
