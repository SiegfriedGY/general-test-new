package file_related;

import java.io.File;

public class FileDelete {
    public static void main(String[] args) {

        synchronized ("abc") {
            System.out.println("qunimei");
        }

        String path = "D:\\技术学习\\项目实战：医疗项目-尚医通\\视频";
        File dir = new File(path);
        System.out.println(dir.exists());
        File[] files = dir.listFiles();
        for (File file : files) {
//            if (!file.getName().endsWith("avi")){
//                System.out.println(file.getName());
//                file.delete();
            String originalName = file.getName();
            if (originalName.split("-")[0].length()==2){
//                System.out.println(file.getName());
                file.renameTo(new File(path + File.separator + "0" + originalName));
            }
        }
    }
}
