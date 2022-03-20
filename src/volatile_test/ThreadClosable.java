package volatile_test;

public class ThreadClosable extends Thread {

    private boolean started = true;
//    private volatile boolean started = true;

    @Override
    public void run() {
        while (started) {
            System.out.println("啊啊啊啊啊啊啊啊啊啊啊啊啊");
        }
    }

    public void close(){
        this.started = false;
    }
}
