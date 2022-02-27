package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CombineNK {

    public static void main(String[] args){

    }

    private static List<Integer> combine(int n, int k){



        Set<Integer> result = new HashSet<>();

        for (int i = 0; i < n; i++) {

            List<Integer> integers = new ArrayList<>();
            for (int m = 0; m < n; m++) {
                integers.add(m+1);
            }
            System.out.println(integers);

            Integer first = integers.get(0);
            integers.remove(first);

            for (int j = 0; j < k; j++) {
                
            }


        }
        return new ArrayList<>(result);
    }

    private List<Integer> recursive(Integer bench, List<Integer> rest){

        List<Integer> integers = new ArrayList<>();
        if (rest.size() == 1){
            integers.add(bench);
            integers.add(rest.get(0));
            return integers;
        } else {
            Integer bench1 = rest.get(0);
            integers.add(bench1);
            rest.remove(bench1);
            List<Integer> recursive = recursive(bench1, rest);
            for (int i = 0; i < recursive.size(); i++) {
                integers.add(recursive.get(i));
            }
            return integers;
        }

    }

}
