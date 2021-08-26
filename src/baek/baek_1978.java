package baek;

import java.util.Scanner;

public class baek_1978 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int cnt=0;

        for (int i=0; i<n; i++){
            int input = scan.nextInt();
            if(input == 1 ){
                continue;
            }
            for(int j=2; j<=Math.sqrt(input);j++){
                if(input%j == 0) continue;
            }

            cnt++;
        }
        System.out.println(cnt);
    }
}
