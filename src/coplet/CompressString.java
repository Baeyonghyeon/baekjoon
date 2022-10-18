package coplet;

public class CompressString {
    public static void main(String[] args) {
        String output = compressString("abc");
        System.out.println(output); // --> "abc"

        output = compressString("wwwggoppopppp");
        System.out.println(output); // --> "3wggoppo4p"
    }

    // 빈 문자열을 입력받은 경우, 빈 문자열을 리턴해야 합니다.
    // 3개 이상 연속되는 문자만 압축합니다.
    public static String compressString(String str) {
        if (str.length() == 0) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        char[] chars = str.toCharArray();
        int count = 1;

        for (int i = 0; i < chars.length; i++) {
            if (i == chars.length - 1) {
                if (count > 2) {
                    sb.append(count).append(chars[i]);
                }else if (count == 2) {
                    sb.append(chars[i]).append(chars[i]);
                } else {
                    sb.append(chars[i]);
                }
            } else if (chars[i] == chars[i + 1]) {
                count++;
            } else if (count >= 3) {
                sb.append(count).append(chars[i]);
                count = 1;
            } else if (count == 2) {
                sb.append(chars[i]).append(chars[i]);
                count = 1;
            } else {
                sb.append(chars[i]);
                count = 1;
            }
        }

        return String.valueOf(sb);
    }
}
