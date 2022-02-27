package interview;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

/*
Write a function:

class Solution { public int solution(int[] A); }

that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.

For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.

Given A = [1, 2, 3], the function should return 4.

Given A = [−1, −3], the function should return 1.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..100,000];
each element of array A is an integer within the range [−1,000,000..1,000,000].
 */
    public static void main(String[] args){

//        int result = solution(new int[]{-1, 2,3, 13, 7,9,8,-19,1,69,0});
//        int result = solution(new int[]{-1, -10, -99, -7787, 0, 3, 1, 2, 5, 6, 7, 4, 9, 999, 8});
//        int result = solution(new int[]{-1, -3});
        int result = solution(new int[]{1,2,3,4,5,6,7,8,9,10, 100});
//        int result = solution(new int[]{0});

        System.out.println("结果为："+ result);

    }

    public static int solution(int[] A) {
        // write your code in Java SE 8

        List<Integer> ints = new LinkedList();
        for (int i = 0; i < A.length; i++) {
            ints.add(A[i]);
        }

        List<Integer> sortedList = ints.stream().sorted(Integer::compareTo).collect(Collectors.toList());
        System.out.println("排好序的list为："+sortedList);

        int result = 0;

        int largestNum = sortedList.get(sortedList.size()-1);
        System.out.println("最大数为："+largestNum);
        if (largestNum <= 0) {
            result = 1;
            return result;
        }

        int benchmark = 1;

        for (int i = 0; i < sortedList.size(); i++) {
            if (sortedList.get(i) >= 0) {
                benchmark = sortedList.get(i) + 1;
                break;
            }
        }
        System.out.println("判断基准数为：" + benchmark);

        result = largestNum + 1;

        for (int i = benchmark; i <= largestNum; i++) {
            if (!sortedList.contains(i)){
                System.out.println("此数为：" + i + ", 不在list中！");
                result = i;
                break;
            }
        }
        return result;

    }

}
