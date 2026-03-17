package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek_13251 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int m = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] colors = new int[m];
        int total = 0;

        for (int i = 0; i < m; i++) {
            colors[i] = Integer.parseInt(st.nextToken());
            total += colors[i];
        }

        int k = Integer.parseInt(br.readLine());

        double probability = 0.0;

        for (int i = 0; i < m; i++) {
            if (colors[i] < k) continue;

            double prob = 1.0;

            // K개를 연속으로 뽑는 확률
            for (int j = 0; j < k; j++) {
                prob *= (double) (colors[i] - j) / (total - j);
            }

            probability += prob;
        }

        System.out.println(probability);
    }
}
