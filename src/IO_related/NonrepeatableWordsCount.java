package IO_related;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NonrepeatableWordsCount {

    public static void main(String[] args){

        String filePath = "D:/dev/test.txt";

        try {
            FileInputStream fis = new FileInputStream(filePath);
            InputStreamReader inputStreamReader = new InputStreamReader(fis);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            StringBuffer sb = new StringBuffer();
            String str;
            while ( (str = bufferedReader.readLine()) != null) {
//                System.out.println(str);
                sb.append(str +" ");
            }
            String result = sb.toString();
            System.out.println(result);

            result = result.replace(",","");
            result = result.replace(".","");
            result = result.replace("– ","");
            result = result.replaceAll("  "," "); // 将多个空格替换为一个
            System.out.println(result);

            String[] split = result.split(" ");
            System.out.println(Arrays.toString(split));
            System.out.println("文章总长度：" + split.length);

            Set<String> strSet = new HashSet<>();
            for (int i = 0; i <split.length; i++) {
                strSet.add(split[i]);
            }

//            List<String> strList = Arrays.asList(split);
//            Set<String> strSet = new HashSet<>(strList);
            System.out.println("文章词汇数：" + strSet.size());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
