package coplet;

import java.util.HashMap;
import java.util.Map;

public class ConvertListToObject {
    public static void main(String[] args) {
        String[][] arr = new String[][]{
                {"make", "Ford"},
                {"model", "Mustang"},
                {"year", "1964"},
                {"make", "Bill"}
        };

        String[][] arr2 = new String[][]{};

        HashMap<String, String> output = convertListToObject(arr);
        HashMap<String, String> output2 = convertListToObject(arr2);

        System.out.println(output);
        System.out.println(output2);

    }

    private static HashMap<String, String> convertListToObject(String[][] arr) {
        HashMap<String, String> hashMap = new HashMap<>();

        if(arr.length == 0) return hashMap;

        for (int i = 0; i < arr.length; i++) {
            if(!hashMap.containsKey(arr[i][0])) {
                hashMap.put(arr[i][0], arr[i][1]);
            }
        }

        return hashMap;
    }


}
