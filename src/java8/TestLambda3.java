package java8;

import java.util.function.Consumer;

/**
 * @author Siegfried GENG
 * @date 2019/8/4 - 13:12
 */
public class TestLambda3 {

    public static void main(String[] args) {
        //1. Consumer<T> 消费型接口
        // 一个参数，没有返回值
//        happy(1000, (m) -> System.out.println("消费"+m+"元"));

    }

    public static void happy(double money, Consumer<Double> consumer){
        consumer.accept(money);
    }

}
