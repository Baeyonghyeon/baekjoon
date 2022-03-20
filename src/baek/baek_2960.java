package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek_2960 {
    static int N, K, count;
    static boolean isNotPrime[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        isNotPrime = new boolean[N+1];

//        for(int i= 2; i<N; i++){
//            int n = i;
//
//            for(int j=2; j<N; j++){
//                if(n*j <= N && !isNotPrime[n*j]){
//                    isNotPrime[n*j] = true;
//                    count++;
//
//                    if(count == K){
//                        System.out.println(n*j);
//                        break;
//                    }
//                }
//            }
//        }

        for(int i= 2; i<=N; i++){
            int n = i;

            for(int j=1; j<=N; j++){
                if(n*j <= N && !isNotPrime[n*j]){
                    isNotPrime[n*j] = true;
                    count++;

                    if(count == K){
                        System.out.println(n*j);
                        break;
                    }
                }
            }
        }

    }
}
