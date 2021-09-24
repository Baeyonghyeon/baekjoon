package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class kakaotest {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int stages[] = {2, 1, 2, 6, 2, 4, 3, 3};
    }

    public int[] solution(int N, int[] stages) {

        int[] answer = {};

        for (int i = 0; i < stages.length; i++) {
            int A = 0;
            int B = 0;
            for (int j = 0; j < N; j++) {
                if (stages[i] > j) { //도달한 플레이어
                    A++;
                }
                if(stages[i] > j+1){ //클리어한 플레이어
                    B++;
                }
            }
        }

        return answer;
    }
}
