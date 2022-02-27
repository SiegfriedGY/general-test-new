package multithreading_related;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ArrayListConcurrentTest {
    public static void main(String[] args) throws InterruptedException {

        List<Integer> strings = new ArrayList<>();
//        for (int i = 0; i < 10; i++) {
//            int finalI = i;
//            new Thread( ()->{
//                strings.add( finalI +1 );
//            }).start();
//        }
//        System.out.println(strings);
        /**
         * 上面的写法会直接报并发更改异常
         */

//        CopyOnWriteArrayList<Integer> strings1 = new CopyOnWriteArrayList<>();
        List<Integer> strings1 = Collections.synchronizedList(strings);
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            new Thread( ()->{
                strings1.add( finalI +1 );
            }).start();
        }
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
        System.out.println(strings1);
    }

}
