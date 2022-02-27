package jucdemo;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author Siegfried GENG
 * @date 2019/9/1 - 16:15
 */
public class TestSemaphore {

    public static void main(String[] args) {

        Semaphore semaphore = new Semaphore(4, false);

        for (int i = 0; i < 6; i++) {
            final int tempInt = i + 1;
            new Thread( ()->{
                try {
                    semaphore.acquire();
                    System.out.println("第" + tempInt + "号车抢到车位...");
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println("第" + tempInt + "号车使用完毕，释放车位！");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();    // 注意要把release()方法写在finally里！！
                }
            }).start();
        }

    }


}
