package interview;

public class CustomizedRegExp {

    // 新路面试第二题
    // 要求是：自定义String正则表达式，比如*代表空格，@代表元音字母，#代表辅音字母。

    public static void main(String[] args){

//        System.out.println(method1("*c", "abcabc"));
//        System.out.println(method2("c@","abcabac"));
        System.out.println(method3("#op","abcabceftopx"));
    }

    public static boolean method1(String regWithSpace, String target){

        String regReal = regWithSpace.replace("*", " ");
        System.out.println(regReal);
        return target.contains(regReal);
    }

    public static boolean method2(String regWithVowel, String target){
        char[] vowels = {'a','e','i','o','u'};
        for (int i = 0; i < vowels.length; i++) {
            String regReal = regWithVowel.replace('@', vowels[i]);
            System.out.println(regReal);
            if (target.contains(regReal)){
                System.out.println(target+"包含此轮匹配项");
                return true;
            } else {
                System.out.println(target+"不包含此轮匹配项");
            }
        }
        return false;
    }

    public static boolean method3(String regWithConsonant, String target){

        if (!target.contains(regWithConsonant.replaceAll("#",""))) {
            System.out.println(target + "不含有正则中除#之外的字符");
            return false;
        }

        char[] consonants = {'b','c','d','f','g','h','j','k','l','m','n','p','q','r','s','t','v','w','x','y','z'};

        for (int i = 0; i < consonants.length; i++) {
            String regReal = regWithConsonant.replace('#', consonants[i]);
            System.out.println(regReal);
            if (target.contains(regReal)){
                System.out.println(target+"包含此轮匹配项");
                return true;
            } else {
                System.out.println(target+"不包含此轮匹配项");
            }
        }
        return false;
    }
    
}
