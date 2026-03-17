package jisanStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//2
//1 2
//9881 10724

public class test {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] board = new String[11];
        board[0] = "1110111";
        board[1] = "0010100";
        board[2] = "0111011";
        board[3] = "0111110";
        board[4] = "1011100";
        board[5] = "1101110";
        board[6] = "1101111";
        board[7] = "1110100";
        board[8] = "1111111";
        board[9] = "1111110";
        board[10] = "0000000";

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int result = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            String A = st.nextToken();
            String B = st.nextToken();

            String[] cA = convertBoardInputCase(A, board);
            String[] cB = convertBoardInputCase(B, board);

            for (int j = 0; j < 5; j++) {
                result += countDifference(cA[j], cB[j]);
            }

            sb.append(result).append("\n");
        }

        System.out.println(sb);
    }

    private static int countDifference(String str1, String str2) {
        int count = 0;
        for (int i = 0; i < 7; i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                count++;
            }
        }

        return count;
    }

    private static String[] convertBoardInputCase(String input, String[] board) {
        String[] cBoard = new String[5];
        int diffCnt = 5 - input.length();
        int cnt = 0;
        while (cnt < diffCnt) {
            cBoard[cnt++] = board[10];
        }

        for (int i = 0; i < input.length() ; i++) {
            cBoard[cnt++] = board[Character.getNumericValue(input.charAt(i))];
        }

        return cBoard;
    }
}
