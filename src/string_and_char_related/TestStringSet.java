package string_and_char_related;

import java.util.HashSet;
import java.util.Set;

public class TestStringSet {

    public static void main(String[] args){

        String[] strings = {"love","love","love","love","love","love","love","love","love",};

        System.out.println(strings.length);

        Set<String> stringSet = new HashSet<>();
        for (int i = 0; i < strings.length; i++) {
            stringSet.add(strings[i]);
        }
        System.out.println(stringSet);
        System.out.println("不重复单词数为:" + stringSet.size());
    }
}
