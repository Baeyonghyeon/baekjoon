package coplet;

import java.util.Arrays;

public class ReadVertically {
    public static void main(String[] args) {
        String[] input = new String[]{
                "hello",
                "wolrd",
        };
        String output = readVertically(input);
        System.out.println(output); // --> "hweolllrod"

        input = new String[]{
                "hi",
                "wolrd",
        };
        output = readVertically(input);
        System.out.println(output); // --> "hwiolrd"
    }

    private static String readVertically(String[] arr) {
        StringBuilder sb = new StringBuilder();
        int maxLength = Arrays.stream(arr)
                .mapToInt(String::length)
                .max()
                .getAsInt();

        for (int i = 0; i < maxLength; i++) {
            for (int j = 0; j < arr.length; j++) {
                if(arr[j].length() > i){
                    sb.append(arr[j].charAt(i));
                }
            }
        }


        return String.valueOf(sb);
    }
}
