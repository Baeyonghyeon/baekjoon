package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class baek_2667 {
    static int N, DFS_cnt;
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};
    static int map[][];
    static boolean visit[][];
    static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visit = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String token[] = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(token[j]);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visit[i][j] && map[i][j] == 1) {
                    DFS_cnt = 1;   //처음 count +1증가
                    list.add(DFS(i, j));
                    //BFS(i,j);
                }
            }
        }

        Collections.sort(list);
        sb.append(list.size()).append("\n");
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i)).append("\n");
        }

        System.out.println(sb);
    }

    public static int DFS(int x, int y) {
        visit[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int ix = x + dx[i];
            int iy = y + dy[i];

            if (ix >= 0 && iy >= 0 && ix < N && iy < N) {
                if (!visit[ix][iy] && map[ix][iy] == 1) {
                    DFS_cnt++;
                    DFS(ix, iy);
                }
            }
        }
        return DFS_cnt;
    }

    public static void BFS(int x, int y) {

    }
}
