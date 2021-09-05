package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baek_2475 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int list[] = new int[6];
        int total = 0;
        String token[] = br.readLine().split(" ");

        for(int i = 0 ; i<5 ; i++){
            list[i] = Integer.parseInt(token[i]);
            total += Math.pow(list[i], 2); //제곱
        }
        list[5] = total % 10;

        System.out.println(list[5]);
    }
}
