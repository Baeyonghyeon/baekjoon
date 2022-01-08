package baek;

import java.util.Scanner;

public class baek_1002 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        /**
         * java 는 부동소수점 타입을 정확한 값이 아니라 근사값으로 처리한다.
         * 간단한 예로 0.1 + 0.2 == 0.3 참이 아니다.
         */
        
        int testcase;
        double x1, x2, y1, y2, r1, r2;

        testcase = scan.nextInt();
        for (int i = 0; i < testcase; i++) {
            x1 = scan.nextDouble();
            y1 = scan.nextDouble();
            r1 = scan.nextDouble();
            x2 = scan.nextDouble();
            y2 = scan.nextDouble();
            r2 = scan.nextDouble();

            double distance = Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2);

            if (x1 == x2 && y1 == y2 && r1 == r2) {
                System.out.println(-1);
            } else if (distance == Math.pow(r2-r1,2) || distance == Math.pow(r2+r1,2)){
                System.out.println(1);
            }else if(distance > Math.pow(r1+r2,2) || distance < Math.pow(r2-r1,2) ){
                System.out.println(0);
            }else {
                System.out.println(2);
            }
        }
    }
}
