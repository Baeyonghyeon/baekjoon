package coplet;

public class NumberSearch {
    public static void main(String[] args) {
        int output = numberSearch("Hello6 ");
        System.out.println(output); // --> 1

        int output2 = numberSearch("Hello6 9World 2,");
        System.out.println(output2); // --> 2
    }

    public static int numberSearch(String str) {
        if (str.length() == 0) {
            return 0;
        }
        char[] chars = str.toUpperCase().toCharArray();

        int strLength = 0;
        int sum = 0;
        for (char ch : chars) {
            if (ch > '0' && ch <= '9') {
                sum += Character.getNumericValue(ch);
            }else if (ch != ' ') {
                strLength++;
            }
        }

        double result = (double)sum / (double) strLength;
        return (int) Math.round((result * 10) / 10);
    }
}
