package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baek_1978 {
    public static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int list[] = new int[N];
        String token[] = br.readLine().split(" ");
        for(int i=0; i<N; i++){
            Boolean bl = true;
            list[i] = Integer.parseInt(token[i]);
            if(list[i]== 1){
                bl = false;
            }
            for(int j=2; j<=Math.sqrt(list[i]); j++){
                if(list[i] % j == 0){
                    bl = false;
                    break;
                }
            }

            if(bl == true){
                count++;
            }
        }

        System.out.println(count);
    }
}
