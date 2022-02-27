package IO_related;

import java.io.File;

/**
 * @author Siegfried GENG
 * @date 2019/8/17 - 2:14
 */
public class TestFile {

    public static void main(String[] args) {

        File file = new File("d:/upload");

        if (!file.exists()){
            file.mkdir();
            System.out.println("不存在，创建成功;");
        } else {
            System.out.println("已存在！");
        }

    }
}
