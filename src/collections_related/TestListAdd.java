package collections_related;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.List;

public class TestListAdd {

    public static void main(String[] args){

//        List<String> strs = new ArrayList<>(3);
//
//        System.out.println(strs.add("啊啊啊"));
//        System.out.println(strs.add("啊啊啊"));
//        System.out.println(strs.add("啊啊啊"));
//        System.out.println(strs.add("啊啊啊"));
//        System.out.println(strs.add("啊啊啊"));
//        System.out.println(strs.add(null));

        List<String> strs = new ArrayQueue<>(3);
        System.out.println(strs.add("啊啊啊"));
        System.out.println(strs.add("啊啊啊"));
        System.out.println(strs.add("啊啊啊"));
        System.out.println(strs.add("啊啊啊"));
        System.out.println(strs.add("啊啊啊"));

    }
}
