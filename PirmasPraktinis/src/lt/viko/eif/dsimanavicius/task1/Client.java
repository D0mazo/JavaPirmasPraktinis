package lt.viko.eif.dsimanavicius.task1;

import java.io.*;
import java.net.Socket;

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

    /** File paths. */
    private static final String SAVE_PATH = "out/received_siunta.xml";
    private static final String OUTPUT_PATH = "out/isvestis.xml";

    public static void main(String[] args) {
        try (
                Socket socket = new Socket(HOST, PORT);
                InputStream in = socket.getInputStream()
        ) {
            System.out.println("Connected to server!");

            // 📁 Prepare file
            File file = new File(SAVE_PATH);
            file.getParentFile().mkdirs(); // ensure /out exists

            // 💾 Save incoming XML safely
            try (FileOutputStream fileOut = new FileOutputStream(file)) {
                byte[] buffer = new byte[4096];
                int bytesRead;

                while (true) {
                    try {
                        bytesRead = in.read(buffer);
                        if (bytesRead == -1) break;
                        fileOut.write(buffer, 0, bytesRead);
                    } catch (IOException e) {
                        // 🔥 handles "Connection reset"
                        System.out.println("Connection closed by server.");
                        break;
                    }
                }
            }

            System.out.println("XML file received and saved.\n");

            JAXBTransformer transformer = new JAXBTransformer();

            // 🔄 XML → POJO
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

            // 🔄 POJO → XML
            System.out.println("\nfrom Plain Old Java Object to XML\n");

            File outputFile = new File(OUTPUT_PATH);
            outputFile.getParentFile().mkdirs();

            transformer.transformToXML(siunta, outputFile.getPath());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}