package collections_related;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Siegfried GENG
 * @date 2019/8/23 - 22:29
 */
public class TestArraysAsList {
    
    public static void main(String[] args) {

        String[] strs = {"aaa", "bbb", "ccc"};
        List<String> strings = Arrays.asList(strs);

        // 这里会报错UnsupportedOperationException
        // 对由数组转来的ArrayList进行add/remove操作，就会产生这个错。
//        strings.add("ddd");

        // 解决办法：再转换一次
        List<String> resultList = new ArrayList<>(strings);

        resultList.add("ddd");
        System.out.println(resultList);

        resultList.remove("bbb");
        System.out.println(resultList);

    }
}
