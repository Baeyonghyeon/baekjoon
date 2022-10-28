package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baek_7576 {
    static int N, M;
    static int max = 0;
    static boolean visit[][];
    static int map[][];
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {-0, 0, -1, 1};
    static Queue<int[]> q = new LinkedList<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        visit = new boolean[N][M];
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    q.offer(new int[]{i, j});
                }
            }
        }
        BFS();

        if(isUnripeTomato()){
            System.out.println(max-1);
        } else {
            System.out.println("-1");
        }

    }

    private static void BFS() {
        while (!q.isEmpty()) {
            int x = q.peek()[0];
            int y = q.peek()[1];
            q.poll();
            visit[x][y] = true;

            for (int i = 0; i < 4; i++) {
                int ix = x + dx[i];
                int iy = y + dy[i];

                if (ix >= 0 && iy >= 0 && ix < N && iy < M) {
                    if (!visit[ix][iy] && map[ix][iy] == 0) {
                        visit[ix][iy] = true;
                        map[ix][iy] = map[x][y] + 1;
                        q.offer(new int[]{ix, iy});
                    }
                }
            }
        }
    }

    private static boolean isUnripeTomato() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    return false;
                }
                if (map[i][j] > max) {
                    max = map[i][j];
                }
            }
        }
        return true;
    }


}
