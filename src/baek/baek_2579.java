package baek;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class baek_2579 {
    /**
     *  x + 1 -> x + 2 (확정), x + 1 (이전꺼 확인해야함)
     *  x + 2 -> x + 2 (확정), x + 1 (확정)
     */

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int Score [] = new int [N+1];
        int D [][] = new int [N+1][2+1]; // D[i][j] = i번째 계단을 밟으면서 (j개 계단 연속으로 밟으면서) 가질수 있는 가장 큰 값

        // 입력
        for(int i = 1 ; i <= N ; i++) {
            Score[i] = Integer.parseInt(br.readLine());
        }

        // 초기화 점화식을 이용한 계산
        D[1][1] = Score[1];

        for(int i = 2 ; i <= N ; i++) {
            D[i][1] = Math.max(D[i][1], D[i - 2][1] + Score[i]); // 2칸 올라오면서 밟는경우 (직전 연속1칸)
            D[i][1] = Math.max(D[i][1], D[i - 2][2] + Score[i]); // 2칸 올라오면서 밟는경우 (직전 연속2칸)
            D[i][2] = Math.max(D[i][2], D[i - 1][1] + Score[i]); // 1칸 올라오면서 밟는경우 (직전 연속1칸)
            // 1칸올라가면서 연속2칸이 직전인 케이스는 없음
        }

        // 정답찾기
        System.out.println(Math.max(D[N][1],D[N][2]) + "\n");
    }
}
