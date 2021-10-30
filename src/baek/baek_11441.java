package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baek_11441 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        String token[] = br.readLine().split(" ");
        int sum[] = new int[N+1];
        sum[0] = 0;

        for (int i = 1; i < N+1; i++) {
            sum[i] = sum[i-1]+Integer.parseInt(token[i-1]);
        }

        int M = Integer.parseInt(br.readLine());
        for (int k = 0; k < M; k++) {
            String token2[] = br.readLine().split(" ");
            int i = Integer.parseInt(token2[0]);
            int j = Integer.parseInt(token2[1]);

            sb.append(sum[j]-sum[i-1]).append("\n");
        }

        System.out.println(sb);

    }
}
