package multithreading_related;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author Siegfried GENG
 * @date 2019/8/3 - 17:29
 */
public class TestThreadPool {
    
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        List<Future<Integer>> futureList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Future<Integer> future = executorService.submit(()-> {
                    int sum = 0;
                    for (int j = 0; j < 100; j++) {
                        sum += j;
                    }
                    System.out.println(Thread.currentThread().getName());
                    return sum;
            });
            try {
                futureList.add(future);
                Integer sum = future.get();
//                System.out.println("sum:"+sum);
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        executorService.shutdown();

        for (Future<Integer> integerFuture : futureList) {
            try {
                System.out.println(integerFuture.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

    }
}
