package java.javastudy.day10;

import java.util.Arrays;
import java.util.List;

public class LambdaExample {
    public static void main(String[] args) {
        LambdaExample e = new LambdaExample();
        e.before();
    }

    private void before() {
        List<String> names = Arrays.asList("jordan", "coco", "comtin", "manty");
        names.replaceAll(s -> s.toUpperCase());
        System.out.println(names);
    }
}
