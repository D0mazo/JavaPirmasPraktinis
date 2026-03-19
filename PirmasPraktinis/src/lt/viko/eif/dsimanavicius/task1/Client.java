package lt.viko.eif.dsimanavicius.task1;

import java.io.*;
import java.net.*;

/**
 * Simple client that receives siunta.xml from server and transforms it to POJO.
 *
 * @author Dominykas
 */
public class Client {

    /** Server address. */
    private static final String HOST = "localhost";

    /** Port to connect to. */
    private static final int PORT = 5000;

    /** Path where received file will be saved. */
    private static final String SAVE_PATH =
            "src/lt/viko/eif/dsimanavicius/task1/received_siunta.xml";

    /**
     * Connects to server, receives XML file and transforms it to POJO.
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) throws Exception {

        // Step 1 - connect and receive XML file from server
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
        System.out.println("XML file received and saved.");

        // Step 2 - transform received XML to POJO and print to console
        System.out.println("\n=== Transforming XML to POJO ===");
        JAXBTransformer transformer = new JAXBTransformer();
        Siunta siunta = transformer.transformToPOJO(SAVE_PATH);

        // Step 3 - print all values to console
        System.out.println("\n=== Shipment Details ===");
        System.out.println("Shipment ID  : " + siunta.getShipmentId());
        System.out.println("Sender       : " + siunta.getSender());
        System.out.println("Origin       : " + siunta.getOrigin());
        System.out.println("Destination  : " + siunta.getDestination());
        System.out.println("Total weight : " + siunta.getTotalWeight());
        System.out.println("Delivered    : " + siunta.isDelivered());
        System.out.println("Priority     : " + siunta.getPriority());

        System.out.println("\n=== Package Items ===");
        for (SiuntaItem item : siunta.getPackageItems()) {
            System.out.println("  ID: "          + item.getId()
                    + " | Description: " + item.getDescription()
                    + " | Weight: "      + item.getWeight() + " kg");
        }
    }
}