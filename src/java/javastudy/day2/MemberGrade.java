package java.javastudy.day2;

public class MemberGrade {
    public static void main(String[] args) {
        int memberGrade = 1;

        // 기본적으로 switch문은 break문을 써야하지만 해당 예제에서는 쓰지 않았다.
        // 즉 gold 등급이면 골드와 실버등급 쿠폰을 다 받을 수 있다는 소리이다.
        // 만약 gold등급일 때 골드 쿠폰만 제공할 것이라면 break를 사용해야한다.
        // 순서대로 실행되기 때문에 순서가 중요함.
        switch (memberGrade) {
            case 3:
                grantVip();
            case 2:
                grantGold();
            case 1:
                grantSilver();
                break;
            default:
                noBenefit();
        }
    }

    private static void noBenefit() {
        //Nothing
    }

    private static void grantSilver() {
        System.out.println("Issue Silver coupons");
    }

    private static void grantGold() {
        System.out.println("Issue Gold coupons");
    }

    private static void grantVip() {
        System.out.println("Issue VIP coupons");
    }
}
