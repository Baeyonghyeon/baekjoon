package baek;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

public class baek_10757 { //배열로 푸는 방법도 있음
    private static BigInteger total;
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);

        BigInteger bigA = new BigInteger(scan.next());
        BigInteger bigB = new BigInteger(scan.next());

        total = bigA.add(bigB);
        System.out.println(total.toString());
    }
}
