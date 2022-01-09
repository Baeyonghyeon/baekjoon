package baek;

import java.util.Scanner;

public class baek_11653 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();

        for(int i=2; i<=N; i++ ){
            if(N%i == 0){
                System.out.println(i);
                N = N/i;
                i = 1;
            }
        }

    }
}
