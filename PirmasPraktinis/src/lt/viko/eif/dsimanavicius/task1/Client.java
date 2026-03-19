package lt.viko.eif.dsimanavicius.task1;

import java.io.*;
import java.net.*;

/**
 * Simple client that receives siunta.xml from the server over network.
 *
 * @author Dominykas
 */
public class Client {

    /** Server address. */
    private static final String HOST = "localhost";

    /** Port to connect to. */
    private static final int PORT = 5000;

    /** Path where received file will be saved. */
    private static final String SAVE_PATH = "src/lt/viko/eif/dsimanavicius/task1/received_siunta.xml";

    /**
     * Connects to server and receives the XML file.
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) throws IOException {

        Socket socket = new Socket(HOST, PORT);
        System.out.println("Connected to server!");

        InputStream in = socket.getInputStream();
        FileOutputStream fileOut = new FileOutputStream(SAVE_PATH);

        byte[] buffer = new byte[4096];
        int bytesRead;

        while ((bytesRead = in.read(buffer)) != -1) {
            fileOut.write(buffer, 0, bytesRead);
        }

        fileOut.close();
        socket.close();

        System.out.println("File received and saved to: " + SAVE_PATH);
    }
}