package z_exercises;

import java.util.*;
import java.util.stream.Collectors;

public class Test2 {
    public static void main(String[] args) {
        ArrayList<String> result = new ArrayList<>();
        result.add("12:30:10");
        result.add("12:15:12");
        result.add("15:20:14");
        System.out.println("result: " + timeSort1(result));

        ArrayList<String> result1 = new ArrayList<>();
        result1.add("12:30:10");
        result1.add("12:15:10");
        result1.add("11:20:14");
        System.out.println("result1: " + timeSort1(result1));

        ArrayList<String> result2 = new ArrayList<>();
        result2.add("13:58:26");
        result2.add("12:30:14");
        result2.add("12:15:10");
        result2.add("18:21:14");
        result2.add("13:21:14");
        result2.add("13:21:26");
        System.out.println("result2.1: " + timeSort1(result2));
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

    /*
    只能比较3个或3个以下数据
     */
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

    public static ArrayList<String> timeSort1(ArrayList<String> times) {
        // 按秒钟分组并排序
        Map<Integer, List<String>> map = times.stream()
                .collect(Collectors.groupingBy(Test2::getSecond, TreeMap::new, Collectors.toList()));
        ArrayList<String> result = new ArrayList<>();
        for (List<String> tempList : map.values()) {
            if (tempList.size() == 1) {
                result.add(tempList.get(0));
            } else {
                // 按分钟分组并排序
                Map<Integer, List<String>> subMap = tempList.stream()
                        .collect(Collectors.groupingBy(Test2::getMin, TreeMap::new, Collectors.toList()));
                for (List<String> subList : subMap.values()) {
                    if (subList.size() == 1) {
                        result.add(subList.get(0));
                    } else {
                        result.addAll(subList.stream()
                                .sorted(Comparator.comparingInt(Test2::getHour)) // 按小时排序
                                .collect(Collectors.toCollection(ArrayList::new)));
                    }
                }
            }
        }
        return result;
    }

}
