package lt.viko.eif.dsimanavicius.task1;

import java.io.*;
import java.net.Socket;

public class Client {

    private static final String SERVER_ADDRESS = "localhost";
    private static final int PORT = 5000;

    public static void main(String[] args) {

        try (
                Socket socket = new Socket(SERVER_ADDRESS, PORT);
                InputStream inputStream = socket.getInputStream();
                FileOutputStream fileOutputStream = new FileOutputStream("received_siunta.xml");
                BufferedOutputStream bufferedOutput = new BufferedOutputStream(fileOutputStream)
        ) {

            byte[] buffer = new byte[4096];
            int bytesRead;

            while ((bytesRead = inputStream.read(buffer)) != -1) {
                bufferedOutput.write(buffer, 0, bytesRead);
            }

            bufferedOutput.flush();
            System.out.println("File received successfully.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}