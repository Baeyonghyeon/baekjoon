package javastudy.day2;

public class ifExpress {
    public static void main(String[] args) {
        int month = 3;
        boolean isSpring = isSpring(month);

        if (isSpring) ; //??
        if (isSpring) System.out.println("It's warm");
        if (isSpring)
            System.out.println("The snow melts");
        if (isSpring) {
            System.out.println("Flowers bloom");
        }
        if (!isSpring) {
            System.out.println("Not spring"); //!
        }

        // 다양한_조건식();
        else문_예제();
    }

    //해당 월이 봄인가? (한국에서 봄은 3월, 4월, 5월이다).
    private static boolean isSpring(int month) {
        return month >= 3 && month <= 5;
    }

    private static void 다양한_조건식() {
        int score = 95;
        int x = 6;
        char ch = 'A';
        String str = "I am Hong";

        if (score >= 90 && score <= 100) System.out.println("A");
        if (score < 0 || score > 100) System.out.println("Not a score");
        if (x % 3 == 0 && x % 2 == 0) System.out.println("3의 배수이면서 2의 배수");
        if (ch >= 'A' && ch <= 'Z') System.out.println("알파벳 대문자");
        if (str.equals("I am Hong")) System.out.println("I am Home");
        if (str.startsWith("I am")) System.out.println("I am?");
    }

    private static void else문_예제() {
        int score = 90;
        if (score >= 0 && score <= 100) {
            System.out.println("It's score");
        } else {
            System.out.println("Not a score");
        }

        if (score >= 0 && score < 100) System.out.println("It's a score");
        else System.out.println("Not a score");

        if (score >= 0 && score <= 100)
            System.out.println("It's a score");
        else
            System.out.println("Not a score");
    }

}
