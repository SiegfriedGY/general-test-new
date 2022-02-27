package z_exercises;

import java.util.Arrays;

public class Test1 {

    /**
     * Write a Java program to find the smallest and second smallest numbers
     * of a given integer array (the array has at least two numbers).
     * Do not use Java APIs like Math.min.
     * @param args
     */
    public static void main(String[] args) {

        int[] ints = {99,5,48,22,19,6,8,35};
        sortBubble(ints);
        System.out.println(ints[0] + " " + ints[1]);
        System.out.println(Arrays.toString(method1(ints)));
        System.out.println(Arrays.toString(method2(ints)));

    }

    private static void sortBubble(int[] ints) {
        int temp;
        for (int i = 0; i < ints.length - 1; i++) {
            for (int j = 0; j < ints.length - 1 - i; j++) {
                if (ints[j+1] < ints[j]) {
                    temp = ints[j];
                    ints[j] = ints[j+1];
                    ints[j+1] = temp;
                }
            }
        }
    }

    private static int[] method1(int[] ints) {
        int[] result = new int[2];
        int minSum = Integer.MAX_VALUE;
        for (int i = 0; i < ints.length - 1; i++) {
            for (int j = 1; j < ints.length - 1 - i; j++) {
                int sum = ints[i] + ints[j];
                if (sum < minSum) {
                    minSum = sum;
                    result[0] = ints[i];
                    result[1] = ints[j];
                }
            }
        }
        return result;
    }

    private static int[] method2(int[] ints) {

        int[] result = {Integer.MAX_VALUE, Integer.MAX_VALUE};
        for (int current : ints) {
            if (current < result[0]) {
                result[0] = current;
            } else if (current > result[0] && current < result[1]) {
                result[1] = current;
            }
        }
        return result;
    }
}
