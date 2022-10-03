package coplet;

import java.util.StringTokenizer;

public class InsertDash {
    public static void main(String[] args) {
        String output = insertDash("454793");
        System.out.println(output); // --> 4547-9-3
    }

    private static String insertDash(String str) {
        if(str.length() == 0) {
            return null;
        }

        StringBuilder sb = new StringBuilder();
        String[] list = str.split("");

        for (int i = 0; i < list.length; i++) {
            sb.append(list[i]);

            if (i != list.length-1 && Integer.parseInt(list[i]) % 2 == 1 && Integer.parseInt(list[i+1]) % 2 == 1){
                sb.append("-");
            }
        }


        return String.valueOf(sb);
    }
}
