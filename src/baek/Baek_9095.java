package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_9095 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] result = new int[12];
        result[1] = 1;
        result[2] = 2;
        result[3] = 4;

        for (int i = 4; i < 12; i++) {
            result[i] = result[i-3] + result[i-2] + result[i-1];
        }

        for (int i = 0; i < T; i++) {
            System.out.println(result[Integer.parseInt(br.readLine())]);
        }

    }
}
