package z_exercises;

import java.util.*;

public class Test5 {

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("ab","abc","bcd","abc","bcd","abc","bcd","bcd","bcd","bcd");
        Map<String, Integer> result = new HashMap<>();
        strings.forEach(e -> result.merge(e, 1, Integer::sum));
        System.out.println(result);
        List<Map.Entry<String,Integer>> list = new ArrayList<>(result.entrySet());
        list.sort(Map.Entry.comparingByValue());
        Collections.reverse(list);
        System.out.println(list.subList(0,2));
    }
}
