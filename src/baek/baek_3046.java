package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baek_3046 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int R1, R2, S;

        String token[] = br.readLine().split(" ");
        R1 = Integer.parseInt(token[0]);
        S = Integer.parseInt(token[1]);

        System.out.println((S*2)-R1);


    }
}
