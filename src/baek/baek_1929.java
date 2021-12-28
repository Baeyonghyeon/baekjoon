package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baek_1929 {
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String token[] = br.readLine().split(" ");

        for(int i= Integer.parseInt(token[0]); i<= Integer.parseInt(token[1]); i++){
            Boolean bl = true;

            if (i == 1) {
                bl = false;
            }

            for(int j = 2; j<= Math.sqrt(i); j++){
                if(i % j == 0){
                    bl = false;
                    break;
                }
            }

            if(bl == true){
                sb.append(i).append("\n");
            }
        }

        System.out.print(sb);
    }
}
