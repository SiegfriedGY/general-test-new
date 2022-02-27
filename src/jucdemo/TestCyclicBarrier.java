package jucdemo;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author Siegfried GENG
 * @date 2019/9/1 - 15:58
 */
public class TestCyclicBarrier {

    public static void main(String[] args) {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(8, () -> System.out.println("====人到齐了，可以开始开会！"));

        for (int i = 0; i < 8; i++) {
            final int tempInt = i+1;
            new Thread( ()-> {
                System.out.println("这是第" + tempInt +"个人...");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }, Thread.currentThread().getName()).start();
        }
    }
}
