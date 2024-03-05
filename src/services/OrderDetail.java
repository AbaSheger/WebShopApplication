package services;

import java.awt.color.ICC_ColorSpace;
import java.util.List;

public class OrderDetail {

    String itemType;
    String itemId;
    double price;
    String customerName;
    String email;
    String address;
    String size;
    String material;
    String color;
    List<String> customizations;

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

}
