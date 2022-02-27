package leetcode;

public class Test0516_LongestContinuousSequence {

    public static void main(String[] args){

        int[] row = {1,0,1,1,1,0,0,1,0,1,0,0,0,1,1,0,0,1,1,1,0};
        System.out.println(calLongestContinuousSequence(row));
    }

    private static int calLongestContinuousSequence(int[] row) {
        int maxLength = 0;
        int k = 0;
        for (int i = 0; i < row.length; i++) {
            if (row[i] == 1){
                k++;
            } else {
                maxLength = Math.max(k, maxLength);
                k = 0;
            }
        }
        return maxLength;
    }
}
