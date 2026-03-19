package lt.viko.eif.dsimanavicius.task1;

import java.io.*;
import java.net.*;

/**
 * Simple server that sends siunta.xml to a client over network.
 *
 * @author Dominykas
 */
public class Server {

    /** Port to listen on. */
    private static final int PORT = 5000;

    /** Path to the XML file. */
    private static final String XML_FILE_PATH = "src/lt/viko/eif/dsimanavicius/task1/siunta.xml";

    /**
     * Default constructor.
     */
    public Server() {
    }

    /**
     * Starts the server and sends the XML file to one client.
     *
     * @param args command line arguments (not used)
     * @throws IOException if server socket fails
     */
    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server started. Waiting for client...");

        Socket socket = serverSocket.accept();
        System.out.println("Client connected!");

        FileInputStream fileIn = new FileInputStream(XML_FILE_PATH);
        OutputStream out = socket.getOutputStream();

        byte[] buffer = new byte[4096];
        int bytesRead;

        while ((bytesRead = fileIn.read(buffer)) != -1) {
            out.write(buffer, 0, bytesRead);
        }

        out.flush();
        fileIn.close();
        socket.close();
        serverSocket.close();

        System.out.println("File sent. Connection closed.");
    }
}