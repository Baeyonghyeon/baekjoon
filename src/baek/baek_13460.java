package baek;

import java.io.*;
import java.util.*;

public class baek_13460 {

    static char[][] graph;
    static boolean[][][][] visited;
    static int[] red;
    static int[] blue;
    static int n, m;
    static int[] yi = new int[]{1, -1, 0, 0};
    static int[] xi = new int[]{0, 0, -1, 1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new char[n][m];
        visited = new boolean[n][m][n][m];

        for (int i = 0; i < n; i++) {
            String input = br.readLine();

            for (int j = 0; j < m; j++) {
                graph[i][j] = input.charAt(j);

                if (graph[i][j] == 'R') {
                    red = new int[]{i, j};
                }

                if (graph[i][j] == 'B') {
                    blue = new int[]{i, j};
                }
            }
        }

        System.out.println(BFS());
    }

    public static int BFS() {
        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{red[0], red[1], blue[0], blue[1], 0});
        visited[red[0]][red[1]][blue[0]][blue[1]] = true;

        while (!q.isEmpty()) {
            int redY = q.peek()[0];
            int redX = q.peek()[1];
            int blueY = q.peek()[2];
            int blueX = q.peek()[3];
            int count = q.peek()[4];
            q.poll();

            if (count >= 10) continue;

            for (int i = 0; i < 4; i++) {
                int redYy = redY;
                int redXx = redX;
                int redDist = 0;
                while (graph[redYy + yi[i]][redXx + xi[i]] != '#' && graph[redYy][redXx] != 'O') {
                    redYy += yi[i];
                    redXx += xi[i];
                    redDist++;
                }

                int blueYy = blueY;
                int blueXx = blueX;
                int blueDist = 0;
                while (graph[blueYy + yi[i]][blueXx + xi[i]] != '#' && graph[blueYy][blueXx] != 'O') {
                    blueYy += yi[i];
                    blueXx += xi[i];
                    blueDist++;
                }

                if (graph[blueYy][blueXx] == 'O') continue;

                if (graph[redYy][redXx] == 'O') return count + 1;

                if (redYy == blueYy && redXx == blueXx) {
                    if (redDist > blueDist) {
                        redYy -= yi[i];
                        redXx -= xi[i];
                    } else {
                        blueYy -= yi[i];
                        blueXx -= xi[i];
                    }
                }

                if (!visited[redYy][redXx][blueYy][blueXx]) {
                    visited[redYy][redXx][blueYy][blueXx] = true;
                    q.offer(new int[]{redYy, redXx, blueYy, blueXx, count + 1});
                }
            }
        }
        return -1;
    }
}
