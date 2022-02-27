package others;

import java.io.IOException;

public class ShutdownTest {
    public static void main(String[] args) {
        try {
//            Runtime.getRuntime().exec("shutdown -s -t 3600");
            Runtime.getRuntime().exec("shutdown -a");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
