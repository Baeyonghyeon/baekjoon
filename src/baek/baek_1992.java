package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baek_1992 {
    public static int ary [][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        ary  = new int[N][N];

        //Quad tree 입력
        for(int i=0;i<8;i++){
            String token[] = br.readLine().split("");
            for (int j=0; j<token.length; j++){
                ary[i][j] = Integer.parseInt(token[j]);
            }
        }

        check(0,0,N);

    }

    static void check(int col, int row, int N){
        int value = ary[col][row];

        for(int i=0; i<N;i++) {
            for (int j = 0; j < N; j++) {
                if (ary[i][j] != value) {
                    division(col, row, N);
                    break;
                }
            }
        }
        //괄호 및 숫자추가
    }

    //4등분 하는 메소드
    static void division(int col, int row, int N){
        //1사분면
        //2사분면
        //3사분면
        //4사분면
    }

}
