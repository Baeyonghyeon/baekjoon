package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class testclass {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String token[] = br.readLine().split(" ");

        System.out.println(token[0]);
        System.out.println(Integer.parseInt(token[1]));
    }
}
