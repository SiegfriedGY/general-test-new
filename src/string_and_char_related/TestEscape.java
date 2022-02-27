package string_and_char_related;

public class TestEscape {
    
    public static void main(String[] args){
        
//        String str = "abc_001_fff";
        String str = "123_";
//        str = str.replaceAll("_","\\_");
        str = str.replace("_","\\_");
        System.out.println(str);
                
    }
}
