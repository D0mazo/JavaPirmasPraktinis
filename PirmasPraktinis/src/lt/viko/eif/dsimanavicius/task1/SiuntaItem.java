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

    private int id;
    private String description;
    private float weight;

    public SiuntaItem() {
    }

    public SiuntaItem(int id, String description, float weight) {
        this.id          = id;
        this.description = description;
        this.weight      = weight;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public float getWeight() { return weight; }
    public void setWeight(float weight) { this.weight = weight; }

    @Override
    public String toString() {
        return "SiuntaItem{id=" + id +
                ", description='" + description + '\'' +
                ", weight=" + weight + '}';
    }
}