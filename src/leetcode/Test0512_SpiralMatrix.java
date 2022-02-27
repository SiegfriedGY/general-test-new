package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test0512_SpiralMatrix {

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

        System.out.println(spiralOrder(matrix9));
    }


    public static List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> result = new ArrayList<>();

        if (matrix.length == 0){
            return result;
        }

        String direction = "rightward";

        while (matrix.length > 1 && matrix[0].length > 1) {

            switch (direction) {
                case "rightward":
                    matrix = getTopRow(matrix, result);
                    direction = "downward";
                    break;
                case "downward":
                    matrix = getRightCol(matrix, result);
                    direction = "leftward";
                    break;
                case "leftward":
                    matrix = getBottomRow(matrix, result);
                    direction = "upward";
                    break;
                case "upward":
                    matrix = getLeftCol(matrix, result);
                    direction = "rightward";
                    break;
            }
        }

        System.out.println(matrix.length + "=============" + matrix[0].length + "\n");
        if (matrix.length == 1) {
            System.out.println(direction);
            int[] lastRow = matrix[0];
            if ("upward".equals(direction) || "rightward".equals(direction)){
                for (int i = 0; i < lastRow.length; i++) {
                    result.add(lastRow[i]);
                }
            } else if ("downward".equals(direction)){
                for (int i = lastRow.length-1; i >= 0; i--) {
                    result.add(lastRow[i]);
                }
            }
        } else if (matrix[0].length == 1) {
            System.out.println(direction);
            if ("rightward".equals(direction)){
                for (int i = 0; i < matrix.length; i++) {
                    result.add(matrix[i][0]);
                }
            } else if (("leftward".equals(direction))){
                for (int i = matrix.length-1; i >= 0; i--) {
                    result.add(matrix[i][0]);
                }
            }
        }
        return result;
    }

    private static int[][] getTopRow(int[][] matrix, List<Integer> result){
        int[] topRow = matrix[0];
        for (int i = 0; i < topRow.length; i++) {
            result.add(topRow[i]);
        }
        System.out.println("getTopRow result is: " + result);
        matrix = Arrays.copyOfRange(matrix, 1, matrix.length);
        System.out.println("getTopRow matrix.length: " + matrix.length + " || getTopRow matrix[0].length: " + matrix[0].length + "\n");
        return matrix;
    }

    private static int[][] getRightCol(int[][] matrix, List<Integer> result){
        int[][] resultMatrix = new int[matrix.length][matrix[0].length-1];
        for (int i = 0; i < matrix.length; i++) {
            int[] curRow = matrix[i];
            result.add(curRow[curRow.length-1]);
            resultMatrix[i] = Arrays.copyOfRange(curRow, 0, curRow.length-1);
        }
        System.out.println("getRightCol result is: " + result);
        System.out.println("getRightCol matrix.length: " + resultMatrix.length + " || getRightCol matrix[0].length: " + resultMatrix[0].length + "\n");
        return resultMatrix;
    }

    private static int[][] getBottomRow(int[][] matrix, List<Integer> result){
        int[] bottomRow = matrix[matrix.length-1];
        for (int i = bottomRow.length-1; i >= 0 ; i--) {
            result.add(bottomRow[i]);
        }
        System.out.println("getBottomRow result is: " + result);
        matrix = Arrays.copyOfRange(matrix, 0, matrix.length-1);
        System.out.println("getBottomRow matrix.length: " + matrix.length + " || getBottomRow matrix[0].length: " + matrix[0].length + "\n");
        return matrix;
    }

    private static int[][] getLeftCol(int[][] matrix, List<Integer> result){
        int[][] resultMatrix = new int[matrix.length][matrix[0].length-1];
        for (int i = matrix.length-1; i >= 0; i--) {
            int[] curRow = matrix[i];
            result.add(curRow[0]);
            resultMatrix[i] = Arrays.copyOfRange(curRow, 1, curRow.length);
        }
        System.out.println("getLeftCol result is: " + result);
        System.out.println("getLeftCol matrix.length: " + resultMatrix.length + " || getLeftCol matrix[0].length: " + resultMatrix[0].length + "\n");
        return resultMatrix;
    }
}
