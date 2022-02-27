package string_and_char_related;

import java.util.HashSet;
import java.util.Set;

public class RemoveRepeatedCharFromString {

    public static void main(String[] args){
        System.out.println(remove("123.abc.234.bcd"));
    }

    private static String remove(String src){

        char[] chars = src.toCharArray();
        Set<Character> characterSet = new HashSet<>();
        for (int i = 0; i < chars.length; i++) {
            characterSet.add(chars[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (Character character : characterSet) {
            sb.append(character);
        }
        return sb.toString();
    }
}
