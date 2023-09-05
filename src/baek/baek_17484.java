package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baek_17484 {
    static int[] xi = new int[]{0, 1, -1};
    static int yi = 1;
    static int[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];
        visit = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(visit[i], Integer.MAX_VALUE);
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 1; i++) {
            System.arraycopy(map[i], 0, visit[i], 0, 4);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < 3; k++) {
                    int xP = j + xi[k];
                    int yP = i + yi;
                    if (xP >= 0 && xP < m && yP < n) {
                        if (visit[i][j] + map[yP][xP] < visit[yP][xP]) {
                            visit[yP][xP] = visit[i][j] + map[yP][xP];
                        }
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(visit[i]));
        }
    }
}
