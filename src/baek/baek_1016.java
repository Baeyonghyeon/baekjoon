package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek_1016 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());
        long indexSize = max - min;

        boolean[] isPrime = new boolean[(int) indexSize + 1];

        for (long i = 2; i * i <= max; i++) {
            long pow = i * i;
            long startIndex = min / pow;
            if (min % pow != 0) {
                startIndex++;
            }
            for (long j = startIndex; pow * j <= max; j++) {
                isPrime[(int) (j * pow - min)] = true;
            }
        }

        int count = 0;
        for (int i = 0; i <= max - min; i++) {
            if (!isPrime[i]) {
                count++;
            }
        }

        System.out.println(count);
    }
}
