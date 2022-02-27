package multithreading_related;

public class RunnableTest implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"   "+"This is runnable test");
    }

    public static void main(String[] args) {
        Runnable runnable = new RunnableTest();
        for (int i = 0; i < 10; i++) {
            new Thread(runnable).start();
        }
        System.out.println("===over===");
    }
}
