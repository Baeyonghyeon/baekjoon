package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baek_2747 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int f1=0, f2=1, f3=1;
        //재귀함수로 피보나치 수열을 구현시 시간초과가 뜸
        for(int i=2; i<=N; i++) {
            f3=f1+f2;
            f1=f2;
            f2=f3;
        }
        System.out.println(f3);
    }
}
