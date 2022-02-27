package collections_related;

import java.util.*;

/**
 * @author Siegfried GENG
 * @date 2019/8/3 - 15:05
 */
public class TestMap {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("姓名","AAA");
        map.put("性别","MALE");

        ///把任何一个非同步的集合，都可以用以下对应的方法改成线程安全的集合！！！
        Map<String, String> stringStringMap = Collections.synchronizedMap(map);

//        System.out.println(stringStringMap);

        List<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");

        List<String> strings = Collections.synchronizedList(list);
//        System.out.println(strings);

        SortedMap<String, Integer> map1 = new TreeMap<>();
        map1.put("eaaaaaaa", 111);
        map1.put("ab", 111);
        map1.put("zbc", 111);
        System.out.println(map1);


    }

}
