package IO_related;

import java.io.*;

/**
 * @author Siegfried GENG
 * @date 2019/8/28 - 17:17
 */
public class TestFileCopy2 {

    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("D:"+ File.separator+"微信公众号相关信息.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            String line = null;
            while((line = br.readLine())!=null){
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
