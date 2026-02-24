package lt.viko.eif.dsimanavicius.task1;

public class PackageItem {

    private int id;
    private String description;
    private float weight;

    public PackageItem() {}

    public PackageItem(int id, String description, float weight) {
        this.id = id;
        this.description = description;
        this.weight = weight;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public float getWeight() { return weight; }
    public void setWeight(float weight) { this.weight = weight; }

    @Override
    public String toString() {
        return "PackageItem{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", weight=" + weight +
                '}';
    }
}