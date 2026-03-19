package lt.viko.eif.dsimanavicius.task1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for SiuntaItem class.
 *
 * @author Dominykas
 */
class SiuntaItemTest {

    /**
     * Tests that SiuntaItem is created with correct field values.
     */
    @Test
    void testSiuntaItemCreation() {
        SiuntaItem item = new SiuntaItem(1, "Elektronika", 10.5f);

        assertEquals(1,             item.getId());
        assertEquals("Elektronika", item.getDescription());
        assertEquals(10.5f,         item.getWeight());
    }

    /**
     * Tests that setters update field values correctly.
     */
    @Test
    void testSiuntaItemSetters() {
        SiuntaItem item = new SiuntaItem();
        item.setId(5);
        item.setDescription("Knygos");
        item.setWeight(8.2f);

        assertEquals(5,        item.getId());
        assertEquals("Knygos", item.getDescription());
        assertEquals(8.2f,     item.getWeight());
    }

    /**
     * Tests that toString contains correct values.
     */
    @Test
    void testSiuntaItemToString() {
        SiuntaItem item = new SiuntaItem(1, "Elektronika", 10.5f);
        String result = item.toString();

        assertTrue(result.contains("1"));
        assertTrue(result.contains("Elektronika"));
        assertTrue(result.contains("10.5"));
    }
}