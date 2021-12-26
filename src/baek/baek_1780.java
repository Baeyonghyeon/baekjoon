package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class baek_1780 {
    private static StringBuilder sb = new StringBuilder();
    public static int ary[][];
    public static int count[] = new int[3]; // -1, 0, 1 저장

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ary = new int[N][N];
        Arrays.fill(count, 0);

        // N * N 행렬(종이) 입력
        for (int i = 0; i < N; i++) {
            String token[] = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                ary[i][j] = Integer.parseInt(token[j]);
            }
        }

        check(0, 0, N);

        sb.append(count[2]).append("\n").append(count[0]).append("\n").append(count[1]).append("\n");
        System.out.println(sb);
    }

    static void check(int col, int row, int N) {
        int value = ary[col][row];

        for (int i = col; i < N + col; i++) {
            for (int j = row; j < N + row; j++) {
                if (ary[i][j] != value) {
                    division(col, row, N);    //4분할하는 메소드
                    return;
                }
            }
        }

        if (value == -1) {
            value = 2;
        }

        count[value]++;
    }

    static void division(int col, int row, int N) {
        //책 읽는것과 같은 순서로 이동
        check(col, row, N / 3);   //1번
        check(col, row + N / 3, N / 3);   //2번
        check(col, row + (N / 3 * 2), N / 3);   //3번
        check(col + N / 3, row, N / 3);   //4번
        check(col + N / 3, row + N / 3, N / 3);   //5번
        check(col + N / 3, row + (N / 3 * 2), N / 3);   //6번
        check(col + (N / 3 * 2), row, N / 3);   //7번
        check(col + (N / 3 * 2), row + N / 3, N / 3);   //8번
        check(col + (N / 3 * 2), row + (N / 3 * 2), N / 3);   //9번
    }
}
