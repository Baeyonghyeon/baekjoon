package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class baek_1837 {
    static int MAX = 1000000;
    static char[] P;
    static int K;
    static boolean[] isNotPrime;
    static List<Integer> primes = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        P = st.nextToken().toCharArray();
        K = Integer.parseInt(st.nextToken());

        isNotPrime = new boolean[MAX + 1];
        //에라토스테네스의 체
        for (int i = 2; i < MAX + 1; i++) {
            if (!isNotPrime[i]) {
                primes.add(i);
                for (int j = i * 2; j < MAX + 1; j += i) {
                    isNotPrime[j] = true;
                }
            }
        }
        for( int prime : primes){
            if(prime >= K){
                break;
            }
            if(checkIsBad(prime)){
                System.out.println("BAD");
                return;
            }
        }
        System.out.println("GOOD");


    }

    static boolean checkIsBad(int x) {
        int r = 0;
        for (int i = 0; i < P.length; i++) {
            r = (r * 10 + (P[i] - '0')) % x; //한자리씩 받아서 나누는것!
        }

        if(r==0){
            return true;
        }else {
            return false;
        }
    }
}
