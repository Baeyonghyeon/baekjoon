package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baek_2399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String list[] = br.readLine().split(" ");
        int numlist[] = new int[n];
        for(int i=0; i<n; i++){
            numlist[i] = Integer.parseInt(list[i]);
        }
        long total = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                int value = numlist[i] - numlist[j];
                total += Math.abs(value);
            }
        }

        System.out.println(total);


    }
}
