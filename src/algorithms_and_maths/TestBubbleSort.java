package algorithms_and_maths;

import java.util.Arrays;

/**
 * 冒泡排序
 * @author Siegfried GENG
 * @date 2019/9/5 - 12:54
 */
public class TestBubbleSort {

    public static void main(String[] args) {

        int[] ints = new int[] {3,6,1,2,8,9,4,7,7};
        System.out.println(Arrays.toString(bubbleSort(ints)));
    }

    public static int[] bubbleSort(int[] src){

        for (int i = 0; i < src.length; i++) {
            for (int j = 0; j < src.length-1-i; j++) {

                if (src[j] > src[j+1]){
                    int temp = src[j];
                    src[j] = src[j+1];
                    src[j+1] = temp;
                }

            }
        }
        return src;
    }

}
