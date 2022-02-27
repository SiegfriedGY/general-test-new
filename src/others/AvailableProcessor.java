package others;

public class AvailableProcessor {

    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());
        System.out.println(Thread.currentThread().getName() + ", " + Thread.currentThread().getId());
    }
}
