package java8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author Siegfried GENG
 * @date 2019/9/2 - 21:06
 */
public class TestMethodReference {

    public static void main(String[] args) {

        Demo demo1 = new Demo();
        Demo demo2 = new Demo();

        List<Demo> demoList = new ArrayList<>();
        demoList.add(demo1);
        demoList.add(demo2);

        String name = "method1";
        demoList.stream().forEach(Demo::method1);

//        Function<String, String> myFunction =


        new Function<String, String>() {
            @Override
            public String apply(String s) {
                return "现在执行"+s;
            }
        };

        Supplier<Demo> supplier = Demo::new;
        Demo demo = supplier.get();

        Consumer<Demo> consumer = Demo::method2;
        consumer.accept(demo);

    }

}


class Demo {

    private Integer id;
    private String name;

    public Demo(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Demo() {
    }

    public void method1(){
        System.out.println("This is method1");
    }

    public void method2(){
        System.out.println("This is method2");
    }

}
