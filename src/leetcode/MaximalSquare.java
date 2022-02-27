package leetcode;

/**
 * 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
 *  输入:

 1 0 1 0 0
 1 0 1 1 1
 1 1 1 1 1
 1 0 0 1 0

 输出: 4
 */
public class MaximalSquare {

    public static void main(String[] args){

        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };

        char[][] matrix1 = {{'1'}};

        char[][] matrix2 = {
                {'0','1'},
                {'1','0'}
        };

//        getMaxContinuousLenForRow(matrix);
//        maximalSquare(matrix);
//        System.out.println(isSquare(matrix, 2, 3, 2));
        System.out.println("\n\n" + maximalSquare(matrix2));
    }

    /**
     * 思路：
     * 1. 先设计一个方法，给一个位置，再给一个距离，返回以这个位置为左上角，以距离为边长，是否能构成一个正方形的boolean。
     * 2. 遍历每个值为1的cell, 循环调用上述方法（从该cell距离右边距最大距离开始，缩减调用，一旦有构成的，就停止，记为k）。
     * 3. 比较所有k中最大的。
     * @param matrix
     * @return
     */
    public static int maximalSquare(char[][] matrix) {

        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        if (matrix.length==1 || matrix[0].length == 1){
            for (int i = 0; i < matrix.length; i++) {
                char[] row = matrix[i];
                for (int j = 0; j < row.length; j++) {
                    int cell = Integer.parseInt(String.valueOf(row[j]));
                    System.out.println(cell);
                    if (cell == 1){
                        return 1;
                    }
                }
            }
            return 0;
        }
        //全是0
        int num = 0;
        for (int i = 0; i < matrix.length; i++) {
            char[] row = matrix[i];
            for (int j = 0; j < row.length; j++) {
                int cell = Integer.parseInt(String.valueOf(row[j]));
                System.out.println(cell);
                num += cell;
            }
        }
        if (num == 0){
            return 0;
        }

        int maxWidth = 1;
        for (int i = 0; i < matrix.length-1; i++) {
            char[] curRow = matrix[i];
            for (int j = 0; j < curRow.length-1; j++) {
                int cell = Integer.parseInt(String.valueOf(curRow[j]));
                System.out.println(cell);
                if (cell == 1) {
                    int distanceToRight = curRow.length - j;
                    int distanceToBottom = matrix.length - i;
                    int width = distanceToRight<distanceToBottom ? distanceToRight : distanceToBottom;
                    System.out.println("\n----本次原点：第"+(i+1)+ "行，第" + (j+1) +"列----width:" + width);
                    for (int k = width; k > 1; k--) {
                        if (isSquare(matrix, i, j, k)){
                            maxWidth = k>maxWidth ? k : maxWidth;
                            System.out.println("+++++++++++++++++++++此次maxWidth为：" + maxWidth);
                            break;
                        }
                    }
                }
            }
        }
        return maxWidth*maxWidth;
    }

    public static boolean isSquare(char[][] matrix, int row, int column, int width) {

        boolean result = true;
        int startCol = column;
        for (int i = 0; i < width; i++) {
            column = startCol;
            for (int j = 0; j < width; j++) {
                System.out.print("这个cell是第" + (row+1) + "行，第" + (column+1) + "列，");
                int cell = Integer.parseInt(String.valueOf(matrix[row][column++]));
                System.out.println("值为：" + cell);
                if (cell == 0) {
                    System.out.println("======该原点边长为" + width + "不能构成正方形");
                    return false;
                }
            }
            row++;
        }
        System.out.println("======该原点边长为" + width + "可以构成正方形！！！！！");
        return result;
    }

    /**
     * 此方法，本题用不上，只是相关联想。
     * @param matrix
     */
    public static void getMaxContinuousLenForRow(char[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {

            char[] row = matrix[i];
            int count = 0;
            int maxLen = 0;

            for (int j = 0; j < row.length; j++) {

                int cell = (int) row[j];
                System.out.print(cell + ", ");
                if (cell == 1){
                    count ++;
                    if (count > maxLen) {
                        maxLen = count;
                    }
                } else if (cell == 0){
                    if (count > maxLen) {
                        maxLen = count;
                    }
                    count = 0;
                }
            }
            System.out.println("本行最大连续1数为：" + maxLen);
        }
    }
}
