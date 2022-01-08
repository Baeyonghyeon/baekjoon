package baek;

import java.util.Scanner;

public class baek_1436 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();

        int num = 0;
        int count = 0;

        while (true) {
            String str = String.valueOf(num);
            if (str.contains("666")) {
                count++;
            }

            if(N == count){
                System.out.println(num);
                break;
            }
            num++;
        }
    }
}
