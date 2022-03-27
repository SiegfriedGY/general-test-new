package multithreading_related;


public class RunTest {

    public static void main(String[] args) {

        Thread thread = new Thread(new MyRunnable());
        thread.setDaemon(true);
        thread.start();
    }
}

class MyRunnable implements Runnable {

    @Override
    public synchronized void run() {
        // 重写时时可以加synchronized关键字的
        System.out.println("aaaaaaaaaaaaaaa");
    }
}
