package string_and_char_related;

/**
 * @author Siegfried GENG
 * @date 2019/8/17 - 18:17
 */
public class TestSubString {

    public static void main(String[] args) {
        String str = "/abc";
        System.out.println(str.substring(1));

        str = "abcdefg";
        System.out.println(str.substring(3,6));

        str = "13:15:17";
        System.out.println(str.substring(0,2));
        System.out.println(str.substring(3,5));
        System.out.println(str.substring(6));
    }
}
