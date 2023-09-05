package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek_13305 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] x = new long[n - 1];
        for (int i = 0; i < n - 1; i++) {
            x[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int[] c = new int[n];
        for (int i = 0; i < n; i++) {
            c[i] = Integer.parseInt(st.nextToken());
        }

        long totalCost = 0;
        long current = c[0];
        int startPosition = 0;
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (current >= c[i]) {
                for (int j = startPosition; j < i; j++) {
                    totalCost += x[j] * current;
                }
                current = c[i];
                startPosition = i;
                count++;
            }
        }

        if (count != n - 1) {
            for (int i = startPosition; i < n-1; i++) {
                totalCost += x[i] * current;
            }
        }

        System.out.println(totalCost);
    }
}
