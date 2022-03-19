package javaStudy.day11;

import java.util.Optional;

public class OptionalExample {
    public static void main(String[] args) {
        OptionalExample oe = new OptionalExample();
        oe.basic();
    }

    private void basic() {
        String source = "Comtin";   // source가 null이어도 ofNullable 생성자는 잘 됨

        //★★★ optional은 항상 값이 존재해야함 없으면 RuntimeException 발생 ★★★
        Optional<String> opt1 = Optional.of("kupa");        // 값이 무조건 있는 경우
        Optional<String> opt2 = Optional.ofNullable(source);  // 값이 없을 수도 있는 경우.
        Optional<String> opt3 = Optional.empty();             // 값이 없는 경우.

        System.out.println(opt1.map(String::toUpperCase).orElse(""));
        System.out.println(opt2.filter(s -> s.length() > 5).orElseGet(OptionalExample::defaultValue));
        System.out.println(opt3.orElseThrow(() -> new RuntimeException("empty")));
    }

    static String defaultValue() {
        return "default";
    }

}
