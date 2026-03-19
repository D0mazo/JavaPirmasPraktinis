package lt.viko.eif.dsimanavicius.task1;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import java.util.List;

/**
 * Wrapper class that holds the list of SiuntaItem objects.
 *
 * @author Dominykas
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Siuntos {

    /** List of package items in the shipment. */
    @XmlElement(name = "packageItem")
    private List<SiuntaItem> packageItems;

    /**
     * Default constructor required by JAXB.
     */
    public Siuntos() {
    }

    /**
     * Creates a wrapper with a list of package items.
     *
     * @param packageItems list of package items
     */
    public Siuntos(List<SiuntaItem> packageItems) {
        this.packageItems = packageItems;
    }

    /**
     * Returns the list of package items.
     *
     * @return list of packages
     */
    public List<SiuntaItem> getPackageItems() { return packageItems; }

    /**
     * Sets the list of package items.
     *
     * @param packageItems list of packages
     */
    public void setPackageItems(List<SiuntaItem> packageItems) { this.packageItems = packageItems; }

    /**
     * Returns a string representation of the packages list.
     *
     * @return formatted string
     */
    @Override
    public String toString() {
        return "Siuntos{packageItems=" + packageItems + '}';
    }
}