package lt.viko.eif.dsimanavicius.task1;

import org.junit.jupiter.api.Test;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for JAXBTransformer class.
 *
 * @author Dominykas
 */
class JAXBTransformerTest {

    /** Path to test XML file. */
    private static final String XML_PATH =
            "src/lt/viko/eif/dsimanavicius/task1/siunta.xml";

    /** Path to test output file. */
    private static final String OUTPUT_PATH =
            "src/lt/viko/eif/dsimanavicius/task1/test_output.xml";

    /**
     * Tests that XML file is correctly transformed to POJO.
     */
    @Test
    void testTransformToPOJO() throws Exception {
        JAXBTransformer transformer = new JAXBTransformer();
        Siunta siunta = transformer.transformToPOJO(XML_PATH);

        assertNotNull(siunta);
        assertEquals(1001,           siunta.getShipmentId());
        assertEquals("BLS Logistics", siunta.getSender());
        assertNotNull(               siunta.getPackageItems());
        assertFalse(                 siunta.getPackageItems().isEmpty());
    }

    /**
     * Tests that POJO is correctly transformed to XML file.
     */
    @Test
    void testTransformToXML() throws Exception {
        List<SiuntaItem> items = new ArrayList<>();
        items.add(new SiuntaItem(1, "Elektronika", 10.5f));

        Siunta siunta = new Siunta(1001, "BLS", "Kaunas",
                "Vilnius", 10.5f, false, "N", items);

        JAXBTransformer transformer = new JAXBTransformer();
        transformer.transformToXML(siunta, OUTPUT_PATH);

        assertTrue(new File(OUTPUT_PATH).exists());
    }

    /**
     * Tests full round trip POJO to XML and back to POJO.
     */
    @Test
    void testRoundTrip() throws Exception {
        List<SiuntaItem> items = new ArrayList<>();
        items.add(new SiuntaItem(1, "Elektronika", 10.5f));

        Siunta original = new Siunta(1001, "BLS", "Kaunas",
                "Vilnius", 10.5f, false, "N", items);

        JAXBTransformer transformer = new JAXBTransformer();
        transformer.transformToXML(original, OUTPUT_PATH);
        Siunta restored = transformer.transformToPOJO(OUTPUT_PATH);

        assertEquals(original.getShipmentId(), restored.getShipmentId());
        assertEquals(original.getSender(),     restored.getSender());
        assertEquals(original.getOrigin(),     restored.getOrigin());
    }
}