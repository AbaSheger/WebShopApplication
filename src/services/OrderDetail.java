package services;

import java.util.List;

public class OrderDetail {

    String itemType;
    String itemId;
    double price;
    String customerName;
    List<String> customizations;

    public OrderDetail(String itemType, String itemId, double price, String customerName, List<String> customizations) {
        this.itemType = itemType;
        this.itemId = itemId;
        this.price = price;
        this.customerName = customerName;
        this.customizations = customizations;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public List<String> getCustomizations() {
        return customizations;
    }

    public void setCustomizations(List<String> customizations) {
        this.customizations = customizations;
    }
}
