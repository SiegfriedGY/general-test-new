package string_and_char_related;

public class StringEqualsTest {

    public static void main(String[] args) {

        String a = "abc";
        String b = new String("abc");

        System.out.println(a == b);
        System.out.println(a.equals(b));

        Object abj = new Object();

    }
}
