package lt.viko.eif.dsimanavicius.task1;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;

/**
 * Represents a single package item inside a shipment.
 *
 * @author Dominykas
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class SiuntaItem {

    /** Unique package identifier. */
    private int id;

    /** Description of the package contents. */
    private String description;

    /** Weight of the package in kg. */
    private float weight;

    /**
     * Default constructor required by JAXB.
     */
    public SiuntaItem() {
    }

    /**
     * Creates a package item with all fields.
     *
     * @param id          unique package ID
     * @param description package contents description
     * @param weight      package weight in kg
     */
    public SiuntaItem(int id, String description, float weight) {
        this.id          = id;
        this.description = description;
        this.weight      = weight;
    }

    /**
     * Returns the package ID.
     *
     * @return package ID
     */
    public int getId() { return id; }

    /**
     * Sets the package ID.
     *
     * @param id package ID
     */
    public void setId(int id) { this.id = id; }

    /**
     * Returns the package description.
     *
     * @return description
     */
    public String getDescription() { return description; }

    /**
     * Sets the package description.
     *
     * @param description package description
     */
    public void setDescription(String description) { this.description = description; }

    /**
     * Returns the package weight.
     *
     * @return weight in kg
     */
    public float getWeight() { return weight; }

    /**
     * Sets the package weight.
     *
     * @param weight weight in kg
     */
    public void setWeight(float weight) { this.weight = weight; }

    /**
     * Returns a string representation of the package item.
     *
     * @return formatted package string
     */
    @Override
    public String toString() {
        return "SiuntaItem{id=" + id +
                ", description='" + description + '\'' +
                ", weight=" + weight + '}';
    }
}