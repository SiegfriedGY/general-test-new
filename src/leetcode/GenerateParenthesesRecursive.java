package leetcode;

import java.util.*;

public class GenerateParenthesesRecursive {

    public static void main(String[] args){

        List<String> strings = generateParenthesis(5);
        for (String string : strings) {
            System.out.println(string);
        }
    }

    private static Set<String> recursiveCombine(String src){

        Set<String> stringSet = new HashSet<>();

        if (src.length()==2){
            stringSet.add(src);
            stringSet.add(String.valueOf(src.charAt(1))+String.valueOf(src.charAt(0)));
            return stringSet;
        }

        for (int i = 0; i < src.length(); i++) {
            char firstChar = src.charAt(i);
            String rest = "";
            if (i == 0){
                rest = src.substring(1, src.length());
            } else if (i==src.length()-1) {
                rest = src.substring(0, src.length()-1);
            } else {
                rest = src.substring(0,i) + src.substring(i+1, src.length());
            }
            Set<String> strings = recursiveCombine(rest);

            for (String string : strings) {
                String element = String.valueOf(firstChar).concat(string);
                stringSet.add(element);
            }
        }
        return stringSet;
    }


    public static List<String> generateParenthesis(int n) {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append("()");
        }
        System.out.println(sb);

        // 2. 产生所有可能性（递归方法）
        Set<String> strings = recursiveCombine(sb.toString());
        System.out.println("一共有"+strings.size()+"种排列可能性！");

        //4.筛除不正确的
        List<String> invalidList = new ArrayList<>();
        for (String str : strings) {
            char[] chars = str.toCharArray();
            int temp = 0;
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == '(') {
                    temp += 1;
                } else {
                    temp -= 1;
                }
                if (temp < 0) {
                    invalidList.add(str);
                    break;
                }
            }
        }
        strings.removeAll(invalidList);
        System.out.println("不正确的有" + invalidList.size() + "个，已删除完毕。。。");
        System.out.println("正确的排列有" + strings.size()+"种可能性！");
        return new ArrayList<>(strings);
    }
}
