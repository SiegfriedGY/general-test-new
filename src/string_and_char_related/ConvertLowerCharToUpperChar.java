package string_and_char_related;

public class ConvertLowerCharToUpperChar {

    public static void main(String[] args){

        System.out.println(convert('a'));
        System.out.println(convert('C'));
    }

    private static char convert(char original){

        if (original >= 'a' && original <= 'z'){
            return original -= 32;
        } else {
            System.out.println("输入的不是小写字母");
            return 'X';
        }
    }
}
