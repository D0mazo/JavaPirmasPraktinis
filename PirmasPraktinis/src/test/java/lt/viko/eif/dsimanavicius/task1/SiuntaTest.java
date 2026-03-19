package lt.viko.eif.dsimanavicius.task1;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for Siunta class.
 *
 * @author Dominykas
 */
class SiuntaTest {

    /**
     * Tests that Siunta is created with correct field values.
     */
    @Test
    void testSiuntaCreation() {
        Siunta siunta = new Siunta(1001, "BLS", "Kaunas", "Vilnius",
                50.0f, false, "N", new ArrayList<>());

        assertEquals(1001,      siunta.getShipmentId());
        assertEquals("BLS",     siunta.getSender());
        assertEquals("Kaunas",  siunta.getOrigin());
        assertEquals("Vilnius", siunta.getDestination());
        assertEquals(50.0f,     siunta.getTotalWeight());
        assertFalse(            siunta.isDelivered());
        assertEquals("N",       siunta.getPriority());
    }

    /**
     * Tests that setters update field values correctly.
     */
    @Test
    void testSiuntaSetters() {
        Siunta siunta = new Siunta();
        siunta.setShipmentId(999);
        siunta.setSender("DHL");
        siunta.setOrigin("Vilnius");
        siunta.setDestination("Kaunas");
        siunta.setTotalWeight(100.0f);
        siunta.setDelivered(true);
        siunta.setPriority("H");

        assertEquals(999,       siunta.getShipmentId());
        assertEquals("DHL",     siunta.getSender());
        assertEquals("Vilnius", siunta.getOrigin());
        assertEquals("Kaunas",  siunta.getDestination());
        assertEquals(100.0f,    siunta.getTotalWeight());
        assertTrue(             siunta.isDelivered());
        assertEquals("H",       siunta.getPriority());
    }

    /**
     * Tests that package items list is stored correctly.
     */
    @Test
    void testSiuntaPackageItems() {
        List<SiuntaItem> items = new ArrayList<>();
        items.add(new SiuntaItem(1, "Elektronika", 10.5f));

        Siunta siunta = new Siunta();
        siunta.setPackageItems(items);

        assertEquals(1, siunta.getPackageItems().size());
        assertEquals("Elektronika",
                siunta.getPackageItems().get(0).getDescription());
    }
}