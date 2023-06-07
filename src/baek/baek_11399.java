package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baek_11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] ary = new int[N];

        for (int i = 0; i < N; i++) {
            ary[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(ary);

        int result = 0;
        int sum = 0;
        for (int loop : ary) {
            sum += loop;
            result += sum;
        }

        System.out.println(result);
    }
}
