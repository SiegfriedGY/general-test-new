package multithreading_related;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Siegfried GENG
 * @date 2019/8/3 - 0:15
 */
public class TestAtomic {

    public static void main(String[] args) {
        Runnable runnable = new AtomicDemo();
        for (int i = 0; i < 10; i++) {
            new Thread(runnable).start();
        }
    }
}

class AtomicDemo implements Runnable{

//    private int serialNumber = 0;

    private AtomicInteger serialNumber = new AtomicInteger(0);
    public int getSerialNumber() {
//        return serialNumber++;
        return serialNumber.getAndIncrement();
    }

    @Override
    public void run() {
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"的结果是:"+getSerialNumber());
    }
}
