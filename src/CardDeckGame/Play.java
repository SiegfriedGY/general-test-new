package CardDeckGame;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Play {

    private LinkedList<Card> cardDeck;
    private int num = 1;    //标志位，线程间互相通信的信号灯
    private static final int THRESHOLD = 50;
    private volatile boolean isGameOver = false;
    public Play(LinkedList<Card> cardDeck) {
        this.cardDeck = cardDeck;
    }

    private ReentrantLock lock = new ReentrantLock();
    Condition conditionA = lock.newCondition();
    Condition conditionB = lock.newCondition();
    Condition conditionC = lock.newCondition();

    int sumForA = 0;
    int sumForB = 0;
    int sumForC = 0;

    public void sendCardToA() {
        lock.lock();
        try {
            while (!isGameOver) {
                while(num != 1 ){
                    conditionA.await();
                    System.out.println("conditionA.await() conditionA.await()");
                }
                Card card = cardDeck.pollFirst();
                System.out.println("Player A 本轮抽到：" + card);
                sumForA += card.getNumber();
                System.out.println("         本轮合计：" + sumForA);
                if (sumForA > THRESHOLD) {
                    System.out.println("Player A 总分：" + sumForA +", 比赛结束！");
                    this.isGameOver = true;
                    Thread.currentThread().stop();
                } else {
                    num = 2;
                    conditionB.signal();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (lock.isHeldByCurrentThread()) {
                System.out.println("去你妹！！！！！！！A");
                lock.unlock();
                System.out.println(lock.isHeldByCurrentThread()  + " A");
                System.out.println("Thread.activeCount(): " + Thread.activeCount());
            }
        }
    }

    public void sendCardToB() {
        lock.lock();
        try {
            while (!isGameOver ){
                while(num != 2){
                    conditionB.await();
                    System.out.println("conditionB.await() conditionB.await()");
                }
                Card card = cardDeck.pollFirst();
                System.out.println("Player B 本轮抽到：" + card);
                sumForB += card.getNumber();
                System.out.println("         本轮合计：" + sumForB);
                if (sumForB > THRESHOLD) {
                    System.out.println("Player B 总分：" + sumForB +", 比赛结束！");
                    this.isGameOver = true;
                    Thread.currentThread().stop();
                } else {
                    num = 3;
                    conditionC.signal();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (lock.isHeldByCurrentThread()) {
                System.out.println("去你妹！！！！！！！B");
                lock.unlock();
                System.out.println(lock.isHeldByCurrentThread()  + " B");
                System.out.println("Thread.activeCount(): " + Thread.activeCount());
            }
        }
    }

    public void sendCardToC() {
        lock.lock();
        try {
            while (!isGameOver) {
                while(num != 3){
                    conditionC.await();
                    System.out.println("conditionC.await() conditionC.await()");
                }
                Card card = cardDeck.pollFirst();
                System.out.println("Player C 本轮抽到：" + card);
                sumForC += card.getNumber();
                System.out.println("         本轮合计：" + sumForC);
                if (sumForC > THRESHOLD) {
                    System.out.println("Player C 总分：" + sumForC +", 比赛结束！");
                    this.isGameOver = true;
                    Thread.currentThread().stop();
                } else {
                    num = 1;
                    conditionA.signal();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (lock.isHeldByCurrentThread()) {
                System.out.println("去你妹！！！！！！！C-------------------------");
                lock.unlock();
                System.out.println(lock.isHeldByCurrentThread() + " C");
                System.out.println("Thread.activeCount(): " + Thread.activeCount());
            }
        }
    }

    public boolean isGameOver() {
        return this.isGameOver;
    }
}
