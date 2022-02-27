package string_and_char_related;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CountEachCharInAString {

    public static void main(String[] args){

        String src = "aaaabbbcccccdeefffffffffzzq";
        System.out.println(count(src));

    }

    public static Map<Character, Integer> count(String src){

        Map<Character, Integer> result = new HashMap<>();
        char[] chars = src.toCharArray();
        Set<Character> charSet = new HashSet<>();
        for (int i = 0; i < chars.length; i++) {
            charSet.add(chars[i]);
        }
        System.out.println(charSet + " 该String中不重复字符共" + charSet.size() + "个");
        for (Character character : charSet) {
            int count = 0;
            for (int i = 0; i < chars.length; i++) {
                if (character == chars[i]){
                    count ++;
                }
            }
            System.out.println("字符"+character+"出现了"+count+"次");
            result.put(character, count);
        }

        return result;
    }

}
