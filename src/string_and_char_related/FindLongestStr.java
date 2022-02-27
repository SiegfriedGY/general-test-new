package string_and_char_related;

public class FindLongestStr {

    public static void main(String[] args){

        String str[]=new String[]{"12345","123456","1234","123","1"};
        String longest = findLongest(str);
        System.out.println(longest);

    }

    public static String findLongest(String[] str){
        int index=0;
        for(int i = 1; i <= str.length-1; i++) {
            if(str[i].length()>str[index].length()) {
                index=i;
            }
        }
        return str[index];

    }
}
