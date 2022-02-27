package others;

import java.math.BigDecimal;

public class TestBigDecimal {

    public static void main(String[] args) {
        double a = 3.4;
        double b = Double.parseDouble("3.4");
        System.out.println(new BigDecimal(3.4).compareTo(new BigDecimal(b)) == 0);

    }
}
