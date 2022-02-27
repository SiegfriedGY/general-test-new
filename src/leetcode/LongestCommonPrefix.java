package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LongestCommonPrefix {
    
    public static void main(String[] args){

        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("请输入(用逗号隔开):");
            String input = scanner.nextLine();
            while (input.length() == 0 || input == null || input.split(",").length <= 1) {
                System.out.print("输入不合法，请重新输入：");
                input = scanner.nextLine();
            }

            List<String> stringList = Arrays.asList(input.split(","));

            List<String> sortedList = stringList.stream().sorted(Comparator.comparingInt(String::length)).collect(Collectors.toList());
            System.out.println(sortedList);

            StringBuilder sb = new StringBuilder();

            String shortest = sortedList.get(0);

            outer: for (int i = 0; i < shortest.length(); i++) {
                char benchmark = shortest.charAt(i);
                for (int j = 1; j < sortedList.size(); j++) {
                    if (benchmark != sortedList.get(j).charAt(i)){
                        break outer;
                    }
                }
//                System.out.println(benchmark+"是一个共同字符！");
                sb.append(benchmark);
            }

            System.out.println("共同前缀为："+sb.toString());
        }

    }
}
