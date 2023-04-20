package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baek_1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] ary = new int[N][2];
        int max = 0;
        int count = 1;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            ary[i][0] = Integer.parseInt(st.nextToken());
            ary[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(ary, (o1, o2) -> o1[1] != o2[1] ? o1[1] - o2[1] : o1[0] - o2[0]);

        int loop = ary[0][1];
        for (int j = 1; j < N; j++) {
            if (loop <= ary[j][0]) {
                loop = ary[j][1];
                count++;
            }
        }

        if (max < count) {
            max = count;
        }


        System.out.println(max);
    }


}
