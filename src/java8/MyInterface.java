package java8;

/**
 * @author Siegfried GENG
 * @date 2019/8/4 - 11:54
 */
@FunctionalInterface
public interface MyInterface {

    String getValue(String str);

    default String testDefault(){
        return "This is default!!!";
    }

    static String testStatic(){
        return "这是接口中的静态方法！";
    }
}
