package lt.viko.eif.dsimanavicius.task1;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;
import lt.viko.eif.dsimanavicius.task1.SiuntaItem;

import java.util.List;

/**
 * Represents a shipment with a list of package items.
 *
 * @author Dominykas
 */
@XmlRootElement(name = "siunta")
@XmlAccessorType(XmlAccessType.FIELD)
public class Siunta {

    /** Unique shipment identifier. */
    private int shipmentId;

    /** Name of the sender. */
    private String sender;

    /** Origin city of the shipment. */
    private String origin;

    /** Destination city of the shipment. */
    private String destination;

    /** Total weight of all packages in kg. */
    private float totalWeight;

    /** Delivery status, true if delivered. */
    private boolean delivered;

    /** Priority level of the shipment. */
    private char priority;

    /** List of packages belonging to this shipment. */
    @XmlElementWrapper(name = "packages")
    @XmlElement(name = "packageItem")
    private List<lt.viko.eif.dsimanavicius.task1.SiuntaItem> packageItems;

    /**
     * Default constructor required by JAXB.
     */
    public Siunta() {
    }

    /**
     * Creates a shipment with all fields.
     *
     * @param shipmentId   unique shipment ID
     * @param sender       sender name
     * @param origin       origin city
     * @param destination  destination city
     * @param totalWeight  total weight in kg
     * @param delivered    delivery status
     * @param priority     priority level
     * @param packageItems list of packages
     */
    public Siunta(int shipmentId, String sender, String origin,
                  String destination, float totalWeight,
                  boolean delivered, char priority,
                  List<lt.viko.eif.dsimanavicius.task1.SiuntaItem> packageItems) {
        this.shipmentId   = shipmentId;
        this.sender       = sender;
        this.origin       = origin;
        this.destination  = destination;
        this.totalWeight  = totalWeight;
        this.delivered    = delivered;
        this.priority     = priority;
        this.packageItems = packageItems;
    }

    /**
     * Returns the shipment ID.
     *
     * @return shipment ID
     */
    public int getShipmentId() {
        return shipmentId;
    }

    /**
     * Sets the shipment ID.
     *
     * @param shipmentId shipment ID
     */
    public void setShipmentId(int shipmentId) {
        this.shipmentId = shipmentId;
    }

    /**
     * Returns the sender name.
     *
     * @return sender
     */
    public String getSender() {
        return sender;
    }

    /**
     * Sets the sender name.
     *
     * @param sender sender name
     */
    public void setSender(String sender) {
        this.sender = sender;
    }

    /**
     * Returns the origin city.
     *
     * @return origin
     */
    public String getOrigin() {
        return origin;
    }

    /**
     * Sets the origin city.
     *
     * @param origin origin city
     */
    public void setOrigin(String origin) {
        this.origin = origin;
    }

    /**
     * Returns the destination city.
     *
     * @return destination
     */
    public String getDestination() {
        return destination;
    }

    /**
     * Sets the destination city.
     *
     * @param destination destination city
     */
    public void setDestination(String destination) {
        this.destination = destination;
    }

    /**
     * Returns the total weight.
     *
     * @return total weight in kg
     */
    public float getTotalWeight() {
        return totalWeight;
    }

    /**
     * Sets the total weight.
     *
     * @param totalWeight total weight in kg
     */
    public void setTotalWeight(float totalWeight) {
        this.totalWeight = totalWeight;
    }

    /**
     * Returns the delivery status.
     *
     * @return true if delivered
     */
    public boolean isDelivered() {
        return delivered;
    }

    /**
     * Sets the delivery status.
     *
     * @param delivered true if delivered
     */
    public void setDelivered(boolean delivered) {
        this.delivered = delivered;
    }

    /**
     * Returns the priority level.
     *
     * @return priority character
     */
    public char getPriority() {
        return priority;
    }

    /**
     * Sets the priority level.
     *
     * @param priority priority character
     */
    public void setPriority(char priority) {
        this.priority = priority;
    }

    /**
     * Returns the list of package items.
     *
     * @return list of packages
     */
    public List<lt.viko.eif.dsimanavicius.task1.SiuntaItem> getPackageItems() {
        return packageItems;
    }

    /**
     * Sets the list of package items.
     *
     * @param packageItems list of packages
     */
    public void setPackageItems(List<SiuntaItem> packageItems) {
        this.packageItems = packageItems;
    }

    /**
     * Returns a string representation of the shipment.
     *
     * @return formatted shipment string
     */
    @Override
    public String toString() {
        return "Siunta{" +
                "shipmentId=" + shipmentId +
                ", sender='" + sender + '\'' +
                ", origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                ", totalWeight=" + totalWeight +
                ", delivered=" + delivered +
                ", priority=" + priority +
                ", packageItems=" + packageItems +
                '}';
    }
}