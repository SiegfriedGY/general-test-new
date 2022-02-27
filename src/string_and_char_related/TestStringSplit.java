package string_and_char_related;

import java.util.Arrays;
import java.util.List;

/**
 * @author Siegfried GENG
 * @date 2019/8/13 - 1:05
 */
public class TestStringSplit {

    public static void main(String[] args) {

        String str = "aaa;bbb;ccc";
        String str1 = "aaa";
        String str2 = "aaa,bbb,ccc,ddd,";

        String[] split1 = str.split("");
        System.out.println(Arrays.toString(split1));
        String[] split = str2.split(",");
        String elenment = split[4];
        System.out.println(elenment);
        System.out.println("split.length:" + split.length);
        List<String> strings = Arrays.asList(split);
        System.out.println(strings);

        String test = "\"这就是\"";
        System.out.println(test);
    }
}
