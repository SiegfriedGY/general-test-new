package java8;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @author Siegfried GENG
 * @date 2019/8/4 - 10:44
 */
public class TestLambda {
    
    public static void main(String[] args) {

        Comparator<Integer> comparator = Integer::compare;
        TreeSet<Integer> treeSet = new TreeSet<>(comparator);
        treeSet.add(9);
        treeSet.add(8);
        treeSet.add(1);
        treeSet.add(6);
        treeSet.add(3);
        System.out.println(treeSet);

        /*
        Lambda表达式有多个语法变体：：
         */

        Runnable runnable = () -> System.out.println("去你妹");
        runnable.run();

        /*/// 1. 无参，无返回值
        TestInterface01 testInterface01 = () -> System.out.println("去你妹！");
        testInterface01.test();

        /// 2. 有一个参数，无返回值
        Consumer<String> consumer = (x) -> System.out.println(x);
        consumer.accept("去你妹！！有一个参数，无返回值");

        TestInterface02 testInterface02 = (x) -> System.out.println(x*x);
        testInterface02.test(8);

        /// 3. 只有一个参数，小括号可以省略不写
        TestInterface02 testInterface021 = x -> System.out.println(x*x);
        testInterface021.test(9);*/

        /// 4. 有两个参数，且lambda体中有多条语句，有返回值
        /// 若Lambda体有多条语句，必须用大括号括起来

        Comparator<Integer> com = (x, y) -> {
            System.out.println("函数式接口");
            return Integer.compare(x,y);
        };

        System.out.println(com.compare(5,4));

        ///  5. 若只有一条语句，即 return XXX, 则大括号和return可以一起省略。
        Comparator<Integer> com2 = Integer::compare;
        System.out.println(com2.compare(5,9));

        /*
        Lambda表达式中参数数据类型可以不写，但可以省略不写，
        因为JVM编译器可以根据上下文推断出类型，这个过程称为【类型推断】。
         */

        /**
         * 总结：
         * 左右遇一括号省；
         * 左侧推断类型省；
         */

    }
}
