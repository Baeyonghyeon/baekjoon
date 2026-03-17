package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek_1149 {

    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        map = new int[N][3];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            map[i][0] = Integer.parseInt(st.nextToken());
            map[i][1] = Integer.parseInt(st.nextToken());
            map[i][2] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < N; i++) {
            map[i][0] += Math.min(map[i-1][1], map[i-1][2]);
            map[i][1] += Math.min(map[i-1][0], map[i-1][2]);
            map[i][2] += Math.min(map[i-1][0], map[i-1][1]);
        }

        System.out.println(Math.min(Math.min(map[N-1][0], map[N-1][1]), map[N-1][2]));
    }
}
