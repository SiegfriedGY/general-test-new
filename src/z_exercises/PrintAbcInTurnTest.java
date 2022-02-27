package z_exercises;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintAbcInTurnTest {

    public static void main(String[] args) {
        PrintAbcInTurn printer = new PrintAbcInTurn();
        new Thread( () -> {
            for (int i = 0; i < 3; i++) {
                printer.printA(i+1);
            }
        }).start();
        new Thread( () -> {
            for (int i = 0; i < 3; i++) {
                printer.printB(i+1);
            }
        }).start();
        new Thread( () -> {
            for (int i = 0; i < 3; i++) {
                printer.printC(i+1);
            }
        }).start();

    }

}

class PrintAbcInTurn {
    private int num = 1;
    private Lock lock = new ReentrantLock();
    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();
    private Condition c3 = lock.newCondition();

    public void printA(int round) {
        lock.lock();
        try {
            while (num != 1) {
                c1.await();
            }
            for (int i = 0; i < 5; i++) {
                System.out.println("A--打印第" + round + "轮，第" +(i+1) + "次    " + Thread.currentThread().getName());
            }
            num = 2;
            c2.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printB(int round) {
        lock.lock();
        try {
            while (num != 2) {
                c2.await();
            }
            for (int i = 0; i < 10; i++) {
                System.out.println("B--打印第" + round + "轮，第" + (i+1) + "次    " + Thread.currentThread().getName());
            }
            num = 3;
            c3.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printC(int round) {
        lock.lock();
        try {
            while (num != 3) {
                c3.await();
            }
            for (int i = 0; i < 15; i++) {
                System.out.println("C--打印第" + round + "轮，第" + (i+1) + "次    " + Thread.currentThread().getName());
            }
            System.out.println("==================");
            num = 1;
            c1.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
