package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class baek_1427 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); //선언

        String input = bf.readLine();
        int input_len = input.length(); // 문자열 길이
        int num[] = new int[input_len];

        for (int i=0; i< input_len; i++){
            char change = input.charAt(i);
            num[i] = Character.getNumericValue(change);
        }

        Arrays.sort(num);

        for(int i=input_len; i > 0; i--){
            System.out.print(num[i-1]);
        }
    }
}
