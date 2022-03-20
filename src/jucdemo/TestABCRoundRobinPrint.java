package jucdemo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Siegfried GENG
 * @date 2019/9/1 - 22:24
 */
public class TestABCRoundRobinPrint {

    public static void main(String[] args) {
        RoundRobin roundRobin = new RoundRobin();

        new Thread(()->{
            for (int i = 0; i < 3; i++) {
                roundRobin.print5(i+1);
            }
        }, "A").start();

        new Thread(()->{
            for (int i = 0; i < 3; i++) {
                roundRobin.print10(i+1);
            }
        }, "B").start();

        new Thread(()->{
            for (int i = 0; i < 3; i++) {
                roundRobin.print15(i+1);
            }
        }, "C").start();
    }
}


class RoundRobin {

    private int num = 1;    //标志位，线程间互相通信的信号灯
    private Lock lock = new ReentrantLock();

    // 相当于一把锁配了三把钥匙
    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();
    private Condition c3 = lock.newCondition();

    public void print5(int round) {
        lock.lock();
        try {
            // 为防止多线程环境下【虚假唤醒】问题，必须用while循环，而不能用if一次性判断。
            while(num != 1){
                c1.await();
            }
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + "\t第" + round + "轮-第" + (i+1)+"次");
            }
            num = 2;
            c2.signal();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void print10(int round) {
        lock.lock();
        try {
            // 为防止多线程环境下【虚假唤醒】问题，必须用while循环，而不能用if一次性判断。
            while(num != 2){
                c2.await();
            }
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + "\t第" + round + "轮-第" + (i+1)+"次");
            }
            num = 3;
            c3.signal();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void print15(int round) {
        lock.lock();
        try {
            // 为防止多线程环境下【虚假唤醒】问题，必须用while循环，而不能用if一次性判断。
            while(num != 3){
                c3.await();
            }
            for (int i = 0; i < 15; i++) {
                System.out.println(Thread.currentThread().getName() + "\t第" + round + "轮-第" + (i+1)+"次");
            }
            num = 1;
            System.out.println("=======第" + round + "轮结束=======");  // 只要C打印完15次，则这一轮就结束
            c1.signal();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}
