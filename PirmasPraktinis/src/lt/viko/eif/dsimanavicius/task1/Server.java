package lt.viko.eif.dsimanavicius.task1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Simple server that sends siunta.xml to a client over network.
 *
 * @author Dominykas
 */
public class Server {

    /** Port to listen on. */
    private static final int PORT = 5000;

    /** Path to the XML file. */
    private static final String XML_FILE_PATH =
            "PirmasPraktinis/src/lt/viko/eif/dsimanavicius/task1/Files/siunta.xml";

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {

            System.out.println("Server started. Waiting for client...");

            try (Socket socket = serverSocket.accept()) {
                System.out.println("Client connected!");

                File file = new File(XML_FILE_PATH);

                // 🔥 Debug + safety check
                System.out.println("Looking for file at: " + file.getAbsolutePath());

                if (!file.exists()) {
                    System.out.println("❌ File not found! Fix the path.");
                    return;
                }

                try (
                        FileInputStream fileIn = new FileInputStream(file);
                        OutputStream out = socket.getOutputStream()
                ) {
                    byte[] buffer = new byte[4096];
                    int bytesRead;

                    while ((bytesRead = fileIn.read(buffer)) != -1) {
                        out.write(buffer, 0, bytesRead);
                    }

                    out.flush(); // 🔥 VERY IMPORTANT
                }

                System.out.println("File sent. Connection closed.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}