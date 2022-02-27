package string_and_char_related;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * @author Siegfried GENG
 * @date 2019/8/28 - 16:49
 */
public class TestRandomStr {

    public static void main(String[] args) {

        int strNum = 5;
        int strLen = 8;

        Set<String> strSet = new HashSet<>();
        do {
            String str = generateStr(strLen);
            strSet.add(str);
        } while (strSet.size()<strNum);

        System.out.println(strSet);
    }

    private static String generateStr(int length){

        Set<Integer> indexSet = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        while ( sb.length() < length) {
            int index = new Random().nextInt(10);
            if(indexSet.add(index)){
                sb.append(index);
            }
        }
        String result = sb.toString();
//        System.out.println(result);
        return result;
    }
}
