package TEST;

import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {

        Map<String , Object> testMap = new HashMap<>();
        testMap.put("userId", 1);

        Long userId = Long.valueOf((Integer) testMap.get("userId"));

        System.out.println(userId);
    }
}