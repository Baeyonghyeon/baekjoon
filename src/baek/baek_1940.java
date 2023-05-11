package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baek_1940 {
    /**
     * 더블 포인터 문제.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] ary = new int[N];

        for (int i = 0; i < N; i++) {
            ary[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(ary);

        int start = 0;
        int end = N - 1;
        int result = 0;

        while (start < end) {
            int sum = ary[start] + ary[end];

            if(M < sum) {
                end--;
            } else if (M == sum) {
                start++;
                end--;
                result++;
            } else {
                start++;
            }
        }

        System.out.println(result);
    }
}
