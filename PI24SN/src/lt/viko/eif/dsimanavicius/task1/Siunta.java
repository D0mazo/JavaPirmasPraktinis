package lt.viko.eif.dsimanavicius.task1;

public class Siunta {

    private int shipmentId;
    private String sender;
    private String origin;
    private String destination;
    private float totalWeight;
    private boolean delivered;
    private char priority;
    private Packages packages;   // Wrapper object

    public Siunta() {}

    public Siunta(int shipmentId, String sender, String origin,
                  String destination, float totalWeight,
                  boolean delivered, char priority,
                  Packages packages) {
        this.shipmentId = shipmentId;
        this.sender = sender;
        this.origin = origin;
        this.destination = destination;
        this.totalWeight = totalWeight;
        this.delivered = delivered;
        this.priority = priority;
        this.packages = packages;
    }

    // Getters and Setters

    public int getShipmentId() { return shipmentId; }
    public void setShipmentId(int shipmentId) { this.shipmentId = shipmentId; }

    public String getSender() { return sender; }
    public void setSender(String sender) { this.sender = sender; }

    public String getOrigin() { return origin; }
    public void setOrigin(String origin) { this.origin = origin; }

    public String getDestination() { return destination; }
    public void setDestination(String destination) { this.destination = destination; }

    public float getTotalWeight() { return totalWeight; }
    public void setTotalWeight(float totalWeight) { this.totalWeight = totalWeight; }

    public boolean isDelivered() { return delivered; }
    public void setDelivered(boolean delivered) { this.delivered = delivered; }

    public char getPriority() { return priority; }
    public void setPriority(char priority) { this.priority = priority; }

    public Packages getPackages() { return packages; }
    public void setPackages(Packages packages) { this.packages = packages; }

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
                ", packages=" + packages +
                '}';
    }
}