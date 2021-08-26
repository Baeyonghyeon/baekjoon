package baek;

import java.util.Scanner;

public class baek_15633 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int cnt=0;
        for (int i=1; i<=n; i++){
            if(n%i == 0){
                cnt += i;
            }
        }

        System.out.println(cnt * 5 - 24);
    }
}
