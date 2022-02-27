package java8;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.w3c.dom.ls.LSOutput;

import java.util.Date;
import java.util.Random;
import java.util.function.*;

public class TestFunctionalInterface {
    // 四大函数式接口
    public static void main(String[] args) {

        //1. 消费型，有去无回
        Consumer<String> consumer = System.out::println;
        consumer.accept("去你妹！");

        Consumer<String> consumer1 = (e) -> System.out.println(e + "啊啊啊啊啊");
        consumer1.accept("啵啵啵啵啵啵！");

        BiConsumer<String, Integer> biConsumer = (t, u) -> System.out.println(t + "打印" + u + "次");
        biConsumer.accept("去你妹的", 3);

        //2. 供给型，无去有回
        Supplier<String> supplier = () -> new Date().toString();
        System.out.println(supplier.get());

//        Supplier<Integer> supplier1 = () -> (int)(Math.random()*10);
        Supplier<Integer> supplier1 = () -> new Random().nextInt();
        System.out.println(supplier1.get());
        System.out.println(supplier1.get());

        //3. 断言型（一个参数）
        Predicate<String> predicate1 = e -> e.length() > 3;
        System.out.println(predicate1.test("123"));
        System.out.println(predicate1.test("1234"));
        System.out.println("abcabc: " + testPredicate("abcabc", predicate1));

        Predicate<Integer> predicate3 = integer -> integer > 5;
        System.out.println("abcabc: " + testPredicate(4, predicate3));
        System.out.println("abcabc: " + testPredicate(6, predicate3));

        //4. 断言型（二个参数）
        BiPredicate<String, Integer> predicate2 = (s, i) -> s.length() > i;
        System.out.println(predicate2.test("123", 3));
        System.out.println(predicate2.test("1234", 3));

        // 5. 函数型
        Function<Integer, String> func = Object::toString;  // 两个泛型分别代表入参和返回值的类型
        System.out.println(func.apply(234));
    }

    public static <T> boolean testPredicate(T t, Predicate<T> predicate) {
        return predicate.test(t);
    }
}
