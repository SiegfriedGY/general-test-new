package interview;

public class ExplainDifferences {

    public static void main(String[] args) {
        double a = 17.09328481955906653411;
        double b = -21.3430699706312978492;
        double t = 38.43635479019036438331;

        double v1 = t * Math.sqrt(a / t * a / t + b / t * b / t);
        System.out.println(v1);

        double at = a / t;
        double bt = b / t;
        double v2 = t * Math.sqrt(at * at + bt * bt);
        System.out.println(v2);

        double v3 = Math.sqrt(a * a + b * b);
        System.out.println(v3);
    }
}
