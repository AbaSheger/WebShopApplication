package services;



public class OrderDetail {

    private String itemType;
    private String color;
    private String size;
    private String  OrderId ;
    private String  Status;



    // Constructor

    public OrderDetail(String itemType, String color, String size, String OrderId, String Status) {
        this.itemType = itemType;
        this.color = color;
        this.size = size;
        this.OrderId = OrderId;
        this.Status = Status;
    }

    // Getters and Setters
    public String getItemType() { return itemType; }
    public void setItemType(String itemType) { this.itemType = itemType; }

    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }

    public String getSize() { return size; }
    public void setSize(String size) { this.size = size; }

    public String getOrderId() { return OrderId; }


    public void setOrderId(String OrderId) { this.OrderId = OrderId; }

    public String getStatus() { return Status; }

    public void setStatus(String Status) { this.Status = Status; }




}


