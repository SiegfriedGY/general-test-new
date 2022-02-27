package algorithms_and_maths;

public class TestNullCompare {
    public static void main(String[] args) {

        Long obj = 2L;
        if (obj > 0) {
            obj = null;
        }
        System.out.println(obj > 0); // Exception in thread "main" java.lang.NullPointerException
    }
}
