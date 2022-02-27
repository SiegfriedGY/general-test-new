package interview;

import java.util.Random;

public class Test {
    public static void main(String[] args){
        int n = 6488;
        String str = "86300";
        System.out.println(n % 1000);
        System.out.println("5" + str.substring(1));
        int id = 0;
        System.out.println("id=" + id++);
        Random random = new Random();
        System.out.println(random.nextDouble());
        System.out.println(random.nextInt());
        System.out.println(random.nextInt());
        System.out.println(random.nextInt());
        System.out.println(random.nextInt());
        System.out.println(random.nextInt());
        System.out.println(random.nextInt());
        System.out.println(random.nextInt());

        TestPerson tp = new TestPerson("啊啊啊");

    }
}

class TestPerson {

    private String name;

    public TestPerson(String name) {
        this.name = name;
    }
}
