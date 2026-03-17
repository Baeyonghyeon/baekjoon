package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class sample {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = 2;

        for (int i = 0; i < 10; i++) {
            num = num << 1;
            System.out.println(num);
        }
    }
}
