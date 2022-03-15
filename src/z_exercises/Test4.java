package z_exercises;

import java.util.Arrays;

public class Test4 {

    @Override
    public void finalize(){
        System.out.println("去你妹");
    }

    public static void main(String[] args) {
        int[] as = null;
        as[0] = 1;
//        System.out.println(Arrays.toString(as));

        Object obj = new Object();

        int[] as1 = null;
        as1[0] = 44;

        System.out.println(as.equals(as1));

        Integer a1 = 17, a2 = 17;
        
    }
}
