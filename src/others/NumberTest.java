package others;

import java.util.ArrayList;
import java.util.List;

public class NumberTest {

    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        List<Long> longList = new ArrayList<>();
        longList.add(1L);

        System.out.println(test1(integerList));
        System.out.println(test1(longList));
    }

    private static int test1(List<? extends Number> list){
        return list.size();
    }
}
