package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class baek_9324 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int countlist[] = new int[26]; //대문자이기 때문에 -65 해서 계산해준다.
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String M = br.readLine();
            Arrays.fill(countlist, 0);
            boolean bl = true;

            for (int j = 0; j < M.length(); j++) {
                int chr = M.charAt(j);
                countlist[chr-65]++;

                if (countlist[chr-65] == 3) {
                    if(j+1 == M.length() || M.charAt(j) != M.charAt(j+1)){
                        bl = false;
                        break;
                    }else{
                        j++;
                        countlist[chr-65] = 0;
                    }

                }
            }

            if(bl == true){
                sb.append("OK").append("\n");
            }else {
                sb.append("FAKE").append("\n");
            }
        }
        System.out.println(sb);
    }
}
