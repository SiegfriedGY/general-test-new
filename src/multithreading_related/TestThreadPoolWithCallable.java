package multithreading_related;

import java.util.Random;
import java.util.concurrent.*;

public class TestThreadPoolWithCallable {

    public static void main(String[] args) {

        int maxProcessorNum = Runtime.getRuntime().availableProcessors();   //2

        ExecutorService service = new ThreadPoolExecutor(4, maxProcessorNum*2, 3, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(100), Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());

        CountDownLatch latch = new CountDownLatch(10);

        for (int i = 0; i < 10; i++) {
            Future<Integer> future = service.submit(new MyCallable(latch));
            try {
                Integer result = future.get();
                // get()方法会阻塞当前线程，所以不用底下latch的await来等待全部线程执行完毕，这里已经会执行完毕才往下走。如果此处不用get方法，则底下必须await。
                System.out.println("第"+ (i+1) + "个任务，" + "-------------" + result);
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        try {
            System.out.println("主线程"+Thread.currentThread().getName()+"等待子线程执行完成...");
//            latch.await();  //阻塞当前线程，直到计数器的值为0
            System.out.println("所有子线程执行完毕，主线程"+Thread.currentThread().getName()+"继续执行...");
//        } catch (InterruptedException e) {
//            e.printStackTrace();
        } finally {
            service.shutdown();
        }
    }
}

class MyCallable implements Callable<Integer> {

    private CountDownLatch latch;

    public MyCallable(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public Integer call() {

        Random random = new Random();
        int num = random.nextInt(2000000000);
        for (int i = 0; i < 2000000000; i++) {
            if (i==num) {
                System.out.println(Thread.currentThread().getName() + " 找到了，数字是：" + num);
                break;
            }
        }
        latch.countDown();
        return num;
    }
}
