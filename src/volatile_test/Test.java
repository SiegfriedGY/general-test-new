package volatile_test;

public class Test {

    public static void main(String[] args) {

        ThreadClosable thread = new ThreadClosable();
        thread.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.close();

    }
}
