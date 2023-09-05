package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baek_20125 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        String[] map = new String[n];
        boolean bl = false;
        int x = 0;
        int y = 0;
        int leftArm = 0;
        int rightArm = 0;
        int waist = 0;
        int leftLeg = 0;
        int rightLeg = 0;

        for (int i = 0; i < n; i++) {
            map[i] = br.readLine();
        }

        for (int i = 0; i < n; i++) {
            if (!bl) {
                for (int j = 0; j < map[i].length(); j++) {
                    char loop = map[i].charAt(j);
                    if (loop == '*') {
                        x = i + 1;  //마지막 계산시 +1 해줘야함.
                        y = j;     //마지막 계산시 +1 해야함.
                        bl = true;
                    }
                }
            } else {
                break;
            }
        }
        sb.append(x + 1).append(" ").append(y + 1).append("\n");

        for (int i = y - 1; i >= 0; i--) {
            if (map[x].charAt(i) == '*') {
                leftArm++;
            }
        }
        for (int i = y + 1; i < map[x].length(); i++) {
            if (map[x].charAt(i) == '*') {
                rightArm++;
            }
        }
        boolean firstWaist = true;
        int waistX = 0;
        for (int i = x + 1; i < n; i++) {
            if (map[i].charAt(y) == '*') {
                waist++;
            }
            if (firstWaist && map[i].charAt(y) != '*') {
                waistX = i;
                firstWaist = false;
            }
        }
        for (int i = waistX + 1; i < n; i++) {
            if (map[i].charAt(y) == '*') {
                leftLeg++;
            }
        }
        for (int i = waistX; i < n; i++) {
            if (map[i].charAt(y-1) == '*') {
                leftLeg++;
            }
        }
        for (int i = waistX; i < n; i++) {
            if (map[i].charAt(y+1) == '*') {
                rightLeg++;
            }
        }

        sb.append(leftArm).append(" ").append(rightArm).append(" ").append(waist).append(" ").append(leftLeg).append(" ").append(rightLeg);

        System.out.println(sb);
    }
}
