package java.javastudy.day10;

import java.util.*;
import java.util.function.*;
import java.util.function.Function;

import static java.util.function.Predicate.isEqual;
import static java.util.function.Predicate.not;

public class Func {
    public static void main(String[] args) {
        Func f = new Func();
//        f.basic();
//        f.primitiveVsT();
//        f.toArray();
//        f.merge();
//        f.compose();
//        f.methodReferences();
//        f.constructorMethodReferences();
        f.eq();
    }

    private void eq() {
        java.util.function.Function<Integer, String> f1 = String::valueOf;
        java.util.function.Function<Integer, String> f2 = String::valueOf;
        IntFunction<String> f3 = String::valueOf;

        System.out.println("f1.equals(f1): " + (f1.equals(f1)));
        System.out.println("f1 == f2: " + (f1 == f2));
        System.out.println("f1.equals(f2): " + f1.equals(f2));
        System.out.println("f1 == f3: " + (f1 == f3));
        System.out.println("f1.equals(f3): " + f1.equals(f3));

        System.out.println("f1: " + f1);
        System.out.println("f2: " + f2);
        System.out.println("f3: " + f3);
    }

    private void constructorMethodReferences() {
        Supplier<List<String>> rs1 = () -> new ArrayList();
        Supplier<List<String>> rs2 = ArrayList::new; // 공변(ArrayList extends List)
        java.util.function.Function<Integer, List<String>> rs3 = capa -> new ArrayList<>(capa);
        java.util.function.Function<Integer, List<String>> rs4 = ArrayList::new;
        IntFunction<List<String>> rs5 = ArrayList::new;

        java.util.function.Function<Long, Random> rf1 = (l) -> new Random(l);
        java.util.function.Function<Long, Random> rf2 = Random::new;
        LongFunction<Random> rf3 = Random::new;

        BiFunction<Integer, Float, HashMap<String, Integer>> hmf1 = (i, f) -> new HashMap(i, f);
        BiFunction<Integer, Float, HashMap<String, Integer>> hmf2 = HashMap::new;

        IntFunction<int[]> iaf1 = length -> new int[length];
        IntFunction<int[]> iaf2 = int[]::new;
        java.util.function.Function<Integer, int[]> iaf3 = int[]::new;
    }

    private void methodReferences() {
        List<String> strs = List.of("Welcome", "NHN", "Academy");
        for (String str : strs) {       // 1
            System.out.println(str);
        }
        strs.forEach(str -> System.out.println(str)); // 2
        strs.forEach(System.out::println);  // 3

        java.util.function.Function<String, Integer> lengthFunc1 = s -> s.length();  // 1
        java.util.function.Function<String, Integer> lengthFunc2 = String::length;   // 2

        BiPredicate<Object, Object> eq1 = (o1, o2) -> o1.equals(o2);
        BiPredicate<Object, Object> eq2 = Object::equals;
        BiPredicate<Object, Object> eq3 = Objects::equals;
        BiPredicate<Object, Object> eq4 = this::equals;
        Predicate<Object> notNull = not(Objects::nonNull);
        Predicate<Object> isNull = Objects::isNull;
    }

    private boolean equals(Object o1, Object o2) {
        return Objects.equals(o1, o2);
    }

    private void compose() {
        /**
         * 1.	영어 문자열을 입력 받는다.	String
         * f2.	문자열을 대문자로 변환한다	String	String
         * f3.	문자열을 문자배열(char[])로 변환한다	String	char[]
         * f4.	문자들의 모든 아스키 코드 총 합을 구한다:	char[]	Long
         * 4-1.	문자들를 아스키코드로 변환한다.	char[]	int[] : SKIP
         * 4-2.	아스키코드의 합을 구한다.	int[]	long      : SKIP
         */
        String input = "https://meeting.dooray.com/meeting/video-call/a534c300-a583-11ec-824a-9de01328ee66";
        UnaryOperator<String> f2 = String::toUpperCase;
//        Function<String, String> f2 = s -> s.toUpperCase();
        java.util.function.Function<String, char[]> f3 = String::toCharArray;
        java.util.function.Function<char[], Long> f4 = this::sumChars;
        Function<String, Long> func = f2.andThen(f3).andThen(f4);
        Long output = func.apply(input);
        System.out.println("output: " + output);
    }

    private long sumChars(char[] chs) {
        long sum = 0;
        for (char ch : chs) {
            sum += ch;
        }
        return sum;
    }

    private void merge() {
        List<Employee> emps = List.of(
                new Employee(1, "Jordan", "Dooray!"),
                new Employee(2, "Dongmyo", "Dooray!"),
                new Employee(3, "Comtin", "Dooray!"),
                new Employee(4, "Manty", "Dooray!"),
                new Employee(5, "Coco", "NHN Edu"),
                new Employee(6, "Kizoo", "NHN Academy"),
                new Employee(7, "Marco", "NHN Academy"));
        // key: departmentName, value: employee count
        Map<String, Integer> empCountByDeptMap = new HashMap<>();
        for (Employee emp : emps) {
//        Integer empCount = empCountByDeptMap.get(emp.deptName);
//        if (empCount == null) {
//            empCountByDeptMap.put(emp.deptName, 1);
//        } else {
//            empCountByDeptMap.put(emp.deptName, empCount + 1);
//        }
            empCountByDeptMap.merge(emp.deptName, 1, (o, n) -> o + n);
        }
        System.out.println(empCountByDeptMap);
    }

    private void toArray() {
        IntFunction<String[]> func = (int size) -> new String[size];
        String[] strs = List.of("Welcome", "NHN", "Academy")
                .toArray(func);    // IntFunction ??
//         .toArray(String[]::new);    // method reference(뒤에 나옴)
        System.out.println(Arrays.toString(strs));
    }

    private void primitiveVsT() {
        final int max = 100_000_000;
        // IntBinaryOperator
        int sum2 = 0;
        long startTime2 = System.nanoTime();
        IntBinaryOperator funcSum2 = (int sum, int delta) -> sum + delta;
        for (int i = 0; i < max; i++) {
            sum2 = funcSum2.applyAsInt(sum2, i);
        }
        long estimatedTime2 = System.nanoTime() - startTime2;
        System.out.printf("sum2: %,15d > %,15d%n", sum2, estimatedTime2);

        // BinaryOperator<Integer>
        Integer sum1 = Integer.valueOf(0);
        BinaryOperator<Integer> funcSum1 =
                (Integer sum, Integer delta) -> sum + delta;
        long startTime1 = System.nanoTime();
        for (int i = 0; i < max; i++) {
            sum1 = funcSum1.apply(sum1, i);
        }
        long estimatedTime1 = System.nanoTime() - startTime1;
        System.out.printf("sum1: %,15d > %,15d%n", sum1, estimatedTime1);


    }

    private void basic() {
        List<String> list = new ArrayList<>();
        list.add("Welcome");
        list.add("NHN");
        list.add("Academy");
        // Predicate: 문자열이 NHN 이면 삭제
        list.removeIf(s -> s.equals("NHN"));
        list.removeIf(isEqual("NHN"));
        // Supplier(RandomNumberGenerator): 랜덤 숫자 제공
        Supplier<Integer> rng = () -> new Random().nextInt(10);
        // Function(UnaryOperator): 소문자로 바꾸고 뒤에 랜덤 숫자 붙여서 변환
        list.replaceAll(s -> s.toLowerCase() + rng.get());
        // Consumer: 목록 요소 별로 출력(소비)
        list.forEach(s -> {
            System.out.print(s + " ");
        });
    }
}
