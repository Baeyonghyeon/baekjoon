package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baek_1904 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long prevValue1 = 2;
        long prevValue2 = 1;

        if (N == 1) {
            System.out.println(1);
        } else if (N == 2) {
            System.out.println(2);
        } else {
            long current = 0;
            for (int i = 3; i <= N; i++) {
                current = (prevValue2 + prevValue1) % 15746;
                prevValue2 = prevValue1;
                prevValue1 = current;
            }

            System.out.println(current);
        }

    }

}
