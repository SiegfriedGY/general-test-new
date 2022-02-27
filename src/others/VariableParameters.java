package others;

public class VariableParameters {
    
    public static void main(String[] args){
        System.out.println(cal(1,2,3));
        System.out.println(cal(3));
        System.out.println(cal());

        // 也可以传入数组
        int[] arr = {1,2,3,4,5};
        System.out.println(cal(arr));

    }
    public static int cal(int... arr){

        int sum = 0;
        for (int value : arr) {
            sum += value;
        }
        return sum;
    }
}
