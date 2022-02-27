package collections_related;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/**
 * @author Siegfried GENG
 * @date 2019/8/19 - 12:13
 */
public class TestList {

    public static void main(String[] args) {

        List<String> list00 = new ArrayList<>(20);
        System.out.println(list00.size());

        List list02 = new ArrayList();
        list02.add(1);
        list02.add(1L);
        list02.add("去你们");

        String str = "abb";
        str = "aaaa";


        List<String> list01 = new ArrayList<>();
        list01.add("aaa");
        list01.add("aaa");
        list01.add("bbb");
        list01.add("ccc");
        list01.add("ddd");
//        System.out.println(list01);
        Iterator<String> iterator = list01.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        String[] strings = list01.toArray(new String[0]);

        // 集合的修改，不会影响到数组。
        list01.set(0, "去你妹");
        System.out.println(list01);
        System.out.println(Arrays.toString(strings));

        System.out.println("===========================");

        // 数组的修改，会影响到集合。
        strings[0] = "去你哥";
        System.out.println(list01);
        System.out.println(Arrays.toString(strings));

//        List<String> strings1 = list01.subList(0, 2);
//        // 对subList的操作也会修改原list！！！
//        strings1.add("xxx");
//
//        System.out.println(strings1);
//        System.out.println(list01);

//        String[] strings = list01.toArray(new String[0]);
//        System.out.println(strings);

    /*    Set<String> set01 = new HashSet<>(list01);
        System.out.println(set01);

        List<String> list02 = new ArrayList<>(set01);
        System.out.println(list02);*/

    }

}
