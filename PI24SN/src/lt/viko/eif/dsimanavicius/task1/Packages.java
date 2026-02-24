package lt.viko.eif.dsimanavicius.task1;

import java.util.List;

public class Packages {

    private List<PackageItem> packageItem;

    public Packages() {}

    public Packages(List<PackageItem> packageItem) {
        this.packageItem = packageItem;
    }

    public List<PackageItem> getPackageItem() {
        return packageItem;
    }

    public void setPackageItem(List<PackageItem> packageItem) {
        this.packageItem = packageItem;
    }

    @Override
    public String toString() {
        return packageItem.toString();
    }
}