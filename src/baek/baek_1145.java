package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class baek_1145 {

    static int[] list = new int[5];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String token[] = br.readLine().split(" ");
        int N = 5;
        for(int i =0; i<N; i++){
            list[i] = Integer.parseInt(token[i]);
        }

        Arrays.sort(list);
        int min = list[0];

        int cnt =0;
        while (true){
            for(int i=0; i<N; i++){
                if(min % list[i] ==0) {
                    cnt++;
                }
            }

            if (cnt >= 3){
                break;
            }

            cnt = 0;
            min++;
        }
        System.out.println(min);
    }
}
