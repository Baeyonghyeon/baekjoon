package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class baek_2748 {
    private static long ary[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ary = new long[N+1];
        Arrays.fill(ary, -1);
        ary[0] = 0;
        ary[1] = 1;
        System.out.println(fibo(N));
    }

    public static long fibo(int n){
        if(ary[n] == -1){
            ary[n] = fibo(n-1) + fibo(n-2);
        }
        return ary[n];
    }
}
