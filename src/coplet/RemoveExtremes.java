package coplet;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RemoveExtremes {
    public static void main(String[] args) {
        String[] output = removeExtremes(new String[]{"a", "b", "c", "def"});
        System.out.println(Arrays.toString(output)); // --> ["a"', "b"]

        output = removeExtremes(new String[]{"where", "is", "the", "longest", "word"});
        System.out.println(Arrays.toString(output)); // --> ["where", "the", "word"]
    }

    private static String[] removeExtremes(String[] arr) {
        if(arr.length == 0){
            return null;
        }

        int max = 0;
        int min = 20;
        int maxIndex = 0;
        int minIndex = 0;

        List<String> listArr = Arrays.stream(arr).collect(Collectors.toList());

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length() <= min) {
                min = arr[i].length();
                minIndex = i;

            } else if (arr[i].length() >= max) {
                max = arr[i].length();
                maxIndex = i;
            }
        }

        if (minIndex < maxIndex){
            listArr.remove(minIndex);
            listArr.remove(maxIndex-1);
        } else {
            listArr.remove(maxIndex);
            listArr.remove(minIndex-1);
        }

        return listArr.toArray(new String[0]);
    }
}
