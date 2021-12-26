package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class baek_2501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String token[] = br.readLine().split(" ");
        int N = Integer.parseInt(token[0]);
        int K = Integer.parseInt(token[1]);

        ArrayList<Integer> ary = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            if(N%i==0){
                ary.add(i);
            }
        }

        if (ary.size()>=K)
            System.out.println(ary.get(K-1));
        else
            System.out.println(0);
    }
}
