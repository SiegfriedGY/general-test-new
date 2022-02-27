package java8;

/**
 * @author Siegfried GENG
 * @date 2019/8/4 - 12:05
 */
@FunctionalInterface
public interface MyInterface1<T, R> {
    R getValue(T t1, T t2);
}
