package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baek_2747_TopDown {
    static int[] D; //메모제이션할 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        D = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            D[i] = -1;
        }

        D[0] = 0;
        D[1] = 1;
        fibo(n);
        System.out.println(D[n]);
    }

    static int fibo(int n){
        if(D[n] != -1){ //메모제이션 배열에 값이 있다면 계산하지 않고 즉시 리턴.
            return D[n];
        }
        return D[n] = fibo(n - 2) + fibo(n - 1);
    }
}
