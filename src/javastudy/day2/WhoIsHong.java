package javastudy.day2;

public class WhoIsHong {
    public static void main(String[] args) {

        //Java 7버전 부터 문자열도 비교할 수 있다.
        String label = "name";
        switch (label){
            case "name":
                System.out.println("홍길동");
                break;
            case "nickname":
                System.out.println("의적");
                break;
            case "organization":
                System.out.println("활빈당");
                break;
            default:
                System.out.println("출력할 수 없는 입력값이에요.");
        }

        switchcase학점(90);
    }

    private static void switchcase학점(int score){
        score /= 10;

        switch (score){
            case 9:
                System.out.println("A");
            case 8:
                System.out.println("B");
            case 7:
                System.out.println("C");
            case 6:
                System.out.println("D");
            default:
                System.out.println("F");
        }
    }
}
