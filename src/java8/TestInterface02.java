package java8;

/**
 * @author Siegfried GENG
 * @date 2019/8/4 - 10:43
 */
@FunctionalInterface    /// 函数式接口的检查注解，若多于一个抽象方法，则报错。
public interface TestInterface02 {

//    void test2();
    void test(Integer integer);
}
