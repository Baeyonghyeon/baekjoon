package coplet;

public class firstReverse {
    public static void main(String[] args) {
        String str = "ice coffee";
        StringBuilder sb = new StringBuilder();
        sb.append(str);

        sb.reverse();
        String.valueOf(sb);
        System.out.println(sb);
    }
}
