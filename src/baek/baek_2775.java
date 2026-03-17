package baek;

import java.util.*;
import java.io.*;

public class baek_2775 {
//    private static int k, n, cnt;

    //    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//        int apartment[][] = new int[15][15];
//        for (int i = 0; i < 15; i++) { // 0층 셋팅
//            apartment[0][i] = i + 1;
//        }
//        for (int i = 0; i < 15; i++) { // 1호 셋팅
//            apartment[i][0] = 1;
//        }
//
//        cnt = scan.nextInt(); // 횟수
//
//        for (int o = 0; o < cnt; o++) {
//            k = scan.nextInt();
//            n = scan.nextInt();
//
//            for (int j = 1; j <= k; j++) { // 층
//                for (int l = 1; l < n; l++) { // 호
//                    apartment[j][l] = apartment[j][l - 1] + apartment[j - 1][l];
//                }
//            }
//            System.out.println(apartment[k][n-1]);
//        }
//
//
//
//    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int[][] D = new int[15][15];

        for (int i = 0; i < 15; i++) {
            D[i][1] = 1;
            D[0][i] = i;
        }

        for (int i = 1; i < 15; i++) {
            for (int j = 1; j < 15; j++) {
                D[i][j] = D[i][j - 1] + D[i - 1][j];
            }
        }

        for (int i = 0; i < t; i++) {
            int a = Integer.parseInt(br.readLine());
            int b = Integer.parseInt(br.readLine());

            System.out.println(D[a][b]);
        }
    }
}
