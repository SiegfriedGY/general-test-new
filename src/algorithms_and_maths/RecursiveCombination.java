package algorithms_and_maths;

import java.util.HashSet;
import java.util.Set;

public class RecursiveCombination {

    public static void main(String[] args){

        Set<String> result = recursiveCombine("abcd");
        System.out.println(result);

    }

    public static Set<String> recursiveCombine(String src){

        Set<String> stringSet = new HashSet<>();

        if (src.length() == 2){
            stringSet.add(src);
            stringSet.add(String.valueOf(src.charAt(1))+String.valueOf(src.charAt(0)));
            return stringSet;
        }

        for (int i = 0; i < src.length(); i++) {
            System.out.println("这是第" + (i+1) + "个首字母");
            char firstChar = src.charAt(i);
//            System.out.println("firstChar:" + firstChar);
            String rest = src.replaceAll(String.valueOf(firstChar),"");
            System.out.println("rest:" + rest);

            Set<String> strings = recursiveCombine(rest);

            for (String string : strings) {
                String element = String.valueOf(firstChar).concat(string);
//                System.out.println("-----------"+element);
                stringSet.add(element);
            }
        }
        System.out.println("最后共有"+stringSet.size()+"种排列方式！");
        return stringSet;
    }

}
