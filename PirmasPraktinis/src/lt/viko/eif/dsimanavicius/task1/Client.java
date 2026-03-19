package lt.viko.eif.dsimanavicius.task1;

import java.io.*;
import java.net.*;

/**
 * Simple client that receives siunta.xml from server,
 * transforms it to POJO and prints values to console.
 * Also transforms POJO back to XML and prints to console.
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
            "src/lt/viko/eif/dsimanavicius/task1/Out/received_siunta.xml";

    /**
     * Default constructor.
     */
    public Client() {
    }

    /**
     * Connects to server, receives XML, transforms to POJO,
     * then transforms POJO back to XML and prints both to console.
     *
     * @param args command line arguments (not used)
     * @throws Exception if connection or transformation fails
     */
    public static void main(String[] args) throws Exception {

        // receive XML file from server
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
        System.out.println("XML file received and saved.\n");

        JAXBTransformer transformer = new JAXBTransformer();

        // transform received XML to POJO and print values to console
        System.out.println("XML to Plain Old Java Object");
        Siunta siunta = transformer.transformToPOJO(SAVE_PATH);

        System.out.println("\nShipment ID  : " + siunta.getShipmentId());
        System.out.println("Sender       : " + siunta.getSender());
        System.out.println("Origin       : " + siunta.getOrigin());
        System.out.println("Destination  : " + siunta.getDestination());
        System.out.println("Total weight : " + siunta.getTotalWeight());
        System.out.println("Delivered    : " + siunta.isDelivered());
        System.out.println("Priority     : " + siunta.getPriority());
        System.out.println("\nPackage items:");
        for (SiuntaItem item : siunta.getPackageItems()) {
            System.out.println("  ID: " + item.getId()
                    + " | " + item.getDescription()
                    + " | " + item.getWeight() + " kg");
        }

        // transform POJO back to XML and print to console
        System.out.println("\nfrom Plain Old Java Object to XML\n");
        transformer.transformToXML(siunta,
                "src/lt/viko/eif/dsimanavicius/task1/Out/isvestis.xml");
    }
}