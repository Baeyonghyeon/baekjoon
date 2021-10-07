package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baek_1212 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String token = br.readLine();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < token.length(); i++) {
            //아스키 코드를 통해 10진수 숫자로 변환시킴 '0' = 아스키코드 48
            String out = Integer.toBinaryString(token.charAt(i) - 48);

            if(out.length() == 1 && i !=0){
                out = "00"+out;
            }else if(out.length()== 2 && i !=0){
                out = "0"+out;
            }

            sb.append(out);
        }

        System.out.println(sb);
    }
}
