package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Siegfried GENG
 * @date 2019/8/4 - 23:07
 */
public class TestStreamAPI1 {
    
    public static void main(String[] args) {

        /// 创建一个Stream，有四种方式
        /// 1.通过Collection提供的stream()或parallelStream()实例方法，分别获取串行流/并行流
        List<String> stringList = new ArrayList<>();
        Stream<String> stringStream = stringList.stream();
        stringStream = stringList.parallelStream();
        /// 2.通过Arrays的静态方法stream()获取一个数组流
        Stream<String> stream = Arrays.stream(new String[]{"AAA", "BBB", "CCC"});
        /// 3.通过Stream类中的静态方法of()
        Stream<String> stream1 = Stream.of("aa", "", "cccc","ddddd");
        /// 4.创建无限流
        // 两种方式：迭代/生成。略
        // 无限流一般都要进行limit(n)来进行截取，不然就是无限的，不会停止。

        /// 中间操作
//        stream1.filter((e) -> e.length()>=3).forEach(System.out::println);

        /// 惰性求值、延迟操作——单纯的中间操作不会执行任何操作，只有等到终端操作时，才会一次性执行所有中间操作

        /// 排序
        List<String> list = Arrays.asList("ccc", "aaaa","bbbbb","d","ee");
        list.stream().sorted().forEach(System.out::println);
        System.out.println("================================");
        list.stream().sorted(Comparator.comparingInt(String::length)).forEach(System.out::println);


        /// 终止操作
//        boolean b = list.stream().allMatch((e) -> e.length() > 1);
//        System.out.println(b);

        List<Integer> collect = list.stream().map(String::length).collect(Collectors.toList());
        System.out.println(collect);


    }
}
