package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baek_21921 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] ary = new int[n];
        int[] sum = new int[n];
        sum[0] = Integer.parseInt(st.nextToken());
        ary[0] = sum[0];
        for (int i = 1; i < n; i++) {
            int loop = Integer.parseInt(st.nextToken());
            sum[i] = loop + sum[i - 1];

            if (i - x >= 0) {
                ary[i] = sum[i] - sum[i - x];
            } else {
                ary[i] = sum[i];
            }
        }
//        System.out.println(Arrays.toString(ary));

        int max = Arrays.stream(ary).max().getAsInt();
        long count = Arrays.stream(ary)
                .filter(s -> s == max)
                .count();

        if (max == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(max);
            System.out.println(count);
        }

    }
}
