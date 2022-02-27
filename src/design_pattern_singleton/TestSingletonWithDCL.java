package design_pattern_singleton;

/**
 * @author Siegfried GENG
 * @date 2019/8/31 - 11:54
 */
public class TestSingletonWithDCL {
    
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(SingletonDemo::getInstance, String.valueOf(i)).start();
        }
    }
}


class SingletonDemo{

    private static volatile SingletonDemo instance = null;  // 注意volatile关键字的使用！

    private SingletonDemo(){
        System.out.println(Thread.currentThread().getName() + "\t 我是构造方法！");
    }

    /// 采用DCL（Double Check Lock）方法，两次加锁确认
    public static SingletonDemo getInstance(){
        if (instance == null){
            synchronized (SingletonDemo.class){
                if (instance == null){
                    instance = new SingletonDemo();
                }
            }
        }
        return instance;
    }
}
