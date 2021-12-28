package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baek_2581 {
    public static int first_primenumber;
    public static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        for (int i = M; i <= N; i++) {
            Boolean bl = true;
            if (i == 1) bl = false;

            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    bl = false;
                    break;
                }
            }

            if (count == 0 && bl == true){
                first_primenumber = i;
            }

            if(bl == true){
                count += i;
            }
        }

        if (count == 0) {
            System.out.println("-1");
        } else {
            System.out.println(count);
            System.out.println(first_primenumber);
        }
    }
}
