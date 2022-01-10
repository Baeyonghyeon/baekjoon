package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class baek_7569 {
    static int N, M, H;
    static int map[][][];
    static boolean visit[][][];
    static int dx[] = {0, 0, -1, 1, 0, 0};
    static int dy[] = {0, 0, 0, 0, -1, 1};
    static int dh[] = {-1, 1, 0, 0, 0, 0};
    static Queue<int []> q = new LinkedList<>();
    static boolean bl = true;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String token[] = br.readLine().split(" ");
        M = Integer.parseInt(token[0]); //가로
        N = Integer.parseInt(token[1]); //세로
        H = Integer.parseInt(token[2]); //높이
        map = new int[H][N][M];
        visit = new boolean[H][N][M];

        for(int i=0; i<H; i++){
            for(int j=0; j<N; j++){
                token = br.readLine().split(" ");
                for(int k=0; k<M; k++){
                    map[i][j][k] = Integer.parseInt(token[k]);
                    if(map[i][j][k] == 1) q.offer(new int[] {i,j,k});
                }
            }
        }

        BFS();
        check();

        if(bl){
            System.out.println(max-1);
        }else{
            System.out.println(-1);
        }

    }

    public static void BFS(){
        while (!q.isEmpty()){
            int h = q.peek()[0];
            int x = q.peek()[1];
            int y = q.peek()[2];
            visit[h][x][y] = true;
            q.poll();

            for(int i=0; i<6; i++){
                int ih = h + dh[i];
                int ix = x + dx[i];
                int iy = y + dy[i];

                if(ih >= 0 && ix >= 0 && iy >= 0 && ih < H && ix < N && iy < M){
                    if(map[ih][ix][iy] == 0 && !visit[ih][ix][iy]){
                        map[ih][ix][iy] = map[h][x][y] + 1;
                        visit[ih][ix][iy] = true;
                        q.offer(new int[] {ih,ix,iy});
                    }
                }
            }
        }
    }

    public static void check(){
        for(int i=0; i<H; i++){
            for(int j=0; j<N; j++){
                for(int k=0; k<M; k++){
                    if(map[i][j][k] == 0){
                        bl = false;
                        break;
                    }
                    if(map[i][j][k] > max) max = map[i][j][k];
                }
            }
        }
    }
}
