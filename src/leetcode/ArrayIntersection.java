package leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class ArrayIntersection {

    public static void main(String[] args){

        int[] nums1 = {9,4,9,8,4,1};
        int[] nums2 = {4,9,5,1};

        List<int[]> numsList = new ArrayList<>();
        numsList.add(nums1);
        numsList.add(nums2);
        List<int[]> list = numsList.stream().sorted((x, y) -> x.length - y.length).collect(Collectors.toList());
        int[] shorter = list.get(0);
//        System.out.println(Arrays.toString(shorter));
        int[] longer = list.get(1);
//        System.out.println(Arrays.toString(longer));
        Set<Integer> integerSet = new HashSet<>();
        for (int i = 0; i < shorter.length; i++) {
            int finder = shorter[i];
            System.out.println("本次比较对象为："+finder);
            for (int j = 0; j < longer.length; j++) {
                if (finder == longer[j]){
                    System.out.println(finder + "是两个数组都有的元素...");
                    integerSet.add(finder);
                    break;
                }
            }
        }
        System.out.println("交集为:"+integerSet);

    }

}
