package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek_1357 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Rev(Integer.parseInt(st.nextToken()));
        int y = Rev(Integer.parseInt(st.nextToken()));

        System.out.println(Rev(x + y));
    }

    static int Rev(int n){
        String str = "";
        while (n>0){
            str += n % 10;
            n /= 10;
        }
        return Integer.parseInt(str);
    }
}
