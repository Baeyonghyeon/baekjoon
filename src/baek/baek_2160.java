package baek;

import java.io.*;
import java.util.Arrays;

public class baek_2160 {

    static int n;
    static int map[][][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        map = new int[n][5][7];
        for(int i=0; i<n; i++) {
            for(int j=0; j<5; j++) {
                String a = br.readLine();
                for(int k=0; k<7; k++) {
                    map[i][j][k] = a.charAt(k);
                }
            }
        }

        int cnt=0;
        int min=Integer.MAX_VALUE,a=0,b=0;
        for(int i=0; i<n; i++) { // 2) 그림 개수마다 비교
            for(int j=i+1; j<n; j++) {//2)
                cnt=0;
                for(int x=0; x<5; x++) { // 3) 한그림이 다를경우 cnt++
                    for(int y=0; y<7; y++) {
                        if(map[i][x][y] != map[j][x][y]) {
                            cnt++;
                        }
                    }
                }
                if(cnt<min) { //4) 갱신될떄마다 a,b 값 입력
                    min=cnt;
                    a=i+1;
                    b=j+1;
                }
            }
        }

        bw.write(String.valueOf(a+" "+b));
        bw.flush();
    }

}
