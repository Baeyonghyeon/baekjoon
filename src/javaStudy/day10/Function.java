package javaStudy.day10;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

public class Function {
    public static void main(String[] args) {
        Function f = new Function();
        f.fTest();
    }

    static void fTest(){
        List<String> list = new ArrayList<>();
        list.add("Welcome");
        list.add("NHN");
        list.add("Academy");
        // Predicate
        list.removeIf(s -> s.equals("NHN"));
        // Supplier(RandomNumberGenerator)
        Supplier<Integer> rng = () -> new Random().nextInt(10);
        // Function(UnaryOperator)
        list.replaceAll(s -> s.toLowerCase() + rng.get());
        // Consumer
        list.forEach(s -> {
            System.out.print(s + " ");
        });
    }
}
