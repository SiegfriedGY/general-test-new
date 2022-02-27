package string_and_char_related;

/**
 * 过滤一个字符串中非法字符（只有数字和大小写字母属于合法字符）
 * @author Siegfried GENG
 * @date 2019/9/5 - 12:36
 */
public class TestFilter {
    
    public static void main(String[] args) {

        System.out.println(filterStr("去你妹xxx的12abc你妹的ZAD去你妹的！！!"));
    }

    public static String filterStr(String src){

        char[] chars = src.toCharArray();
        System.out.println(chars.length);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            char element = chars[i];
            if ((element >= 'a' && element<='z') ||         // 注意不用记ASC码值，直接用对等的char表示即可！
                    (element >= 'A' && element<='Z')||      // 但三个子条件必须多加上小括号！！
                    (element >= '0' && element<='9')) {
                sb.append(element);
            }
        }
        return sb.toString();

    }
}
