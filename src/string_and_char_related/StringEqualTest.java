package string_and_char_related;

public class StringEqualTest {

    public static void main(String[] args) {

        String str1 = new String("abc");
        String str2 = new String("abc");
        System.out.println(str1 == str2);
        System.out.println(str1.equals(str2));
    }
}
