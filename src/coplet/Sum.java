package coplet;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class Sum {

    public static void main(String[] args) {
        System.out.println(sumTo(10));
    }

    static public int sumTo(int num) {
        AtomicInteger result = new AtomicInteger();
        //TODO :
        IntStream.rangeClosed(1,num)
                .forEach( value -> {
                    result.addAndGet(value);
                });

        return result.get();
    }
}
