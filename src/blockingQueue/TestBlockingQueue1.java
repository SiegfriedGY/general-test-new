package blockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author Siegfried GENG
 * @date 2019/9/1 - 17:12
 */
public class TestBlockingQueue1 {

    public static void main(String[] args) {

        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);

        try {
            blockingQueue.put("aaa");
            blockingQueue.put("bbb");
            blockingQueue.put("ccc");
//            blockingQueue.put("xxx");

            System.out.println("==========================");

            System.out.println(blockingQueue.take());
            System.out.println(blockingQueue.take());
            System.out.println(blockingQueue.take());
            System.out.println(blockingQueue.take());

        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
