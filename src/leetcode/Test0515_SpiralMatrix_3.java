package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test0515_SpiralMatrix_3 {

    public static void main(String[] args){

        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
        };
        int[][] matrix1 = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9,10,11,12},
        };
        int[][] matrix2 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {10,11,12},
                {13,14,15},
                {16,17,18}
        };
        int[][] matrix3 = {
                {1, 2, 3, 4, 13, 14, 15},
                {5, 6, 7, 8, 16, 17, 18},
                {9,10,11,12, 19, 20, 21},
        };
        int[][] matrix4 = {{1, 2, 3, 4, 13, 14, 15}};
        int[][] matrix7 = {{1}};
        int[][] matrix5 = {
                {1, 11},
                {2, 12},
                {3, 13},
                {4, 14},
                {5, 15}
        };
        int[][] matrix6 = {
                {1},
                {2},
                {3},
                {4},
                {5}
        };
        int[][] matrix8= {{},{}};
        int[][] matrix9 = {
                {1, 2, 3},
                {4, 5, 6},
        };
        System.out.println(spiralOrder(matrix));
    }
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        while (matrix.length >= 1) {
            for (int i = 0; i < matrix[0].length; i++) {
                result.add(matrix[0][i]);
            }
            if (matrix.length > 1){
                matrix = Arrays.copyOfRange(matrix, 1, matrix.length);  // 削掉第一行
                matrix = counterClock(matrix); // 逆时针旋转
            } else {
                break;
            }
        }
        return result;
    }
    private static int[][] counterClock(int[][] matrix) {
        int[][] result = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            int[] curRow = matrix[i];
            for (int j = 0; j < curRow.length; j++) {
                result[matrix[0].length - j - 1][i] = curRow[j];
            }
        }
        return result;
    }
}
