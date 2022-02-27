package multithreading_related;

public class ThreadTest extends Thread {

    @Override
    public void run() {
        System.out.println(this.getName()+" "+"This is thread_related.ThreadTest");
    }

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            new ThreadTest().start();
        }

    }
}
