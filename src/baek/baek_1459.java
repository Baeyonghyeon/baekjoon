package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baek_1459 {
    public static long x, y, w, s, total_distance;
    public static long a; //직선으로만 이동했을때 거리
    public static long b, c; //대각선을 포함한 이동 거리

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String token[] = br.readLine().split(" ");
        x = Integer.parseInt(token[0]); //집 x좌표
        y = Integer.parseInt(token[1]); //집 y좌표
        if (y < x) {
            long temp = x;
            x = y;
            y = temp;
        }
        w = Integer.parseInt(token[2]); //한블록 가는데 걸리는시간
        s = Integer.parseInt(token[3]); //대각선 가로지르는 시간

        total_distance = x + y;                  //대각선을 제외한 최단거리

        //직선 이동
        a = total_distance * w;
        //대각선 + 직선 이동
        //x y 가 둘다 짝수거나 홀수면 대각으로만 이동, 큰 수 즉 y만큼 이동 || 서로 짝홀이 틀리면 y-1 + w
        if ((y % 2 == 0 && x % 2 == 0) || (y % 2 == 1 && x % 2 == 1)) {
            b = y * s;
        } else {
            b = (y - 1) * s + w;
        }

        total_distance -= x * 2;
        c = total_distance * w + x * s;


        long min = Math.min(a, b);
        min = Math.min(min, c);
        System.out.println(min);
    }
}
