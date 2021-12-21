package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baek_23253 {
    public static Boolean bl = true;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String token[] = br.readLine().split(" ");
        int N = Integer.parseInt(token[0]);    //교과서의 수
        int M = Integer.parseInt(token[1]);    //더미의 수

        for (int i = 0; i < M; i++) { //더미의 수 만큼 반복
            int k_case = Integer.parseInt(br.readLine());
            String token2[] = br.readLine().split(" ");

            for (int j = 0; j < token2.length-1; j++) {
                if(Integer.parseInt(token2[j]) < Integer.parseInt(token2[j+1])){
                    bl = false;
                }
            }
        }

        if(bl == true){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
    }
}
