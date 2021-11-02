package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baek_1259 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        StringBuilder value = new StringBuilder();
        String a = new String(sb1);
        String b = new String(sb2);

        while (true){
            sb1.setLength(0);
            sb2.setLength(0);
            String str = br.readLine();
            if (str.equals("0")){
                break;
            }else{
                for(int i=0; i < str.length(); i++){  //예로 12321 이면 12까지 sb1 에 추가
                    sb1.append(str.charAt(i));
                }
                for(int i=str.length()-1; i>=0; i--){
                    sb2.append(str.charAt(i));

                }
            }
            String a1 = String.valueOf(sb1);
            String a2 = String.valueOf(sb2);

            if(a1.equals(a2)){
                value.append("yes").append("\n");
            }else {
                value.append("no").append("\n");
            }
        }

        System.out.println(value);

    }
}
