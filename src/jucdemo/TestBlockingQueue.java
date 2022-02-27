package jucdemo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author Siegfried GENG
 * @date 2019/9/1 - 23:14
 */
public class TestBlockingQueue {

    public static void main(String[] args) {

        try {
            BlockingQueue<String> queue1 = new ArrayBlockingQueue<String>(3);
            queue1.put("aaa");
            queue1.put("bbb");
            queue1.put("ccc");
            System.out.println(queue1.offer("ddd", 5L, TimeUnit.SECONDS));

            System.out.println(queue1.poll());
            System.out.println(queue1.poll());
            System.out.println(queue1.poll());

            System.out.println(queue1.poll(3L, TimeUnit.SECONDS));


        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }


}
