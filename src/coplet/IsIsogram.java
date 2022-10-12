package coplet;

import java.util.Arrays;

public class IsIsogram {
    public static void main(String[] args) {
        boolean output = isIsogram("aba");
        System.out.println(output); // false

        output = isIsogram("Dermatoglyphics");
        System.out.println(output); // true

        output = isIsogram("moOse");
        System.out.println(output); // false
    }

    public static boolean isIsogram(String str) {
        str = str.toUpperCase();
        char[] chars = str.toCharArray();
        boolean[] visit = new boolean[25];
        Arrays.fill(visit, false);

        for (char ch : chars) {
            if (visit[ch - 65]) {
                return false;
            }

            visit[ch-65] = true;
        }

        return true;
    }
}
