package coplet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class Carry {
    public static void main(String[] args) {
        int output = movingStuff(new int[]{70, 50, 80, 50}, 100);
        System.out.println(output); // 3

        int output2 = movingStuff(new int[]{60, 80, 120, 90, 130}, 140);
        System.out.println(output2); // 4

        int output3 = movingStuff(new int[]{40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40}, 80);
        System.out.println(output3); // 7

        int output4 = movingStuff(new int[]{42, 25, 60, 73, 103, 167}, 187);
        System.out.println(output4); // 4
    }

    public static int movingStuff(int[] stuff, int limit) {
        boolean[] visit = new boolean[stuff.length];
        Arrays.fill(visit, false);
        Arrays.sort(stuff);
        int result = 0;

        for (int i = 0; i < stuff.length; i++) {
            if (!visit[i]) {
                int minValue = stuff[i];
                visit[i] = true;

                for (int j = stuff.length - 1; j >= 0; j--) {
                    int maxValue = stuff[j];
                    if (!visit[j] && (minValue + maxValue) <= limit) {
                        visit[j] = true;

                        if (visit[i + 1]) i++;
                        break;
                    }
                }
            } else {
                continue;
            }
            result++;
            System.out.println(Arrays.toString(visit));
        }
        return result;
    }
}
