package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baek_5585 {
    public static int pay, count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        pay = 1000 - Integer.parseInt(br.readLine());
        count = 0;

        count += counting(500);
        pay = remainder(500);
        count += counting(100);
        pay = remainder(100);
        count += counting(50);
        pay = remainder(50);
        count += counting(10);
        pay = remainder(10);
        count += counting(5);
        pay = remainder(5);
        count += counting(1);
        pay = remainder(1);

        System.out.println(count);
    }

    //리턴한 기존 거스름돈에서 제거
    static int remainder(int remain_money) {
        return pay % remain_money;
    }

    //동전개수 리턴
    static int counting(int remain_money) {
        return pay / remain_money;
    }
}
