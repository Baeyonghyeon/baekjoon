package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baek_18111 {
    /**
     * N = col , M = row, B = blocks
     * 결과 시간이 같다면 높이가 가장 높은걸로.
     * 블록 삭제 2초
     * 블록 쌓기 1초
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int[][] ground = new int[N][M];
        int min = 256;
        int max = 0;

        for (int i = 0; i < N; i++) {
            String[] loop = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                int operator = Integer.parseInt(loop[j]);
                ground[i][j] = operator;

                if (min > operator) {
                    min = operator;
                }

                if (max < operator) {
                    max = operator;
                }
            }
        }

        int[] result = new int[max + 1];
        Arrays.fill(result, Integer.MAX_VALUE);


        while (min <= max) {
            boolean isOverBlock = false;
            int baseBlock = B;
            int useBlockCount = 0;
            int time = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (min > ground[i][j]) {
                        useBlockCount += min - ground[i][j];
                        time += blockPile(min - ground[i][j]);
                    }
                    if (min < ground[i][j]) {
                        baseBlock += ground[i][j] - min;
                        time += blockDelete(ground[i][j] - min);
                    }
                }

            }

            if(useBlockCount > baseBlock) {
                isOverBlock = true;
            }

            if(!isOverBlock){
                result[min] = time;
            }

            min++;
        }

        int minResult = Integer.MAX_VALUE;
        int position = 0;

        for (int i = 0; i < result.length; i++) {
            if(minResult > result[i] || minResult == result[i]) {
                minResult = result[i];
                position = i;
            }
        }

        System.out.println(Arrays.toString(result));
        System.out.println(result[position] + " " + position);

    }

    private static int blockDelete(int blocks) {
        return blocks * 2;
    }

    private static int blockPile(int blocks) {
        return blocks;
    }
}
