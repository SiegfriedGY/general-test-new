package leetcode;

import java.util.*;

public class Test0513_SpiralMatrix_2 {

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

        System.out.println(spiralOrder(matrix1));
    }


    public static List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> result = new ArrayList<>();

        if (matrix.length == 0){
            return result;
        }

        /**
         *{1, 2, 3, 4},
          {5, 6, 7, 8},
          {9,10,11,12},
         */
        int row = 0;
        int column = 0;

        Map<String, Boolean> flags = new HashMap<>();
        for (int i = 0; i < matrix.length; i++) {
            int[] curRow = matrix[i];
            for (int j = 0; j < curRow.length; j++) {
                flags.put(i+""+j, false);
            }
        }
        System.out.println(flags);

        int[] rowIncrement = new int[]{0, 1, 0, -1};
        int[] colIncrement = new int[]{1, 0, -1, 0};
        int k = 0;

        while (result.size() < matrix.length*matrix[0].length) {

            String index = row+""+column;
            System.out.println("此点的index为：" + index);
            flags.put(index, true);
            int cell = matrix[row][column];
            System.out.println(cell);
            result.add(cell);

            row += rowIncrement[k];
            column += colIncrement[k];
            System.out.println("此时row和col的增量分别为：" + rowIncrement[k] + ", " + colIncrement[k]);
            String nextIndex = row+""+column;
            System.out.println("nextIndex: " + nextIndex);

            boolean flag = flags.get(nextIndex);
            System.out.println(flag);

            if (column == matrix[0].length-1 || row == matrix.length-1 || flags.get(nextIndex)) {
                k++;
                if (k == 4) {
                    k = 0;
                }
            }




        }

        return result;
    }

}
