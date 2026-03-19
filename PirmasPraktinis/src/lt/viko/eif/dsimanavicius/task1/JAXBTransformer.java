package lt.viko.eif.dsimanavicius.task1;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import javax.xml.XMLConstants;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;

/**
 * Performs JAXB transformation from POJO to XML and back from XML to POJO.
 *
 * @author Dominykas
 */
public class JAXBTransformer {

    /** Path to the XSD schema file for validation. */
    private static final String XSD_PATH =
            "src/lt/viko/eif/dsimanavicius/task1/siunta.xsd";

    /**
     * Transforms a Siunta POJO object to XML file and prints it to console.
     *
     * @param siunta   the Siunta object to transform
     * @param filePath path where XML file will be saved
     * @throws Exception if transformation fails
     */
    public void transformToXML(Siunta siunta, String filePath) throws Exception {

        JAXBContext context = JAXBContext.newInstance(Siunta.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        marshaller.marshal(siunta, new File(filePath));
        marshaller.marshal(siunta, System.out);

        System.out.println("POJO transformed to XML successfully.");
    }

    /**
     * Transforms an XML file to a Siunta POJO object and prints it to console.
     * XML is validated against XSD schema before transformation.
     *
     * @param filePath path to the XML file
     * @return Siunta object
     * @throws Exception if transformation or validation fails
     */
    public Siunta transformToPOJO(String filePath) throws Exception {

        JAXBContext context = JAXBContext.newInstance(Siunta.class);

        SchemaFactory schemaFactory =
                SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = schemaFactory.newSchema(new File(XSD_PATH));

        Unmarshaller unmarshaller = context.createUnmarshaller();
        unmarshaller.setSchema(schema);

        Siunta siunta = (Siunta) unmarshaller.unmarshal(new File(filePath));

        System.out.println("XML transformed to POJO successfully.");
        System.out.println(siunta);

        return siunta;
    }
}