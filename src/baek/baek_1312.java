package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baek_1312 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String token[] = br.readLine().split(" ");
        int a = Integer.parseInt(token[0]);
        int b = Integer.parseInt(token[1]);
        int c = Integer.parseInt(token[2]);
        int value = a%b;

        for (int i =0; i< c-1; i++){
            value *= 10;
            value %= b;
        }

        value *= 10;
        System.out.println(value/b);
    }
}
