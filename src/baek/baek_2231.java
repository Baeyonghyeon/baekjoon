package baek;

import java.util.Scanner;

public class baek_2231 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();
        int total, result=0;

        for(int i=0; i<N; i++){

            int x= i;
            total = i;

            while(true){
                total += x%10; //자리수 더하기
                x /= 10;

                if(x == 0) break;
            }
            if(total == N){
                result=i;
                break;
            }
        }
        
        System.out.println(result);
    }
}
