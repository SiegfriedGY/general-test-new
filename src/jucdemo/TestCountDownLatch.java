package jucdemo; /**
 * @author Siegfried GENG
 * @date 2019/8/3 - 15:12
 */

import java.util.concurrent.CountDownLatch;

/**
 * 等待所有子线程（运算）执行完之后，当前的运算才能继续执行。
 *
 */
public class TestCountDownLatch {

    public static void main(String[] args) {
        final CountDownLatch latch = new CountDownLatch(5);
        LatchDemo latchDemo = new LatchDemo(latch);

        long start = System.currentTimeMillis();
        for (int i = 0; i < 5; i++) {
            new Thread(latchDemo).start();
        }

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("共用时："+(end-start)+"毫秒！");
    }
}

class LatchDemo implements Runnable{

    private CountDownLatch latch;

    public LatchDemo(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 50000; i++) {
                if (i%2==0){
//                    System.out.println(i);
                }
            }
        } finally {
            /// 每个子线程执行完毕之后，必须让倒数锁递减一，而且是必须执行的，放在finally里比较好！
            latch.countDown();
            System.out.println("本次执行完毕！"+Thread.currentThread().getName());
        }

    }
}