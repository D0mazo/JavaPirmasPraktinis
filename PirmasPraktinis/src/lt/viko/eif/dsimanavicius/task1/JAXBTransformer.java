package lt.viko.eif.dsimanavicius.task1;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

import javax.xml.XMLConstants;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.sax.SAXSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import java.io.File;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

/**
 * Performs JAXB transformation from POJO to XML and back from XML to POJO.
 *
 * @author Dominykas
 */
public class JAXBTransformer {

    /** Path to the XSD schema file for validation. */
    private static final String XSD_PATH =
            "PirmasPraktinis/src/lt/viko/eif/dsimanavicius/task1/Files/siunta.xsd";

    /**
     * Transforms a Siunta POJO object to XML file and prints it to console.
     */
    public void transformToXML(Siunta siunta, String filePath) throws Exception {

        JAXBContext context = JAXBContext.newInstance(Siunta.class);
        Marshaller marshaller = context.createMarshaller();

        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        File outputFile = new File(filePath);
        outputFile.getParentFile().mkdirs(); // 🔥 ensure folder exists

        marshaller.marshal(siunta, outputFile);
        marshaller.marshal(siunta, System.out);

        System.out.println("POJO transformed to XML successfully.");
    }

    /**
     * Transforms XML file to POJO with XSD validation.
     */
    public Siunta transformToPOJO(String filePath) throws Exception {

        JAXBContext context = JAXBContext.newInstance(Siunta.class);

        // 🔧 SAX parser setup
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        saxParserFactory.setNamespaceAware(true);
        saxParserFactory.setFeature(
                "http://apache.org/xml/features/nonvalidating/load-external-dtd", false);

        // 📁 Load XSD safely
        File schemaFile = new File(XSD_PATH);
        System.out.println("Looking for XSD at: " + schemaFile.getAbsolutePath());

        if (!schemaFile.exists()) {
            throw new RuntimeException("❌ XSD file not found!");
        }

        SchemaFactory schemaFactory =
                SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

        Schema schema = schemaFactory.newSchema(schemaFile);
        saxParserFactory.setSchema(schema);

        // 🔄 Parse XML
        XMLReader xmlReader = saxParserFactory.newSAXParser().getXMLReader();

        File xmlFile = new File(filePath);
        SAXSource source = new SAXSource(
                xmlReader,
                new InputSource(xmlFile.toURI().toString())
        );

        Unmarshaller unmarshaller = context.createUnmarshaller();
        Siunta siunta = (Siunta) unmarshaller.unmarshal(source);

        System.out.println("XML transformed to POJO successfully.");
        System.out.println(siunta);

        return siunta;
    }
}