package multithreading_related;

public class SynchronizedTest {
    public static void main(String[] args) {
        Controller controller = new Controller(new Service());
        controller.methodA1();
    }
}

class Controller {
    private Service service;
    public Controller(Service service) {
        this.service = service;
    }
    public void methodA() {
        System.out.println("This is methodA");
    }
    public synchronized void methodA1() {
        service.methodB();
    }
}

class Service {

    public Service() {

    }
    public synchronized void methodB() {
        System.out.println("This is methodB");
    }
}
