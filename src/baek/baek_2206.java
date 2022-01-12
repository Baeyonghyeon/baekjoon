package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class baek_2206 {
    static int N, M;
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};
    //wall == 0일 경우 visit[][][0] = true
    //wall == 1일 경우 visit[][][1] = true
    static boolean visit[][][];
    static int map[][];
    static int count[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String token[] = br.readLine().split(" ");
        N = Integer.parseInt(token[0]);
        M = Integer.parseInt(token[1]);
        map = new int[N][M];
        visit = new boolean[N][M][2];
        count = new int[N][M];

        for (int i = 0; i < N; i++) {
            token = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(token[j]);
            }
        }

        BFS(0, 0, 0);

        if(count[N-1][M-1] == 0 && N!=1 && M !=1){
            System.out.println(-1);
        }else if(N==1 && M==1){
            System.out.println(1);
        }
        else{
            System.out.println(count[N - 1][M - 1]+1);
        }


    }

    public static void BFS(int x, int y, int wall) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y, wall});
        visit[x][y][0] = true;

        while (!q.isEmpty()) {
            x = q.peek()[0];
            y = q.peek()[1];
            wall = q.peek()[2];
            q.poll();

            if(x == N-1 && y == M-1){
                break;
            }

            for (int i = 0; i < 4; i++) {
                int ix = x + dx[i];
                int iy = y + dy[i];

                if (ix >= 0 && iy >= 0 && ix < N && iy < M) {
                    if(visit[ix][iy][1] == false && wall == 0 && map[ix][iy] == 0) {
                        count[ix][iy] = count[x][y]+1;
                        visit[ix][iy][1] = true;
                        q.offer(new int[]{ix, iy, wall});

                    } else if (!visit[ix][iy][0] && map[ix][iy] == 1 && wall == 0) {
                        visit[ix][iy][0] = true;
                        wall++;
                        count[ix][iy] = count[x][y] + 1;
                        q.offer(new int[]{ix, iy, wall});
                        wall = 0;
                    } else if (!visit[ix][iy][0] && map[ix][iy] == 0) {
                        visit[ix][iy][0] = true;
                        count[ix][iy] = count[x][y] + 1;
                        q.offer(new int[] {ix, iy, wall});
                    }
                }
            }
        }
    }
}
