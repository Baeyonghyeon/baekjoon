package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class baek_24389 {
    static int ary[] = new int[32];
    static int yra[] = new int[32];
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String x = Integer.toBinaryString(Integer.parseInt(br.readLine()));
        int a = x.length()-1;
        Arrays.fill(yra, 1);

        for(int i = 31; i>=0 ; i--){
            if(a >= 0)ary[i] = (x.charAt(a--) - 48);
            else break;
        }

        for(int i=0; i<32; i++){
            yra[i] -= ary[i];
        }

        int carry = 1;

        for(int i=31; i>=0; i--){
            yra[i] += carry;
            yra[i] %= 2;

            if(yra[i] == 0){
                carry = 1;
            }else{
                break;
            }
        }

        for(int i=0; i<32; i++){
            if(ary[i] != yra[i]) count++;
        }

        //System.out.println(Arrays.toString(ary));
        //System.out.println(Arrays.toString(yra));
        System.out.println(count);
    }
}
