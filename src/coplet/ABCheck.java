package coplet;

public class ABCheck {
    public static void main(String[] args) {
        boolean output = ABCheck("aMAJ7sBrO4CyysuoHFrgGTX");
        System.out.println(output); // --> true

    }

    public static boolean ABCheck(String str) {
        if(str.length() == 0) { return false; }
        str = str.toUpperCase();
        for(int i = 4; i < str.length(); i++) {
            if(((str.charAt(i) == 'A') && (str.charAt(i - 4) == 'B')) || ((str.charAt(i) == 'B') && (str.charAt(i - 4) == 'A'))) {
                return true;
            }
        }

        return false;
    }
}
