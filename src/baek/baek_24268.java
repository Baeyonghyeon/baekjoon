package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class baek_24268 {
    static int check[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String token[] = br.readLine().split(" ");
        int N = Integer.parseInt(token[0])+1;
        int b = Integer.parseInt(token[1]);             //진법
        check = new int[b];
        String str;
        int value;
        int max = pow(b);

        if(N > max){
            value = -1;
        }else if(b==9 && N<44317196){
            value = 44317196;
        } else {
            while (true) {
                int n = N;
                Boolean bl = true;
                str = "";
                Arrays.fill(check, 0);
                while (n > 0) {
                    int add = (n % b);
                    if (check[add] == 0) {
                        check[add]++;
                    } else {
                        bl = false;
                        break;
                    }
                    str = add + str;
                    n /= b;
                }

                if (bl) {
                    boolean bl2 = true;
                    for (int i = 0; i < b; i++) {
                        if (check[i] != 1) {
                            bl2 = false;
                            N++;
                        }
                    }
                    if (bl2) {
                        value = Integer.parseInt(str, b);
                        break;
                    }
                } else {
                    N++;
                }
            }
        }
        System.out.println(value);

    }

    public static int pow(int x){
        int result = 0;
        int b = x-1;

        for(int i=0 ; i<x ;i++){
            result += b * Math.pow(x, b);
            b--;
        }

        return result;
    }
}
