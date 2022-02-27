package java8;

import com.sun.istack.internal.NotNull;

import java.lang.reflect.Method;

/**
 * @author Siegfried GENG
 * @date 2019/8/5 - 15:53
 */
public class TestAnnotation {

    private @NotNull Object obj = null;

    public static void main(String[] args) {
        try {
            Class<?> testAnnotation = Class.forName("java8.TestAnnotation");
            Method[] declaredMethods = testAnnotation.getDeclaredMethods();
            for (Method declaredMethod : declaredMethods) {
//                System.out.println(declaredMethod.getName());
                System.out.println(declaredMethod.getAnnotationsByType(MyAnnotation.class));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
    
    @MyAnnotation("hello1")
//    @MyAnnotation("hello2")
    public void show(){
        System.out.println("啊啊啊啊");
    }
}
