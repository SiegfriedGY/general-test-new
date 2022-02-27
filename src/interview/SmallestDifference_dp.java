package interview;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Resolution:
 * 1. To achieve two sublists with minimal sum difference, we should let the sum of one sublist be as close as possible to half of the whole list's sum.
 * 2. Then this problem is analogous to the classical "packaging" problem, where:
 *     1)  the highest value in packaging problem is the largest sum (whole sum / 2) here, and
 *     2)  the weight of every item in packaging problem is the value of every integer here
 * 3. So dynamic programming algorithm is most suitable.
 * 4. The status transition equation is:
 *    dp[i][j] = Math.max(dp[i-1][j-intArr[i-1]] + intArr[i-1], dp[i-1][j])
 */
public class SmallestDifference_dp {

    public static void main(String[] args) {
        int[] ints1 = {2, 4, 5, 6, 7};
        int[] ints2 = {2, 5, 6, 10};
        int[] ints3 = {3, 9, 2, 3, 5};
        int[] ints4 = {15, 17, 13, 9, 8};
        int[] ints5 = {0, 2, 7, 1, 4};
        System.out.println(cal(ints3));
    }

    public static ResultObject cal(int[] intArr){

        int len = intArr.length;
        int sum = Arrays.stream(intArr).sum();
        int halfSum = sum/2;

        boolean[][] isPackedArr = new boolean[len+1][halfSum+1]; // 记录动态规划中每一次该数是否被装入背包
        boolean[] isPackedFinalArr = new boolean[len];  // 记录原数组每一个数最终是否被装入背包

        int[][] dp = new int[len+1][halfSum+1];  // 动态规划二维数组
        for (int i = 0; i < len+1; i++) {  // 为方便后续操作，二维数组第一列全部设为0
            dp[i][0] = 0;
        }
        for (int i = 0; i < halfSum+1; i++) {  // 为方便后续操作，二维数组第一行全部设为0
            dp[0][i] = 0;
        }

        // 用【动态规划】法求每一次是否将该数装入“背包”（即第一个子数组）
        for (int i = 1; i < len+1; i++) {
            for (int j = 1; j < halfSum+1; j++) {
                if (intArr[i-1]<=j){ // 说明装得下这个数，接下来要比较加此数的总和与不加此数的总和二者大小，以决定是否装入此数
//                    dp[i][j] = Math.max(dp[i-1][j-intArr[i-1]] + intArr[i-1], dp[i-1][j]);
                    int sumWithCurrentEle = dp[i-1][j-intArr[i-1]] + intArr[i-1];  // 装入此数的总和
                    if ( sumWithCurrentEle > dp[i-1][j]){  // 若装入此数的总和大于不装入此数，则装
                        dp[i][j] = sumWithCurrentEle;
                        isPackedArr[i][j] = true;  // 标记装入背包
                    } else { // 装入此数的总和小于等于不装时，都不装，故此时的值就等于上一行同列的值
                        dp[i][j] = dp[i-1][j]; // 不装
                    }
                } else { // 装不下
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        // 通过标记数组，找到原数组中对应的数字，对装入背包的数字进行标记
        int row = isPackedArr.length - 1;
        int col = isPackedArr[0].length - 1;
        while (row>0) {
            if (isPackedArr[row][col]) {
                isPackedFinalArr[row-1] = true;
                col -= intArr[row-1];
                if (col < 0){
                    break;
                }
            }
            row --;
        }

        // 组装返回数据
        List<Integer> firstHalf = new LinkedList<>();  // 第一个子数组
        List<Integer> secondHalf = new LinkedList<>();  // 第二个子数组
        for (int i = 0; i < isPackedFinalArr.length; i++) {
            if (isPackedFinalArr[i]){
                firstHalf.add(intArr[i]);
            } else {
                secondHalf.add(intArr[i]);
            }
        }
        ResultObject result = new ResultObject();
        result.setFirstHalf(firstHalf);
        result.setSecondHalf(secondHalf);
        int sumOfFirst = firstHalf.stream().reduce(Integer::sum).orElse(0);
        result.setDifferenceOfSums(Math.abs(sumOfFirst-(sum-sumOfFirst)));

        return result;
    }
}

class ResultObject {
    private List<Integer> firstHalf;
    private List<Integer> secondHalf;
    private Integer differenceOfSums;  // 两个子数组的和之差

    public ResultObject() {
    }

    public List<Integer> getFirstHalf() {
        return firstHalf;
    }

    public void setFirstHalf(List<Integer> firstHalf) {
        this.firstHalf = firstHalf;
    }

    public List<Integer> getSecondHalf() {
        return secondHalf;
    }

    public void setSecondHalf(List<Integer> secondHalf) {
        this.secondHalf = secondHalf;
    }

    public Integer getDifferenceOfSums() {
        return differenceOfSums;
    }

    public void setDifferenceOfSums(Integer differenceOfSums) {
        this.differenceOfSums = differenceOfSums;
    }

    @Override
    public String toString() {
        return "ResultObject{" +
                "firstHalf=" + firstHalf +
                ", secondHalf=" + secondHalf +
                ", differenceOfSums=" + differenceOfSums +
                '}';
    }
}