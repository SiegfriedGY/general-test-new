package oop;

import others.StaticBlock;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class StaticBlockTest {

//    static String str = "aaa";
//    static int a;

    private String str1 = "aaa";
    private final Map<String, Integer> myMap = new HashMap<>();

    private void changeNonStaticFieldValue (String suffix) {
        str1 += suffix;
        System.out.println(str1);

        myMap.put(suffix, 1);
        System.out.println(myMap);
    }

    public static void main(String[] args) {
//        System.out.println(str);
//        str = LocalDate.now().toString();
//        System.out.println(str);
//
//        System.out.println(a);
//        a = 100;
//        System.out.println(a);

        StaticBlockTest test = new StaticBlockTest();
        test.changeNonStaticFieldValue("bbb");
        test.changeNonStaticFieldValue("ccc");
        System.out.println(test.str1);

    }
}
