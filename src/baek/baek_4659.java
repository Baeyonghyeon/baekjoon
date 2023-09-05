package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class baek_4659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        List<String> input = new ArrayList<>();
        int[] sameCheck = new int[26];

        while (true) {
            String token = br.readLine();
            if (token.equals("end")) {
                break;
            } else {
                input.add(token);
            }
        }

        for (String loop : input) {
            Arrays.fill(sameCheck, 0);
            int vowelCount = 0;
            int consonantCount = 0;
            boolean bl = true;
            boolean bl2 = false;
            int sameInitCnt = 2;

            for (int i = 0; i < loop.length(); i++) {
                int a = loop.charAt(i) - 97;

                if (a == 0 || a == 4 || a == 8 || a == 14 || a == 20) {
                    bl2 = true;
                    vowelCount++;
                    if (consonantCount != 0) {
                        consonantCount = 0;
                    }
                } else {
                    consonantCount++;
                    if (vowelCount != 0) {
                        vowelCount = 0;
                    }
                }

                if (consonantCount == 3 || vowelCount == 3) {
                    bl = false;
                }

                if ((i != loop.length() - 1) && (loop.charAt(i + 1) == loop.charAt(i))){
                    sameCheck[a] = sameInitCnt;
                }

                for (int j = 0; j < sameCheck.length; j++) {
                    if ((sameCheck[j] >= 2) && (j != 4) && (j != 14)) {
                        bl = false;
                        break;
                    }
                }
            }

            if (bl && bl2) {
                sb.append("<").append(loop).append(">").append(" is acceptable.").append("\n");
            } else {
                sb.append("<").append(loop).append(">").append(" is not acceptable.").append("\n");
            }
        }

        System.out.println(sb);
    }
}
