package coplet;

public class DecryptCaesarCipher {
    public static void main(String[] args) {
        String output = decryptCaesarCipher("khoor", 3);
        System.out.println(output); // --> hello

        output = decryptCaesarCipher("nzop delepd dfaazced jzf", 11);
        System.out.println(output); // --> world
    }

    public static String decryptCaesarCipher(String str, int secret) {
        if (str.length() == 0) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        char[] chars = str.toCharArray();

        for (char ch : chars) {
            if (ch == ' ') {
                sb.append(" ");
            } else if(ch < secret + 97){
                sb.append((char) ((ch+26) - secret));
            } else {
                sb.append((char) (ch - secret));
            }
        }

        return String.valueOf(sb);
    }
}
