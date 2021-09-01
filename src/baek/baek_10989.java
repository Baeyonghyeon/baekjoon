package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baek_10989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int countlist[] = new int[10001]; // 0 ~ 10000

        // 배열 카운팅
        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());
            countlist[input]++;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < 10001; i++) {
            while (countlist[i] > 0){
                sb.append(i).append('\n');
                countlist[i]--;
            }
        }

        System.out.println(sb);
    }
}
