package coplet;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterOddNumbers {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

        List<Integer> evenNumber = list.stream()
                .filter((l) -> l % 2 == 0)
                .collect(Collectors.toList());

        System.out.println(evenNumber);
    }

}
