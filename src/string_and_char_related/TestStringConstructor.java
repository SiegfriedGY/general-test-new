package string_and_char_related;

public class TestStringConstructor {

    public static void main(String[] args) {

        String str = new String("abc");
//        System.out.println(str.value);
        System.out.println(str.hashCode());
        String str1 = new String("abc");
        System.out.println(str1.hashCode());

    }
}
