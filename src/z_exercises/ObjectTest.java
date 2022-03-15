package z_exercises;

public class ObjectTest {
    private static ObjectTest ot = new ObjectTest();

    public static void main(String[] args) {
        System.out.println(ot);
    }
    public String toString(){
        return "is"+this;
    }
}
