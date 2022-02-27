package z_exercises;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class CountCharInStringConcurrently {
    public static void main(String[] args) {
        String str = "aaaaaaaaaaaccccccccccaaaaabbbbbbbbbbbgokpwfapmfjaowepggbbb";  // a出现18次
//        System.out.println(count(str, 'a'));
        System.out.println(str.length());
        System.out.println("最终结果：" + countWithMultiThread(4, str, 'b'));

    }
    private static AtomicInteger concurrentCount = new AtomicInteger(0);

    public static AtomicInteger countWithMultiThread (int chunkSize, String src, char dest) {

        int totalLength = src.length();
        if (totalLength <= chunkSize) {
            return null;
        }

        int chunkNum = totalLength % chunkSize == 0 ? totalLength / chunkSize : totalLength/chunkSize +1;
        System.out.println("chunkNum/要开启的线程数: " + chunkNum);
        CountDownLatch latch = new CountDownLatch(chunkNum);
        for (int i = 0; i < chunkNum; i++) {
            int toIndex = Math.min(i*chunkSize + chunkSize, totalLength);
//            System.out.println("本轮的toIndex: " + toIndex);
            String chunk = src.substring(i*chunkSize, toIndex);
//            System.out.println("本轮的chunk: " + chunk);
            new Thread( () -> count(chunk, dest, concurrentCount, latch)).start();
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return concurrentCount;
    }

    public static void count(String chunk, char dest, AtomicInteger concurrentCount, CountDownLatch latch) {
        for (int i = 0; i < chunk.length(); i++) {
            if (chunk.charAt(i) == dest) {
                concurrentCount.getAndIncrement();
            }
        }
        System.out.println("线程" + Thread.currentThread().getName() + "过后，" + dest + "共出现：" + concurrentCount + "次");
        latch.countDown();
    }
}
