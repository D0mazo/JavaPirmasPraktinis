package lt.viko.eif.dsimanavicius.task1;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class Client {

    private static final String SERVER_ADDRESS = "localhost";
    private static final int PORT = 5000;

    public static void main(String[] args) {

        System.out.println("Connecting to server...");

        try (
                Socket socket = new Socket(SERVER_ADDRESS, PORT);
                InputStream inputStream = socket.getInputStream();
                FileOutputStream fileOutputStream = new FileOutputStream("received_siunta.xml");
                BufferedOutputStream bufferedOutputStream =
                        new BufferedOutputStream(fileOutputStream)
        ) {

            byte[] buffer = new byte[4096];
            int bytesRead;

            while ((bytesRead = inputStream.read(buffer)) != -1) {
                bufferedOutputStream.write(buffer, 0, bytesRead);
            }

            bufferedOutputStream.flush();

            System.out.println("XML file received successfully.");
            System.out.println("Saved as: received_siunta.xml");

        } catch (IOException e) {
            System.out.println("Error receiving file: " + e.getMessage());
        }
    }
}