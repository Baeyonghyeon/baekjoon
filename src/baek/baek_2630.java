package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class baek_2630 {
    public static int ary[][];
    public static int count[] = new int[2];       //0 White, 1 Blue 저장

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        ary = new int[N][N];
        Arrays.fill(count, 0);

        // N * N 종이(행렬) 입력
        for (int i = 0; i < N; i++) {
            String token[] = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                ary[i][j] = Integer.parseInt(token[j]);
            }
        }

        check(0, 0, N);

        sb.append(count[0]).append("\n").append(count[1]);
        System.out.print(sb);
    }

    //색종이가 같은색인지 확인
    static void check(int col, int row, int N) {
        int value = ary[col][row];      //첫번째 원소랑 계속 비교

        for (int i = col; i < N + col; i++) {
            for (int j = row; j < N + row; j++) {
                if (ary[i][j] != value) {
                    division(col,row,N);
                    return;
                }
            }
        }
        count[value]++;
    }

    //4분할
    static void division(int col, int row, int N){
        check(col, row+ N / 2, N / 2);                 //1사분면
        check(col, row, N / 2);                             //2사분면
        check(col + N / 2, row, N / 2);                 //3사분면
        check(col + N / 2, row + N / 2, N / 2);    //4사분면
    }

}
