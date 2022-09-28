package coplet;

import java.util.StringTokenizer;

public class testmain {
    public static void main(String[] args) {
        String str = "string";

        StringTokenizer st = new StringTokenizer(str," ");

        while (st.hasMoreTokens()){
            System.out.println(st.nextToken());
        }
    }
}
