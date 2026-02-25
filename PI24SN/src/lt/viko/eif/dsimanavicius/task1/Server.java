package lt.viko.eif.dsimanavicius.task1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private static final int PORT = 5000;

    public static void main(String[] args) {

        String filePath = "src/lt/viko/eif/dsimanavicius/task1/siunta.xml";

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {

            System.out.println("Server started on port " + PORT);
            System.out.println("Waiting for client connection...");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected: " + socket.getInetAddress());

                sendFile(socket, filePath);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void sendFile(Socket socket, String filePath) {
        try (
                FileInputStream fileInputStream = new FileInputStream(filePath);
                BufferedInputStream bufferedFile = new BufferedInputStream(fileInputStream);
                OutputStream outputStream = socket.getOutputStream();
                BufferedOutputStream bufferedOutput = new BufferedOutputStream(outputStream)
        ) {

            byte[] buffer = new byte[4096];
            int bytesRead;

            while ((bytesRead = bufferedFile.read(buffer)) != -1) {
                bufferedOutput.write(buffer, 0, bytesRead);
            }

            bufferedOutput.flush();
            System.out.println("File sent successfully.");

        } catch (IOException e) {
            System.out.println("Error sending file: " + e.getMessage());
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}