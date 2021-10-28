package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class baek_2774 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            boolean list[] = new boolean[10];
            Arrays.fill(list, false); //list false로 초기화
            int count = 0;
            String X = br.readLine();

            for (int j = 0; j < X.length(); j++) {
                if (list[Integer.parseInt(String.valueOf(X.charAt(j)))] == false){
                    list[Integer.parseInt(String.valueOf(X.charAt(j)))] = true;
                }
            }

            for (boolean loop : list) {
                if (loop == true) count++;
            }

            sb.append(count).append("\n");
        }

        System.out.println(sb);
    }
}
