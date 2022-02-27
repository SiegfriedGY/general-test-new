package leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class NonrepeatableSubstring {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        while(true){

            System.out.print("请输入:");
            String input = scanner.nextLine();

            List<String> resultList = new LinkedList<>();

            for (int i = 0; i < input.length()-1; i++) {

                StringBuilder sb = new StringBuilder();
                Set<Character> charSet = new HashSet<>();

                Character charNode = input.charAt(i);
                charSet.add(charNode);
                sb.append(charNode);

                for (int j = i+1; j < input.length(); j++) {

                    Character charNext = input.charAt(j);

                    if (!charSet.add(charNext)){
                        break;
                    } else {
                        sb.append(charNext);
                    }
                }
                resultList.add(sb.toString());
            }

            System.out.println(resultList);
            int longestLength = resultList.stream().sorted((x,y)->y.length()-x.length()).collect(Collectors.toList()).get(0).length();
            System.out.println("最长的长度是：" + longestLength);

        }



    }
}
