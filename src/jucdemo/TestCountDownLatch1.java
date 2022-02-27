package jucdemo;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class TestCountDownLatch1 {

    public static void main(String[] args) {

        final CountDownLatch latch = new CountDownLatch(6);
        AtomicInteger atmInteger = new AtomicInteger();

        ChildTask latchDemo = new ChildTask(latch, atmInteger);
        for (int i = 0; i < 6; i++) {
            new Thread(latchDemo).start();
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("init: " + atmInteger);
    }
}

class ChildTask implements Runnable{

    private CountDownLatch latch;
    private AtomicInteger atomicInteger;

    public ChildTask(CountDownLatch latch, AtomicInteger atomicInteger) {
        this.latch = latch;
        this.atomicInteger = atomicInteger;
    }
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            this.atomicInteger.getAndIncrement();
        }
        latch.countDown();
    }
}

