package algorithms_and_maths;

import java.util.*;
import java.util.stream.Collectors;

public class FindReverse {

    public static void main(String[] args){

        String str = "cbbd";
        Set<String> allReverse = findAllReverse(str);
        System.out.println(allReverse);

//        allReverse.add("r");
//        allReverse.add("awefawefwaefawefawefaefw");
//        System.out.println(allReverse);
//        System.out.println(findLargestLength(allReverse));
        System.out.println(getLongestStr(allReverse));
    }

    private static Set<String> findAllReverse(String src){

        Set<String> result = new HashSet();
        for (int i = 0; i < src.length(); i++) {
            for (int j = i+1; j < src.length(); j++) {
                String current = src.substring(i, j+1);
                if (isReverse(current)){
                    result.add(current);
                }
            }
        }
        return result;
    }

    private static boolean isReverse(String target){
        return new StringBuilder(target).reverse().toString().equals(target);
    }

    private static int findLargestLength(Set<String> src){

        List<String> stringList = new ArrayList<>(src);
        int length = 0;
        for (int i = 0; i < stringList.size(); i++) {
            int currentLen = stringList.get(i).length();
            if (currentLen > length) {
                length = currentLen;
            }
        }
        return length;
    }

    private static String getLongestStr(Set<String> src){
        Set<String> sortedSet = new TreeSet<>(Comparator.comparingInt(String::length).reversed());
        sortedSet.addAll(src);
        return new ArrayList<>(sortedSet).get(0);
    }

}
