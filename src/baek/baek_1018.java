package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek_1018 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int min = 64;

        char[][] chessBoard = new char[N][M];

        for (int i = 0; i < N; i++) {
            String tokenLine = br.readLine();
            for (int j = 0; j < M; j++) {
                chessBoard[i][j] = tokenLine.charAt(j);
            }
        }

        for (int i = 0; i < N - 7; i++) {
            for (int j = 0; j < M - 7; j++) {
                min = Math.min(min, bruteForce(chessBoard, i, j));
            }
        }

        System.out.println(min);

        br.close();
    }

    public static int bruteForce(char[][] chessBoard, int N, int M) {
        int count = 0;
        char first = 'W';

        for (int i = N; i < N + 8; i++) {
            for (int j = M; j < M + 8; j++) {
                if (first != chessBoard[i][j]) {
                    count++;
                }

                if (first == 'W') {
                    first = 'B';
                } else {
                    first = 'W';
                }
            }

            if (first == 'W') {
                first = 'B';
            } else {
                first = 'W';
            }
        }

        return Math.min(count, 64 - count);
    }
}
