package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baek_1236 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String token[] = br.readLine().split(" ");
        int N = Integer.parseInt(token[0]);
        int M = Integer.parseInt(token[1]);
        int col = 0;
        int row = 0;
        Boolean listary[][] = new Boolean[N][M]; // 생성시 기본값으로 false값 으로 초기화

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                if (input.charAt(M) == 'X') {
                    listary[i][j] = true;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (listary[i][j] = true) {
                    row++;
                    break;
                }
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (listary[i][j] = true) {
                    col++;
                    break;
                }
            }
        }

        if (row > col) {
            System.out.println(row);
        } else {
            System.out.println(col);
        }


    }
}
