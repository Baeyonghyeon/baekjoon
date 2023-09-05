package baek;

import org.w3c.dom.ls.LSOutput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baek_2178_2 {
    static int[][] map;
    static boolean[][] visit;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visit = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String token[] = br.readLine().split("");

            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(token[j]);
            }
        }

        BFS(0, 0);

        System.out.println(map[N - 1][M - 1]);
    }

    private static void BFS(int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i, j});

        while (!q.isEmpty()) {
            int y = q.peek()[0];
            int x = q.poll()[1];

            visit[y][x] = true;

            for (int k = 0; k < 4; k++) {
                int xi = x + dx[k];
                int yi = y + dy[k];

                if (xi >= 0 && xi < M && yi >= 0 && yi < N) {
                    if (!visit[yi][xi] && map[yi][xi] != 0) {

                        map[yi][xi] = map[y][x] + 1;
                        q.offer(new int[]{yi, xi});
                    }
                }
            }
        }
    }
}
