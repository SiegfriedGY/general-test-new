package others;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.CountDownLatch;

public class ConcurrentCollectionTest {
    public static void main(String[] args) {
        HashMap<String, Object> hashMap = new HashMap<>();
        Map<String, Object> synchronizedMap = Collections.synchronizedMap(hashMap);

        CountDownLatch latch = new CountDownLatch(10);

        for (int i = 0; i < 10; i++) {
            int finalI = i;
            new Thread(() -> {
                synchronizedMap.put("abc"+ finalI, new Object());
                System.out.println(synchronizedMap.size());
                latch.countDown();
            }).start();
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("final:" + synchronizedMap.size());
    }
}
