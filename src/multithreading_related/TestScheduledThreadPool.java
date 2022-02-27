package multithreading_related;

import java.util.Random;
import java.util.concurrent.*;

/**
 * @author Siegfried GENG
 * @date 2019/8/3 - 17:51
 */
public class TestScheduledThreadPool {

    public static void main(String[] args) {

        ScheduledExecutorService pool = Executors.newScheduledThreadPool(3);

        for (int i = 0; i < 10; i++) {
            ScheduledFuture<Integer> future = pool.schedule(() -> {
                int num = new Random().nextInt(100);    /// 生成随机数
                System.out.println(Thread.currentThread().getName() + "=====" + num);
                return num;
            }, 1, TimeUnit.SECONDS);

            try {
                Integer integer = future.get();
                System.out.println(integer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

        pool.shutdown();

    }

}
