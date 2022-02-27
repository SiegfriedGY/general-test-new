package socket;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class GeneralClient {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        try {
            Socket socket = new Socket("localhost",9999);
            OutputStream outputStream = socket.getOutputStream();

            System.out.println("请输入内容：");
            String line = scanner.nextLine();

            outputStream.write(line.getBytes());

            outputStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
