package callable;

import java.util.concurrent.*;

/**
 * @author Siegfried GENG
 * @date 2019/9/1 - 23:39
 */
public class TestCallable {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        // 方法一：用FutureTask去封装Callable，再把FutureTask自己执行，最后取返回值。
        FutureTask<Integer> task = new FutureTask<>( ()-> {
            int sum = 0;
            for (int i = 0; i < 100; i++) {
                sum += i;
            }
            return sum;
        });
        executorService.submit(task);

        // 方法二：直接提交执行一个Callable，得到Future，再取返回值。
        Future<Integer> future = executorService.submit(() -> {
            int sum = 0;
            for (int i = 0; i < 100; i++) {
                sum += i;
            }
            return sum;
        });

        try {
            Integer integer = future.get();
            System.out.println(integer);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }


    }
}

class MyCallable implements Callable<String>{
    @Override
    public String call() throws IndexOutOfBoundsException {
        return "去你妹";
    }
}
