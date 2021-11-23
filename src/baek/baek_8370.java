package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baek_8370 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String token[] = br.readLine().split(" ");
        int k1 = Integer.parseInt(token[0]);
        int n1 = Integer.parseInt(token[1]);
        int k2 = Integer.parseInt(token[2]);
        int n2 = Integer.parseInt(token[3]);

        System.out.println(k1*n1+k2*n2);
    }
}
