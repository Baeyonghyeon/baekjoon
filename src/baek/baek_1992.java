package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baek_1992 {
    public static int ary [][];
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ary  = new int[N][N];

        //Quad tree 입력
        for(int i=0;i<N;i++){
            String token[] = br.readLine().split("");
            for (int j=0; j<N; j++){
                ary[i][j] = Integer.parseInt(token[j]);
            }
        }

        check(0,0,N);
        System.out.println(sb);

    }

    //0,1 같은지 확인
    static void check(int col, int row, int N){
        int value = ary[col][row];

        for (int i = col; i < N + col; i++) {
            for (int j = row; j < N + row; j++) {
                if (ary[i][j] != value) {
                    division(col,row,N);            //4분할 하는 메소드
                    return;
                }
            }
        }
        sb.append(value);
    }

    //4등분 하는 메소드
    static void division(int col, int row, int N){
        sb.append("(");
        check(col, row, N/2);       //2사분면
        check(col, row+N/2, N/2);       //1사분면
        check(col+N/2, row, N/2);       //3사분면
        check(col+N/2, row+N/2, N/2);       //4사분면
        sb.append(")");
    }

}
