package string_and_char_related;

public class RemoveCharFromString {
    
    public static void main(String[] args){
        String src = "abcde";
//        String dst = src.replaceAll(String.valueOf('b'), "");
        String dst = src.replaceAll("b","");
        System.out.println(dst);
    }
}
