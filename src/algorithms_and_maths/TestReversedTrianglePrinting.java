package algorithms_and_maths;

/**
 * @author Siegfried GENG
 * @date 2019/9/4 - 19:45
 */
public class TestReversedTrianglePrinting {

    public static void main(String[] args) {
        printTriangle(7);
    }

    public static void printTriangle(int n){

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                System.out.print("*");
            }
            System.out.println("\n");
        }

    }
}
