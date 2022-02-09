package javaTest;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class java_Comparator {
    public static void main(String[] args) {
        Integer listA[] = {5,2,1,3,4};

        Arrays.sort(listA, Collections.reverseOrder());

        System.out.println(Arrays.toString(listA));
        // 출력 : [5, 4, 3, 2, 1]

        String listB[] = {"cherry","dolphin","elephant","bear","apple"};

        Arrays.sort(listB, Collections.reverseOrder());

        System.out.println(Arrays.toString(listB));
        // 출력 : [elephant, dolphin, cherry, bear, apple]
    }
}
