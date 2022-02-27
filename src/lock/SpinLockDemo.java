package lock;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author Siegfried GENG
 * @date 2019/9/1 - 14:25
 */
public class SpinLockDemo {

    // 构造方法里不写初始值，就是null
    AtomicReference<Thread> atomicReference = new AtomicReference<>();

    public void myLock(){

        Thread thread = Thread.currentThread();

        System.out.println(Thread.currentThread().getName() + "线程尝试获取锁...");
        // 这就是自旋锁的核心。因为compareAndSet返回的是一个boolean，就利用while循环不停地做某个操作，直到获取到锁为止。
        // 第一次不进这个循环。
        do {
//            System.out.println(thread.getName() + "没拿到锁，继续尝试...");
        } while (!atomicReference.compareAndSet(null,thread));

        System.out.println(Thread.currentThread().getName() + "线程获得锁！\n");

    }

    public void myUnlock(){
        Thread thread = Thread.currentThread();

        // 这里为什么不用do-while循环？？因为锁在自己手里，解锁肯定true。就好比上完厕所出来的时候，直接开门走人，肯定成功。
        atomicReference.compareAndSet(thread,null);
        System.out.println(Thread.currentThread().getName() + "线程释放锁====");
    }


    public static void main(String[] args) {

        SpinLockDemo spinLockDemo = new SpinLockDemo();

        new Thread( ()->{

            spinLockDemo.myLock();
            try {
                Thread.currentThread().sleep(5000); // 持有5秒钟
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            spinLockDemo.myUnlock();

        }, "AAA").start();

        // 在A线程持有锁期间，B的lock方法只能一直在自旋，等待A释放锁。
        new Thread( ()-> {
            // 保证AAA线程先执行。
            try {
                Thread.currentThread().sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            spinLockDemo.myLock();
            spinLockDemo.myUnlock();
        }, "BBB").start();

    }

}
