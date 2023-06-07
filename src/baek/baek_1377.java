package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class baek_1377 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] ary = new int[N][2];

        for (int i = 0; i < N; i++) {
            ary[i][0] = Integer.parseInt(br.readLine());
            ary[i][1] = i;
        }

        Arrays.sort(ary, Comparator.comparingInt((int[] o) -> o[0]));

        int max = 0;

        for (int i = 0; i < N; i++) {
            max = Math.max(max, ary[i][1] - i + 1);
        }

        System.out.println(max);
    }
}
