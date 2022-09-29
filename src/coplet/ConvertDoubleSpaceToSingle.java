package coplet;

public class ConvertDoubleSpaceToSingle {
    public static void main(String[] args) {
        String output = convertDoubleSpaceToSingle("string  with  double  spaces");
        System.out.println(output); // --> "string with double spaces"
    }

    private static String convertDoubleSpaceToSingle(String str) {
        StringBuilder sb = new StringBuilder();

        // 앞글자가 공백이고 현재 위치도 공백이면 continue.
        for (int i = 0; i < str.length(); i++) {

            if (i == 0) {
                sb.append(str.charAt(i));
            } else if (str.charAt(i) == ' ' && str.charAt(i - 1) == ' ') {
                continue;
            } else {
                sb.append(str.charAt(i));
            }
        }

        return String.valueOf(sb).strip();
    }
}