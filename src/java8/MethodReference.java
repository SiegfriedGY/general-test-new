package java8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class MethodReference {

    public static void main(String[] args) {

        Function<Integer, String[]> func = String[]::new;
        String[] strs = func.apply(4);
        System.out.println(strs.length);

        BiFunction<String, Object, Boolean> stringObjectBooleanBiFunction = String::equals;
        System.out.println(stringObjectBooleanBiFunction.apply("123123", 123123));

        // 数组引用
        func = String[]::new;
        String[] strs2 = func.apply(20);
        System.out.println(strs2.length);

        Supplier<List<StudentWithLongId>> userSupplier = () -> new ArrayList<>();
        List<StudentWithLongId> user = userSupplier.get();
        Supplier<List<StudentWithLongId>> userSupplier2 = ArrayList::new;    // 构造方法引用写法
        List<StudentWithLongId> user2 = userSupplier2.get();
        user2.removeIf(e->e.getId()>2);

        System.out.println(user);
        System.out.println(user2);
    }
}
