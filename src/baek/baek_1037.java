package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class baek_1037 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int ary[] = new int[N];
        String token[] = br.readLine().split(" ");

        for(int i=0; i<N; i++){
            ary[i] = Integer.parseInt(token[i]);
        }
        Arrays.sort(ary);

        if(N == 1){
            System.out.println(ary[0] * ary[0]);
        }else{
            System.out.println(ary[0] * ary[ary.length-1]);
        }
    }
}
