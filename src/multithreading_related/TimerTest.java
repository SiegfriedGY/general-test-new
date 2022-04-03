package multithreading_related;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;

public class TimerTest {

    public static void main(String[] args) {

        Timer myTimer = new Timer();
//        myTimer.schedule(()-> System.out.println(new Date()), 2000, 5000);
        myTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println(new Date());
            }
        }, 2000, 3000);
        ScheduledExecutorService service = new ScheduledThreadPoolExecutor(3);

    }
}
