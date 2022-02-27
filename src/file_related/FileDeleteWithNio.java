package file_related;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileDeleteWithNio {

    public static void main(String[] args) throws IOException {

        Path filePath = Paths.get("D:\\temp\\123.txt");
        System.out.println(filePath.getFileName());
        System.out.println(filePath.getName(1));
        try {
            Files.delete(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
