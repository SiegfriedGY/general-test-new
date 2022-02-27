package java8;

import java.util.stream.Stream;

public class TestReduce {

    public static void main(String[] args) {

        Integer reduce = Stream.of(1, 2, 3, 4).reduce(100, Integer::sum);
        System.out.println(reduce);

    }
}
