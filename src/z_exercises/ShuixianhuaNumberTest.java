package z_exercises;

public class ShuixianhuaNumberTest {
    public static void main(String[] args) {
        for (int i = 100; i < 999; i++) {
            int a = i/100;
            int b = i/10 % 10;
            int c = i%10;
            if (i == Math.pow(a, 3.0) + Math.pow(b, 3.0) + Math.pow(c, 3.0)) {
                System.out.println(i);
            }
        }
    }
}
