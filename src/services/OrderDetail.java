package services;

public class OrderDetail {

    private String itemType;
    private String color;
    private String size;
    // Add more fields as necessary

    // Constructor
    public OrderDetail(String itemType, String color, String size) {
        this.itemType = itemType;
        this.color = color;
        this.size = size;
    }

    // Getters and Setters
    public String getItemType() { return itemType; }
    public void setItemType(String itemType) { this.itemType = itemType; }

    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }

    public String getSize() { return size; }
    public void setSize(String size) { this.size = size; }

    // Add more getters and setters as necessary
}


