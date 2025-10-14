package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baek_11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] ary = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            ary[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(ary);
        for (int i = 1; i < n; i++) {
            ary[i] = ary[i - 1] + ary[i];
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += ary[i];
        }

        System.out.println(sum);
    }
}
