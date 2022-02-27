package string_and_char_related;

/**
 * @author Siegfried GENG
 * @date 2019/8/16 - 23:15
 */
public class TestStringLastIndexOf{

    public static void main(String[] args) {

        String path = "d:/test/abc.txt";

        String name = path.substring(path.lastIndexOf("/")+1);

        System.out.println(name);

    }

}
