package baek;

import java.util.Scanner;

public class baek_1018 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int count = 0;
        int M = scan.nextInt(); //행
        int N = scan.nextInt(); //열
        String chess[][] = new String[M][N];
        String[] str = new String[M]; //문자열

        for(int i=0; i<M; i++){
            str[i] = scan.nextLine();
        }

        for(int j=0; j<str.length; j++){
            System.out.println(str[j]);
        }
/*

        for(int i=0 ; i<M; i++){
            for(int j=0; j<N; j++){
                chess[i][j] = String.(str[i].charAt(N)); //2차원 배열에 한글자씩 넣어준다.
                System.out.print(chess[i][j]);
            }
            System.out.println();
        }
*/
        /*
            여기부터는 체스 찾기
            String ob = chess[0][0];

        for(int i =0; i<M-8; i++){
            for(int j=0; j<N-8; j++){
                if(ob.equals('W')){
                    if(ob.equals(chess[i][j])){
                        continue;
                    }
                }else {
                    if
                }
            }
        }
         */

    }
}
