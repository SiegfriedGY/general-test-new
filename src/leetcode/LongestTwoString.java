package leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 给定一个字符串数组 words，找到 elength(word[i]) * lngth(word[j]) 的最大值，并且这两个单词不含有公共字母。
 * 你可以认为每个单词只包含小写字母。如果不存在这样的两个单词，返回 0。
 * 输入: ["abcw","baz","foo","bar","xtfn","abcdef"]
 输出: 16
 解释: 这两个单词为 "abcw", "xtfn"。

 输入: ["a","ab","abc","d","cd","bcd","abcd"]
 输出: 4
 解释: 这两个单词为 "ab", "cd"。
 */
public class LongestTwoString {

    public static void main(String[] args){
        String[] words = {"abcw","baz","foo","bar","xtfn","abcdef"};
        String[] words1 = {"a","ab","abc","d","cd","bcd","abcd"};
        System.out.println(maxProduct(words));
    }

    public static int maxProduct(String[] words) {

        List<String> strings = Arrays.stream(words).sorted((x, y) -> y.length()-x.length()).collect(Collectors.toList());
        int result = 0;
        System.out.println(strings);
        for (int i = 0; i < strings.size()-1; i++) {
            String s1 = strings.get(i);
            for (int j = i+1; j < strings.size(); j++) {
                String s2 = strings.get(j);
                if (isCompletelyDifferent(s1, s2)){
                    result = Math.max(result, s1.length()*s2.length());
                    break;
                }
            }
        }
        return result;
    }

    private static boolean isCompletelyDifferent(String s1, String s2) {

        for (String s : s1.split("")) {
            if (s2.contains(s)){
                return false;
            }
        }
        return true;
    }
}
