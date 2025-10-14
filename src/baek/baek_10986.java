package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek_10986 {

    static int[] sum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        sum = new int[N+1];
        st = new StringTokenizer(br.readLine());
        int count = 0;

        for (int i = 1; i < N; i++) {
            sum[i] = Integer.parseInt(st.nextToken()) + sum[i - 1];
        }

        for (int i = 1; i <= N; i++) {
            int current = sum[i];
            for (int j = i; j <= N; j++) {
                if(sum[j] % M == 0) count++;
                sum[j] -= current;
            }
        }

        System.out.println(count);
    }
}
