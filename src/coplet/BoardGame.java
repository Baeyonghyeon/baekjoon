package coplet;

import java.util.StringTokenizer;

public class BoardGame {
    public static void main(String[] args) {
        int[][] board1 = new int[][]{
                {0, 0, 0, 1},
                {1, 1, 1, 0},
                {1, 1, 0, 0},
                {0, 0, 0, 0}
        };
        Integer output1 = boardGame(board1, "RRDLLD");
        System.out.println(output1); // 4


        int[][] board2 = new int[][]{
                {0, 0, 1},
                {1, 1, 1},
                {1, 0, 0}
        };
        Integer output2 = boardGame(board2, "UUUDD");
        System.out.println(output2); // null

        int[][] board3 = new int[][]{
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0},
                {0, 0, 0, 0, 0}
        };
        Integer output3 = boardGame(board3, "DDRRRUDUDUD");
        System.out.println(output3); // 0
    }

    public static Integer boardGame(int[][] board, String operation) {
        final int X_MAX = board[0].length;
        final int Y_MAX = board.length;
        final int X_MIN = 0;
        final int Y_MIN = 0;

        int score = board[0][0];
        int x = 0;
        int y = 0;

        char[] tokens = operation.toCharArray();

        for (char token : tokens) {
            if (token == 'D') {
                x++;
                if (x > X_MAX) {
                    return null;
                }
            }
            if (token == 'U') {
                x--;
                if (x < X_MIN) {
                    return null;
                }
            }
            if (token == 'R') {
                y++;
                if (y > Y_MAX) {
                    return null;
                }
            }
            if (token == 'L') {
                y--;
                if (y < Y_MIN) {
                    return null;
                }
            }

            score += board[x][y];
        }

        return score;
    }
}