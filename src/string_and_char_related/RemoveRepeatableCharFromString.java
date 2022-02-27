package string_and_char_related;

public class RemoveRepeatableCharFromString {
    
    public static void main(String[] args){

        String src = "()()()";

        for (int i = 0; i < src.length(); i++) {
            String rest = "";
            if (i == 0){
                rest = src.substring(1, src.length());
            } else if (i==src.length()-1) {
                rest = src.substring(0, src.length()-1);
            } else {
                rest = src.substring(0,i) + src.substring(i+1, src.length());
            }
            System.out.println("第"+(i+1)+"轮的rest为：" + rest);
        }


    }
}
