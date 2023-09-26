package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class baek_1911 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] ary = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            ary[i][0] = Integer.parseInt(st.nextToken());
            ary[i][1] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(ary, m));

        br.close();
    }

    public static int solution(int[][] n, int m) {

        int answer = 0;
        int range = 0;

        // 웅덩이를 정렬시켜준다.
        Arrays.sort(n, Comparator.comparingInt(o -> o[0]));
        System.out.println(n[0][0]);
        System.out.println(n[0][1]);
        System.out.println(n[1][0]);
        System.out.println(n[1][1]);
        System.out.println(n[2][0]);
        System.out.println(n[2][1]);

        // 웅덩이를 순회하면서 널빤지를 깔아준다.
        for (int[] ints : n) {
            if (ints[0] > range) {
                range = ints[0];
            }

            if (ints[1] > range) {
                while (ints[1] > range) {
                    range += m;
                    answer++;
                }
            }
        }

        return answer;
    }
}
