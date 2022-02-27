package z_exercises;

import java.util.HashSet;
import java.util.Set;

public class NonrepeatableNumbers {
    public static void main(String[] args) {
        Set<Integer> integerSet = new HashSet<>();
        int count = 0;
        for (int i = 1; i < 5; i++) {
            for (int j = 1; j < 5; j++) {
                for (int k = 1; k < 5; k++) {
                    if (i != j && j != k && i != k) {
                        count ++;
                        integerSet.add(i*100 + j*10 + k);
                    }
                }
            }
        }
//        System.exit(0);
        System.out.println(integerSet.size());
        System.out.println(count);
        System.out.println(integerSet);

    }
}
