package baek;

import javax.lang.model.type.ArrayType;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baek_2178 {

    static int[] moveY = {-1, 1, 0, 0};
    static int[] moveX = {0, 0, -1, 1};
    static int[][] graph;
    static boolean[][] visit;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new int[n][m];
        visit = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String[] str = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(str[j]);
            }
        }

        BFS(new int[]{0, 0});

        System.out.println(graph[n - 1][m - 1]);
    }

    static void BFS(int[] node) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(node);

        while (!q.isEmpty()) {
            int[] pollNode = q.poll();
            int y = pollNode[0];
            int x = pollNode[1];
            visit[y][x] = true;

            for (int i = 0; i < 4; i++) {
                int yi = y + moveY[i];
                int xi = x + moveX[i];

                if (xi >= 0 && yi >= 0 && xi < m && yi < n && !visit[yi][xi]) {
                    if (graph[yi][xi] != 0) {
                        q.offer(new int[]{yi, xi});
                        graph[yi][xi] = graph[y][x] + 1;
                        visit[yi][xi] = true;
                    }
                }
            }
        }

    }

}


