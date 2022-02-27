package array_related;

import java.util.Arrays;

public class ArrayCopy {
    
    public static void main(String[] args){

        int[] arr = new int[1];
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 3;
        System.out.println(Arrays.toString(arr));

        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9,10,11,12},
        };

        System.out.println(matrix.length);
        matrix = Arrays.copyOfRange(matrix, 1, matrix.length);
        System.out.println(matrix.length + ", " + Arrays.toString(matrix[0]));
    }
}
