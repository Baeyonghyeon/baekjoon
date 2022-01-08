package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class baek_14490 {
    public static ArrayList<Integer> ary = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String token[] = br.readLine().split(":");
        int n = Integer.parseInt(token[0]);
        int m = Integer.parseInt(token[1]);

        int min = Math.min(n,m);

        for (int i = 1; i <= Math.sqrt(min); i++) {
            if (min % i == 0) {
                ary.add(i);
                if (min/i != i){
                    ary.add(min/i);
                }
            }
        }
        Collections.sort(ary);

        for(int i=ary.size()-1; i >= 0; i--){
            if(n % ary.get(i) == 0 && m % ary.get(i) == 0){
                n = n / ary.get(i);
                m = m / ary.get(i);
            }
        }

        System.out.println(n+":"+m);

    }
}
