package lock;

import java.util.concurrent.TimeUnit;

/**
 * 张三上厕所没带纸，想让外面等待的李四给他递纸。
 * 而李四要递纸，必须让张三把门打开（假设厕所隔间底下没有缝隙，也不能从上面扔进去），
 * 这样，张三等待李四给他递纸，用完才能开门腾出厕所；而李四则等待张三开门才能给他递纸，就形成了死锁。
 * @author Siegfried GENG
 * @date 2019/9/2 - 21:47
 */

class DeadLockDemo {

    private final String resourceOne = "厕所";
    private final String resourceTwo = "纸";

    public void useToilette(){
        synchronized (resourceOne) {
            String treadName = Thread.currentThread().getName();
            System.out.println(treadName + "开始使用厕所...");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(treadName + "尝试获取纸***");
            synchronized (resourceTwo) {
                System.out.println(treadName + "获取纸成功！！！");
            }
        }
    }

    public void waitForToilette(){
        // 如果一开始就等张三都弄完出来，李四才开始，则不会出现死锁。
//        try {
//            TimeUnit.MILLISECONDS.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        synchronized (resourceTwo) {
            String treadName = Thread.currentThread().getName();
            System.out.println(treadName + "拿到纸...");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(treadName + "尝试进厕所***");
            synchronized (resourceOne) {
                System.out.println(treadName + "成功进入厕所！！！");
            }
        }
    }
}

public class TestDeadLock {

    public static void main(String[] args) {

        DeadLockDemo deadLockDemo = new DeadLockDemo();

        new Thread(deadLockDemo::useToilette, "张三").start();
        new Thread(deadLockDemo::waitForToilette, "李四").start();
    }
}
