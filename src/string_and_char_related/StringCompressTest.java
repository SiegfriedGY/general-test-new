package string_and_char_related;

import java.util.HashMap;
import java.util.Map;

public class StringCompressTest {
    
    public static void main(String[] args) {

        String original = "aabccccaaadddeeeeeeeeeeedddd";
        Map<Character, Integer> resultMap = new HashMap<>();
        for (int i = 0; i < original.length(); i++) {
            char c = original.charAt(i);
            if (resultMap.containsKey(c)){
                resultMap.put(c, resultMap.get(c) +1);
            } else {
                resultMap.put(c, 1);
            }
        }
        System.out.println(resultMap);
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : resultMap.entrySet()) {
            sb.append(entry.getKey().toString())
                    .append(entry.getValue());
        }

        System.out.println(sb.toString());
    }
}
