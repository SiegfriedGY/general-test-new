package interview;

import java.util.Arrays;
import java.util.List;

public class Fibonacci {

    public static void main(String[] args){

        method1();
        method2();
        method11(7);
        // 递归算法
        for (int i = 1; i <= 10; i++) {
            int recursive = recursive(i);
            System.out.print(recursive + "  ");
        }

    }

    public static void method1(){

//        List<Integer> integerList = new ArrayList<>(10);
        List<Integer> integerList = Arrays.asList(new Integer[10]);
        integerList.set(0,1);
        integerList.set(1,1);
//        integerList.add(1);
//        integerList.add(1);
        for (int i = 2 ; i < integerList.size(); i++) {
            integerList.set(i, integerList.get(i-1)+integerList.get(i-2));
//            integerList.add(integerList.get(i-1)+integerList.get(i-2));
        }
        System.out.println(integerList);
    }

    public static void method11(int n){

//        List<Integer> integerList = new ArrayList<>(10);
        List<Integer> integerList = Arrays.asList(new Integer[n]);
        integerList.set(0,1);
        integerList.set(1,1);
//        integerList.add(1);
//        integerList.add(1);
        for (int i = 2 ; i < integerList.size(); i++) {
            integerList.set(i, integerList.get(i-1)+integerList.get(i-2));
//            integerList.add(integerList.get(i-1)+integerList.get(i-2));
        }
        System.out.println(integerList);
    }

    public static void method2(){
        int[] intArray = new int[10];
        intArray[0] = 1;
        intArray[1] = 1;
        for (int i = 2; i < intArray.length; i++) {
            intArray[i]=intArray[i-2]+intArray[i-1];
        }
        System.out.println(Arrays.toString(intArray));
    }

    public static int recursive(int n){

        if (n == 1 || n == 2){
            return 1;
        } else {
            return recursive(n-1) + recursive(n-2);
        }
    }

}
