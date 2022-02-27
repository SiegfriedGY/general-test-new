package IO_related;

import java.io.File;

/**
 * @author Siegfried GENG
 * @date 2019/8/31 - 10:55
 */
public class TestFileRename {
    
    public static void main(String[] args) {

        String path = "h:" + File.separator + "testdir";
        File dir = new File(path);
        boolean b = dir.isDirectory();
        System.out.println("是目录吗？"+ b);
        if (b){
            File[] files = dir.listFiles();
            for (File file : files) {
                String name = file.getName();
                if (name.indexOf("_") == 2){
                    System.out.println("改文件" + name + "需要改名！");
                    file.renameTo(new File(path + File.separator + "0"+ name));
                }
            }
            System.out.println("全部改完了");
        }



    }

}
