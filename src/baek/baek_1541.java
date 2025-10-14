package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baek_1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split("-");

        int result = 0;

        String[] strSplit = input[0].split("\\+");

        for (String s : strSplit) {
            result += Integer.parseInt(s);
        }


        for (int i = 1; i < input.length; i++) {
            String[] splitStr = input[i].split("\\+");

            for (String s : splitStr) {
                result -= Integer.parseInt(s);
            }
        }

        System.out.println(result);
    }
}
