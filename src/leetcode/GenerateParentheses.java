package leetcode;

import java.util.*;

public class GenerateParentheses {

    public static void main(String[] args){

        List<String> strings = generateParenthesis(5);
        for (String string : strings) {
            System.out.println(string);
        }
    }

    public static List<String> generateParenthesis(int n) {

        // 1.准备材料
        List<String> originalList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            originalList.add("(" + (i + 1));
            originalList.add(")" + (i + 1));
        }
        System.out.println(originalList);

        // 2. 产生所有可能性
        int factorial = 1;
        for (int i = 1; i <= n * 2; i++) {
            factorial *= i;
        }
        System.out.println("阶乘为：" + factorial);
        Set<String> filter = new HashSet<>();
        do {
            Collections.shuffle(originalList);
//            System.out.println("本次洗牌后的list为："+originalList);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < originalList.size(); i++) {
                sb.append(originalList.get(i));
            }
//            System.out.println(sb.toString());
            filter.add(sb.toString());
        } while (filter.size() < factorial);

        System.out.println("数量达标！！" + filter.size());

        // 3.筛除重复的
        Set<String> filter1 = new HashSet<>();
        for (String str : filter) {
            String temp = str.replaceAll("\\d", "");
//            System.out.println("去除数字之后为："+temp);
            filter1.add(temp);
//            System.out.println("添加是否成功？"+filter1.add(temp));
        }
        System.out.println("去重后的size：" + filter1.size());

        //4.筛除不正确的
        List<String> invalidList = new ArrayList<>();
        for (String str : filter1) {
            char[] chars = str.toCharArray();
            int temp = 0;
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == '(') {
                    temp += 1;
                } else {
                    temp -= 1;
                }
                if (temp < 0) {
//                    System.out.println("本次为："+str+"，予以删除！！");
                    invalidList.add(str);
                    break;
                }
            }
        }
        filter1.removeAll(invalidList);
        System.out.println("不正确的有" + invalidList.size() + "个，已删除完毕。。。");
        System.out.println("正确的size为：" + filter1.size());

        return new ArrayList<>(filter1);
    }




}
