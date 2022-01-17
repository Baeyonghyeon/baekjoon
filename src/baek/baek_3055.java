package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class baek_3055 {
    static int R, C;
    static String map[][];
    static int visit[][];   //빈곳 : 0, 물 : 1 , 고슴도치 : 2
    static final int DX[] = {-1, 1, 0, 0};
    static final int DY[] = {0, 0, -1, 1};
    static int time[][];
    static int startr, startc;          //고슴도치 starting point
    static int finishr, finishc;        //비버 집
    static Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String token[] = br.readLine().split(" ");
        R = Integer.parseInt(token[0]);
        C = Integer.parseInt(token[1]);
        visit = new int[R][C];
        map = new String[R][C];
        time = new int[R][C];

        for (int i = 0; i < R; i++) {
            token = br.readLine().split("");
            for (int j = 0; j < C; j++) {
                map[i][j] = token[j];

                if (token[j].equals("*")) {          //물을 먼저 큐에 넣는다.
                    q.offer(new int[]{i, j});
                    visit[i][j] = 1;
                }
                if (token[j].equals("S")) {         //고슴도치는 값 입력이 끝나고 큐에 넣음.
                    startr = i;
                    startc = j;
                    visit[i][j] = 2;
                }
                if (token[j].equals("D")) {
                    finishr = i;
                    finishc = j;
                }
            }
        }
        br.close();
        // -------------------------------------input-------------------------------------------------

        bfs(startr, startc);

        if (time[finishr][finishc] == 0) {
            System.out.println("KAKTUS");
        } else {
            System.out.println(time[finishr][finishc]);
        }

    }

    public static void bfs(int r, int c) {
        q.offer(new int[]{r, c});

        while (!q.isEmpty()) {
            r = q.peek()[0];
            c = q.peek()[1];
            q.poll();

            for (int i = 0; i < 4; i++) {
                int ir = r + DY[i];
                int ic = c + DX[i];

                if (ir >= 0 && ic >= 0 && ir < R && ic < C) {
                    if (map[r][c].equals("*")) {
                        if ((map[ir][ic].equals(".")) && (visit[ir][ic] == 0 || visit[ir][ic] == 2)) {
                            visit[ir][ic] = 1;
                            map[ir][ic] = "*";
                            q.offer(new int[]{ir, ic});
                        }
                    } else if (map[r][c].equals(".") || map[r][c].equals("S")) {
                        if ((map[ir][ic].equals(".") || map[ir][ic].equals("D")) && visit[ir][ic] == 0) {
                            time[ir][ic] = time[r][c] + 1;
                            visit[ir][ic] = 2;
                            map[ir][ic] = "S";
                            q.offer(new int[]{ir, ic});
                        }
                    }
//                    for (int j = 0; j < map.length; j++) {
//                        System.out.println(Arrays.toString(map[j]));
//                    }


                }
            }
        }
    }
}
