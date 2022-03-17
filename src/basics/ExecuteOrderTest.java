package basics;

public class ExecuteOrderTest {

    {
        System.out.println("non static block 2");
    }

    {
        System.out.println("non static block");
    }

    static {
        System.out.println("static block");
    }

    private EqualsSymbolTest test = new EqualsSymbolTest();



    public static void main(String[] args) {
        ExecuteOrderTest test = new ExecuteOrderTest();
    }
}
