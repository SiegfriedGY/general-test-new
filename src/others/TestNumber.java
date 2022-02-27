package others;

import com.sun.org.apache.xpath.internal.operations.String;

import java.util.ArrayList;
import java.util.List;

public class TestNumber {
    public static void main(String[] args) {
        Integer int1 = 3;
        Integer int2 = 3;
        System.out.println(int1.equals(int2));
        System.out.println(Math.min(4,4));

        List<Object> list = new ArrayList<>();
        list.add(123);
        System.out.println(list.size());
    }
}
