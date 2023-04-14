package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek_1074 {

    static int count = 0;

    public static void main(String[] args) throws IOException {
        /**
         * 3,7,3 = 25 라고 보고 시물레이션 해보자.
         * 3이 들어갔다는 것은 8 * 8 이라는것을 알고 들어가는것. : 64
         * 4개의 사분면으로 나눴다고 치면 어디 사분면에 해당하는지 알아야 한다.
         * 1사 분면 ((2^N / 2) <=  r && r < 2^N) && (ro)
         * r/2 col 은 무조건 (2^N * 2^N) / 2 이다. 재귀할때 N을 -1 함.
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int edge = (int) Math.pow(2, N); // 한 변

        division(edge, c, r);
        System.out.println(count);
    }

    static void division(int edge, int col, int row) { //조건에 맞춰 사분면을 구하고 추가로 카운터도 증가시키면 됨.
        // 2 사분면 -> 1사분면 -> 3 ㅅ ㅏ분면 -> 4사분면 순으로
        int halfEdge = edge / 2;

        if(col == 0 && row == 0) {
            return;
        }

        if ((col < halfEdge) && (row < halfEdge)) { // 2사분면
            division(halfEdge, col, row);
        } else if ((col <= edge) && (row < halfEdge)) { // 1사분면
            count += halfEdge * halfEdge;
            division(halfEdge, col - halfEdge, row);
        } else if (col < halfEdge && row <= edge) { //3사분면
            count += edge * halfEdge;
            division(halfEdge, col, row - halfEdge);
        } else { // 4사분면
            count += halfEdge * halfEdge * 3;
            division(halfEdge, col - halfEdge, row - halfEdge);
        }
    }
}
