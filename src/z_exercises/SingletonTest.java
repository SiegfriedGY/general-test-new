package z_exercises;

public class SingletonTest {

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            System.out.println(Singleton.getInstance());
        }
    }
}

class Singleton {
    private static volatile Singleton instance = null;

    private Singleton () {
        System.out.println(Thread.currentThread().getName() + "calls constructor...");
    }

    public static Singleton getInstance() {

        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
