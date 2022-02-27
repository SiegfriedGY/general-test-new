package leetcode;

import java.util.*;

public class TestNK {

    public static void main(String[] args){

        // 简单版，规定只有2位。
        combineSimply(7);

        //给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
//        combine(5,3);
    }

    private static List<List<Integer>> combineSimply(int n){

        List<Integer> integers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            integers.add(i+1);
        }
        System.out.println(integers);

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i = 0; i < integers.size()-1; i++) {
            
            Integer first = integers.get(i);

            for (int j = i+1; j < integers.size(); j++) {
                Integer second = integers.get(j);
                List<Integer> individualList = new ArrayList<>();
                individualList.add(first);
                individualList.add(second);
                result.add(individualList);
            }
        }
        System.out.println(result);
        System.out.println(result.size());
        return result;
    }

    public static List<List<Integer>> combine(int n, int k) {

//        int[] ints = new int[n];
//        for (int i = 0; i < ints.length; i++) {
//            ints[i] = i+1;
//        }
//        System.out.println(Arrays.toString(ints));

        List<Integer> integers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            integers.add(i+1);
        }
        System.out.println(integers);

        Set<String> stringSet = new HashSet<>();

        for (int i = 0; i < integers.size(); i++) {
            Integer begining = integers.get(i);


        }


        return null;
    }



}
