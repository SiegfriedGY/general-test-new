package IO_related;

import java.io.*;

/**
 * @author Siegfried GENG
 * @date 2019/8/27 - 17:21
 */
public class TestIOFileCopy {

    public static void main(String[] args) {

        try {
            File file = new File("D:"+File.separator+"CATTI二笔成绩官网截图.png");
            System.out.println(file.exists());
            FileInputStream fis = new FileInputStream(file);
            BufferedInputStream bis = new BufferedInputStream(fis);

            FileOutputStream fos = new FileOutputStream("D:"+File.separator+"复制.png");
            BufferedOutputStream bos = new BufferedOutputStream(fos);

            byte[] bytes = new byte[1024];

            int len = 0;
            while((len = bis.read(bytes)) != -1){
                bos.write(bytes, 0, len);
            }
            System.out.println("复制完毕！");
//            fis.close();
//            bis.close();
//
//            fos.close();
//            bos.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
