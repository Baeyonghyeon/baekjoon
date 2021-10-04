package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baek_1032 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        boolean bl = false;

        for (int i = 0; i < N; i++) {
            list[i] = br.readLine();  //문자 3줄 입력받음
        }

        for (int i = 0; i < list[0].length(); i++) {
            char word = list[0].charAt(i);
            bl = true;

            for (int j = 1; j < N; j++) { //두번째 문자열부터 비교하면 된다.
                if (list[j].charAt(i) != word) {
                    bl = false;
                    break;
                }
            }

            if (bl == true) {
                sb.append(word);
            } else {
                sb.append("?");
            }
        }

        System.out.println(sb);
    }
}