package services;

import models.Customer;

import java.awt.color.ICC_ColorSpace;
import java.util.List;
import models.Customer;
public class OrderDetail {

    private String itemType;
    private String itemId;
    private double price;
    private String customerName;
    private String email;
    private String address;
    private String size;
    private String material;
    private String color;
    private List<String> customizations;

    public OrderDetail(String itemType, String itemId, double price, String customerName, String email, String address, String size, String material, String color, List<String> customizations) {
        this.itemType = itemType;
        this.itemId = itemId;
        this.price = price;
        this.customerName = customerName;
        this.email = email;
        this.address = address;
        this.size = size;
        this.material = material;
        this.color = color;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public List<String> getCustomizations() {
        return customizations;
    }

    public void setCustomizations(List<String> customizations) {
        this.customizations = customizations;
    }
}
