package lock;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TryLockTest {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock(false);
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            try {
                if (i == 5) {
                    Thread.sleep(2000);
                }
                lock.tryLock(1000, TimeUnit.MILLISECONDS);
                list.add(i);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(list);
    }
}
