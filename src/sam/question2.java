package sam;

import java.util.Arrays;

public class question2 {

    public void solution(int size) {
        StringBuilder sb = new StringBuilder();
        //상 하 좌 우
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        int currentX = 0;
        int currentY = 0;
        int direction = 0;
        int count = 1;
        int[][] ary = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                ary[i][j] = 0;
            }
        }

        while (count <= size * size) {

            ary[currentY][currentX] = count++;

            int nx = currentX + dx[direction];
            int ny = currentY + dy[direction];
            int nd = check(direction, nx, ny, size, ary);

            if (direction != nd) {
                currentX += dx[nd];
                currentY += dy[nd];
                direction = nd;

            } else {
                currentX = nx;
                currentY = ny;
            }
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                sb.append(ary[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println("결과값 출력 " + sb);
    }

    public int check(int d, int cx, int cy, int size, int[][] ary) {
        if (cx >= size || cx < 0 || cy >= size || cy < 0 || ary[cx][cy] != 0) {
            return (d + 1) % 4;
        }

        return d;
    }

    public static void main(String[] args) {
        // 배열의 크기 (입력 값)
        int size = 3;
        System.out.println("배열 크기 : " + size);

        question2 pg = new question2();
        pg.solution(size);
    }


}
