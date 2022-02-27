package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 在二维数组grid中，grid[i][j]代表位于某处的建筑物的高度。 我们被允许增加任何数量（不同建筑物的数量可能不同）的建筑物的高度。 高度 0 也被认为是建筑物。

 最后，从新数组的所有四个方向（即顶部，底部，左侧和右侧）观看的“天际线”必须与原始数组的天际线相同。 城市的天际线是从远处观看时，由所有建筑物形成的矩形的外部轮廓。 请看下面的例子。

 建筑物高度可以增加的最大总和是多少？

 例子：
 输入： grid = [[3,0,8,4],[2,4,5,7],[9,2,6,3],[0,3,1,0]]
 输出： 35
 解释：
 The grid is:
 [ [3, 0, 8, 4],
 [2, 4, 5, 7],
 [9, 2, 6, 3],
 [0, 3, 1, 0] ]

 从数组竖直方向（即顶部，底部）看“天际线”是：[9, 4, 8, 7]
 从水平水平方向（即左侧，右侧）看“天际线”是：[8, 7, 9, 3]

 在不影响天际线的情况下对建筑物进行增高后，新数组如下：

 gridNew = [
 [8, 4, 8, 7],
 [7, 4, 7, 7],
 [9, 4, 8, 7],
 [3, 3, 3, 3] ]

 */
public class Test0515_KeepSkyline {

    public static void main(String[] args){
        int[][] grid = {
                {3, 0, 8, 4},
                {2, 4, 5, 7},
                {9, 2, 6, 3},
                {0, 3, 1, 0}
        };
        System.out.println(maxIncreaseKeepingSkyline(grid));
    }

    public static int maxIncreaseKeepingSkyline(int[][] grid) {

        Map<String, Integer> maxMap = new HashMap<>();
        calRowMax(maxMap, "row", grid);
        calRowMax(maxMap, "col", clockwiseConvert(grid));

        int sum = 0;
        for (int i = 0; i < grid.length; i++) {
            int[] row = grid[i];
            int rowMax = maxMap.get("row"+i);
            for (int j = 0; j < row.length; j++) {
                int colMax = maxMap.get("col"+j);
                int cell = row[j];
                if (cell < rowMax && cell < colMax){
                    sum += Math.min(rowMax, colMax) - cell;
                }
            }
        }
        return sum;
    }

    private static void calRowMax(Map maxMap, String symbol, int[][] grid){
        for (int i = 0; i < grid.length; i++) {
            int[] row = grid[i];
            int rowMax = 0;
            for (int j = 0; j < row.length; j++) {
                rowMax = Math.max(row[j], rowMax);
            }
            maxMap.put(symbol + i, rowMax);
        }
    }

    private static int[][] clockwiseConvert(int[][] matrix) {
        int[][] result = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            int[] curRow = matrix[i];
            for (int j = 0; j < curRow.length; j++) {
                int rowIndex = j;
                int colIndex = matrix.length - i - 1;
                result[rowIndex][colIndex] = curRow[j];
            }
        }
        return result;
    }
}
