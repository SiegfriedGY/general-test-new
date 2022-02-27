package java8;

import java.util.ArrayList;
import java.util.List;

public class TestConstantPoolLocation {

    public static String s = "Hello";

//    private static int a[];

    public static void main(String[] args) {
//        a = new int[]{1, 2, 3};
        List<String> strs = new ArrayList<>();
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            String str = s+s;
            s = str;
            strs.add(str.intern());
        }
    }
}
