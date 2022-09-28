package coplet;

public class Change {
    public static void main(String[] args) {
        // 4000원을 받았을 때 500원짜리 동전 8개를 반환합니다.
        int output1 = partTimeJob(4000);
        System.out.println(output1); // --> 8

        // 4972원을 받았을 때 500원짜리 동전 9개, 100원짜리 동전 4개, 50원짜리 동전 1개, 10원짜리 동전 2개, 1원짜리 동전 2개, 총 18개를 반환합니다.
        int output2 = partTimeJob(4972);
        System.out.println(output2); // --> 18
    }

    public static int partTimeJob(int k) {
        int count = 0;

        count += k / 500;
        k %= 500;
        count += k / 100;
        k %= 100;
        count += k / 50;
        k %= 50;
        count += k / 10;
        k %= 10;
        count += k / 5;
        k %= 5;
        count += k / 1;

        return count;
    }
}
