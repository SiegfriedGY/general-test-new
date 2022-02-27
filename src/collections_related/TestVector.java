package collections_related;

import java.util.Arrays;
import java.util.Vector;

/**
 * @author Siegfried GENG
 * @date 2019/8/24 - 11:05
 */
public class TestVector {
    
    public static void main(String[] args) {
        Integer[] object1 = {0,10,20,30,40,50,60,70,80,90,100};//数组定义
        Vector<Integer> object2;//Vector定义
        object2=new Vector<Integer>(Arrays.asList(object1));//[] -> array -> vector
        System.err.println(Arrays.toString(object1));
        System.err.println(object2);
        Integer[] object3 = object2.toArray(new Integer[object2.size()]);//vector -> array -> []
        System.out.println(Arrays.toString(object3));


    }
}
