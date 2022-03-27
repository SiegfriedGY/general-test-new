package multithreading_related;

import volatile_test.ThreadClosable;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class ProducerConsumerSimulation {

    public static void main(String[] args) {
        BlockingQueue<String> msgQueue = new LinkedBlockingDeque<>();
        new Thread(new Producer(msgQueue)).start();
        new Thread(new Consumer(msgQueue)).start();
    }
}

class Producer implements Runnable{
    BlockingQueue<String> msgQueue;
    public Producer (BlockingQueue<String> msgQueue){
        this.msgQueue = msgQueue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            String msg = "Produced message no." + (i+1);
            System.out.println(msg);
            try {
                msgQueue.put(msg);
//                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
    }
}

class Consumer implements Runnable{
    BlockingQueue<String> msgQueue;
    public Consumer (BlockingQueue<String> msgQueue){
        this.msgQueue = msgQueue;
    }

    @Override
    public void run() {
        while (true){
            try {
                System.out.println(msgQueue.take() + " is consumed...");
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());;
                e.printStackTrace();
            }
        }
    }
}