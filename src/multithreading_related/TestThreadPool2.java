package multithreading_related;

import java.util.concurrent.*;

/**
 * @author Siegfried GENG
 * @date 2019/8/20 - 17:29
 */
public class TestThreadPool2 {

    public static void main(String[] args) {

        TimeUnit timeUnit = TimeUnit.SECONDS;

        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                3,
                5,
                10,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(3));

        for (int i = 0; i < 10; i++) {
            Future<Integer> future = executor.submit(() -> {
                int sum = 0;
                for (int i1 = 0; i1 < 100; i1++) {
                    sum += i1;
                }
                System.out.println(Thread.currentThread().getName()+"====" + sum);
                return sum;
            });

            try {
                System.out.println(future.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        executor.shutdown();
    }


}
