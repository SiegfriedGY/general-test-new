package callable;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * @author Siegfried GENG
 * @date 2019/9/2 - 0:13
 */
public class CallableApplication {

    public static void main(String[] args) {

        FutureTask<String> stringFutureTask = new FutureTask<>(new MyCallable());
        try {
            stringFutureTask.get();
        } catch (IndexOutOfBoundsException | InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }


        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (Integer i : list) {
            if (i % 2 == 0){
                executorService.submit(()-> System.out.println(i + "为偶数---"));
            } else {
                executorService.submit(()-> System.out.println(i + "为奇数+++"));
            }
        }

    }
}
