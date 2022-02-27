package z_exercises;

import java.util.*;
import java.util.stream.Collectors;

public class Test2 {
    public static void main(String[] args) {
        ArrayList<String> result = new ArrayList<>();
        result.add("12:30:10");
        result.add("12:15:12");
        result.add("15:20:14");
        System.out.println("result: " + timeSort(result));

        ArrayList<String> result1 = new ArrayList<>();
        result1.add("12:30:10");
        result1.add("12:15:10");
        result1.add("11:20:14");
        System.out.println("result: " + timeSort(result1));
    }

    private static int getHour(String timeStamp) {
        return Integer.parseInt(timeStamp.substring(0,2));
    }

    private static int getMin(String timeStamp) {
        return Integer.parseInt(timeStamp.substring(3,5));
    }

    private static int getSecond(String timeStamp) {
        return Integer.parseInt(timeStamp.substring(6));
    }
    public static ArrayList<String> timeSort(ArrayList<String> times) {
        // write code here
        ArrayList<String> sortedBySecond = times.stream()
                .sorted(Comparator.comparingInt(Test2::getSecond))
                .collect(Collectors.toCollection(ArrayList::new));
        System.out.println("sortedBySecond: " + sortedBySecond);

        for (int i = 0; i < sortedBySecond.size()-1; i++) {
            String current = sortedBySecond.get(i);
            String next = sortedBySecond.get(i+1);
            String temp;
            if (getSecond(current) == getSecond(next)) {
                System.out.println("second is the same, now judge min");
                if (getMin(current) > getMin(next)) {
                    temp = current;
                    sortedBySecond.set(i, next);
                    sortedBySecond.set(i+1, temp);
                } else if (getMin(current) == getMin(next)) {
                    System.out.println("second and min are the same, now judge hour");
                    if (getHour(current) > getHour(next)) {
                        temp = current;
                        sortedBySecond.set(i, next);
                        sortedBySecond.set(i+1, temp);
                    }
                }
            }
            System.out.println(sortedBySecond);
        }
        return sortedBySecond;
    }

}
