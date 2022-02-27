package oop;

import java.util.HashSet;
import java.util.Set;

public class TestHashCodeDuplication {

    public static void main(String[] args) {

        Set<Integer> hashCodeSet = new HashSet<>();
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            Integer hashCode = new Object().hashCode();
            if (hashCodeSet.contains(hashCode)){
                System.out.println("出现重复hashCode值：" + hashCode + "，此时size为：" + hashCodeSet.size());
                break;
            }
            hashCodeSet.add(hashCode);
        }
    }

}
