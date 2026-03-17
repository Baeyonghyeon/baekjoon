package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class baek_1786 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String parent = br.readLine();
        String pattern = br.readLine();
        int[] pi = makeTable(pattern);
        System.out.println(Arrays.toString(pi));

        kmp(pi, parent, pattern);
    }

    public static int[] kmp(int[] table, String parent, String pattern) {
        int idx = 0;

        for (int i = 0; i < parent.length(); i++) {
            while (idx > 0 && parent.charAt(i) != pattern.charAt(idx)) {
                idx = table[--idx];
            }

            if (pattern.charAt(i) == pattern.charAt(idx)) {
                idx++;
            }
        }

        return null;
    }

    public static int[] makeTable(String pattern) {
        int[] table = new int[pattern.length()];
        int idx = 0;

        for (int i = 1; i < pattern.length(); i++) {
            while (idx > 0 && pattern.charAt(i) != pattern.charAt(idx)) {
                idx = table[--idx];
            }

            if (pattern.charAt(i) == pattern.charAt(idx)) {
                table[i] = ++idx;
            }
        }

        return table;
    }
}
