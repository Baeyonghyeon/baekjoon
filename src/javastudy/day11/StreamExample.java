package javastudy.day11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.function.Predicate.isEqual;
import static java.util.stream.Collectors.toMap;

public class StreamExample {
    public static void main(String[] args) throws IOException {
        StreamExample ex = new StreamExample();
        //ex.readOnly();
        //ex.readOnce();
        //ex.match();
        //ex.collect();
        //ex.minMax();
        //ex.find();
        //ex.reduce();
        //ex.nonTerminal();
        //ex.flatMap();
        //ex.practice();
//        ex.plus();
//        ex.concatTest();
        ex.filesLines();
    }

    private void filesLines() throws IOException {
        Path path = Paths.get("/Users/a000/IdeaProjects/beakjoon/src/javaStudy/day10");
        Stream<Path> fileStream = Files.list(path); //파일을 줄단위로 리스트로 뽑아냄
        fileStream.flatMap(this::getLines)      //단일 요소들로 변환 펼친다는 느낌.
                .forEach(System.out::println);   //포이치문..;
    }

    private Stream<String> getLines(Path f) {
        try {
            return Files.lines(f);
        } catch (IOException e) {
            return Stream.empty();
        }
    }

    private void concatTest() {
        List<String> strs1 = List.of("Jordan", "Dongmyo", "Manty");
        List<String> strs2 = List.of("Marco", "Coco", "Comtin");

        // 스트림 연결
        Stream.concat(strs1.stream(), strs2.stream())
                .forEach(System.out::println);
    }

    private void plus() {
        int sum = IntStream.rangeClosed(1, 100)
                .filter(n -> n % 2 == 1)
                .sum();

        System.out.println(sum);
    }

    private void practice() {
        List<String> messages = List.of("Welcome", "NHN", "Academy");
        int sum = messages.stream()
                .map(String::toUpperCase)
                .flatMapToInt(String::chars) //IntStream
                .peek(c -> System.out.print(c + " "))
                .sum();
        System.out.println("sum = " + sum);

    }

    private void flatMap() {
        String[][] strs = new String[][]{
                {"Welcome", "NHN", "Academy"},
                {"I", "am", "Jordan"},
                {"Nice", "to", "meet", "you"}
        };
        Stream.of(strs)
                .peek(a -> System.out.println(Arrays.toString(a)))
                //2차원 list을 1차원 으로 바꿔줌. 즉."Welcome", "NHN", "Academy"
                .flatMap(Stream::of)
                .forEach(System.out::println);

    }

    private void nonTerminal() {
        List<String> strs = List.of("Welcome", "NHN", "Academy!", "Jordan.");
        strs.stream()
                .filter(s -> s.length() > 3)
                .peek(System.out::println)
                .sorted(Comparator.reverseOrder())
                .map(String::toLowerCase)
                .skip(1)
                .limit(3)
                .flatMapToInt(String::chars)
                .forEach(c -> System.out.println((char) c));
    }

    private void reduce() {
        List<String> strs = List.of("Welcome", "NHN", "NHN", "Academy", "Academy");
        String concat = strs.stream()
                .distinct()
                .reduce((result, element) -> result + " " + element)
                .orElse("");
        System.out.println("concat: " + concat);

        int specialStrLength = strs.stream()
                .filter(s -> s.length() > 3)
                .map(String::length)
                .reduce(0, Integer::sum);
        // "WelcomeAcademyAcademy".length = 21
        System.out.println("specialStrLength: " + specialStrLength);

    }

    private void find() {
        List<String> strs = List.of("Welcome", "NHN", "NHN", "Academy");
        // finaAny : findfirst 보다 성능이 더 좋으니 보통 이거 사용함
        String anyLength3 = strs.stream()
                .filter(s -> s.length() == 7)
                .findAny()
                .orElseThrow(() -> new RuntimeException("Not found exception"));
        System.out.println("findAny: " + anyLength3);
        // findFirst
        String firstLength3 = strs.stream()
                .filter(s -> s.length() == 3)
                .findFirst()
                .orElse(null);
        System.out.println("findFirst: " + firstLength3);
    }

    private void minMax() {
        List<String> strs = List.of("Welcome", "NHN", "Academy");
        // count
        long count = strs.stream()
                .count();
        System.out.println("count: " + count);
        // min
        String min = strs.stream()
                .min(Comparator.comparing(String::length))
                .orElse(null);  //min이 없을경우(리스트가 비어있을경우) null출력
        System.out.println("min: " + min);
        // max
        String max = strs.stream()
                .max(String.CASE_INSENSITIVE_ORDER)
                .orElseThrow(() -> new RuntimeException("Not exists max"));
        System.out.println("max: " + max);
    }

    private void collect() {
        List<String> strs = List.of("Welcome", "NHN", "NHN", "Academy");
        // list
        List<String> list = strs.stream()
                .collect(Collectors.toList());
        System.out.println(list);
        // set
        Set<String> set = strs.stream()
                .collect(Collectors.toSet());
        //    .collect(Collectors.toCollection(HashSet::new));
        System.out.println(set);
        // map
        Map<String, Integer> map = strs.stream()
                .distinct() // 이것을 빼면 어떻게 될까?
//                .collect(toMap(s -> s, s -> s.length()));
                //identity() : input output이 같은 함수
                .collect(toMap(Function.identity(), String::length));
        System.out.println(map);
        // joining
        String message = strs.stream()
                .distinct() //중복요소 제거
                .collect(Collectors.joining(" ", "", "!"));
        //      .collect(Collectors.joining(" "));  // only delimiter
        System.out.println(message);
    }

    private void match() {
        List<String> strs = List.of("Welcome", "NHN", "Academy");
        // anyMatch
        boolean anyMatch = strs.stream()
                .anyMatch((value) -> value.startsWith("NHN"));
        System.out.println(anyMatch);
        // allMatch
        boolean allMatch = strs.stream()
                .allMatch((value) -> value.length() > 2);
        System.out.println(allMatch);
        // noneMatch
        boolean noneMatch = strs.stream()
                .allMatch(isEqual("Student"));
        System.out.println(noneMatch);
    }

    private void readOnce() {
        List<String> strs = List.of("Welcome", "NHN", "Academy");
        Stream<String> stream = strs.stream();
        stream.sorted().forEach(System.out::println);
        // 재사용 시도: 예외 발생
        stream.forEach(System.out::println);
        // 새로 만들어서 실행: 성공
        strs.stream().forEach(System.out::println);
    }

    private void readOnly() {
        List<String> strs = new ArrayList<>();
        strs.add("Welcome");
        strs.add("NHN");
        strs.add("Academy");

        List<String> sortedStrs = strs.stream()
                .sorted(String.CASE_INSENSITIVE_ORDER)
                .collect(Collectors.toList());
        System.out.println("strs: " + strs);
        System.out.println("sortedStrs: " + sortedStrs);

        strs.sort(String.CASE_INSENSITIVE_ORDER);
        System.out.println("After strs.sort: " + strs);
    }

}


