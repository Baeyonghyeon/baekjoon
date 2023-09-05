package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baek_12919 {

    static boolean bl;
    static int stopLength;
    static String s;
    static String t;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
        t = br.readLine();
        stopLength = t.length();

        recursive(t);

        System.out.println(bl ? 1 : 0);
    }

    private static void recursive(String str) {
        if (str.equals(s)) {
            bl = true;
            return;
        }

        if (str.endsWith("A")) {
            recursive(sub(str));
        }
        if (str.startsWith("B")) {
            recursive(invertStr(str));
        }
    }

    private static String sub(String str) {
        StringBuilder sb = new StringBuilder(str);
        sb.deleteCharAt(str.length()-1);
        return String.valueOf(sb);
    }

    private static String invertStr(String str) {
        StringBuilder sb = new StringBuilder(str);
        sb.deleteCharAt(0).reverse();
        return String.valueOf(sb);
    }
}
