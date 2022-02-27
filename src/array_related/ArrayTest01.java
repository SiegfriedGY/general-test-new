package array_related;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 现在给出两个数
 组数组a：“1,7,9,11,13,15,17,19”
 数组b：“2,4,6,8,10”
 两个数组合并为数组c并且排序从小到大输出。
 */
public class ArrayTest01 {
    public static void main(String[] args){
        int[] a = {1,7,9,11,13,15,17,19,21,33,4,1};
        int[] b = {2,4,6,8,10};

        boolean[] booleans = new boolean[4];
        System.out.println(Arrays.toString(booleans));
//        combineAndSort(a,b);

//        int[] c = {1,3,5,3,6,7};
//        List<Integer> ints1 = Arrays.asList(1,3,5,3,6,7);
        List<Integer> ints1 = new ArrayList<>();
        ints1.add(1);
        ints1.add(3);
        ints1.add(5);
        ints1.add(3);
        ints1.add(5);
        ints1.add(7);
//        int[] d = {1,3};
//        List<Integer> ints2 = Arrays.asList(1,3);
        List<Integer> ints2 = new ArrayList<>();
        ints2.add(1);
        ints2.add(5);
        ints1.removeAll(ints2);
        System.out.println(ints1);
    }

    private static int[] arrayDifference(int[] arr1, int[] arr2){
        boolean b = Arrays.asList(arr1).removeAll(Arrays.asList(arr2));
        return arr1;
    }

    private static void combineAndSort(int[]a, int[]b){

        List<Integer> intList = new ArrayList<>();

        for (int i = 0; i < a.length; i++) {
            intList.add(a[i]);
        }

        for (int i = 0; i < b.length; i++) {
            intList.add(b[i]);
        }

        Collections.sort(intList);
        System.out.println(intList);
    }

}
