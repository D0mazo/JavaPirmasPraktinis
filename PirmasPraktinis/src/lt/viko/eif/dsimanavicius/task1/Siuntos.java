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

    @XmlElement(name = "packageItem")
    private List<SiuntaItem> packageItems;

    public Siuntos() {
    }

    public Siuntos(List<SiuntaItem> packageItems) {
        this.packageItems = packageItems;
    }

    public List<SiuntaItem> getPackageItems() { return packageItems; }
    public void setPackageItems(List<SiuntaItem> packageItems) { this.packageItems = packageItems; }

    @Override
    public String toString() {
        return "Siuntos{packageItems=" + packageItems + '}';
    }
}