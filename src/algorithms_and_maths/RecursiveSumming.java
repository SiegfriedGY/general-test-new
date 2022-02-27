package algorithms_and_maths;

public class RecursiveSumming {

    public static void main(String[] args){
        System.out.println(summing(100));
    }

    public static int summing(int n){
        if (n == 1){
            return 1;
        } else {
            return summing(n-1) + n;
        }
    }

}
