package services;

public class OrderService {
    private static OrderService instance;
    private NotificationService notificationService; // Add this line

    private OrderDetail orderDetail;

    private OrderService() {
        // Private constructor to prevent external instantiation
    }

    public static OrderService getInstance(NotificationService notificationService) { // Adjust this method
        if (instance == null) {
            synchronized (OrderService.class) {
                if (instance == null) {
                    instance = new OrderService();
                    instance.notificationService = notificationService; // Set NotificationService here
                }
            }
        }
        return instance;
    }

    // Example method to place an order
    public void placeOrder() {

        // Process the order with detailed customizations
        System.out.println("Placing order for: " + orderDetail.getItemType() +
                " with Color: " + orderDetail.getColor() +
                " and Size: " + orderDetail.getSize());



        notificationService.notifyNewOrderPlaced(); // Notify observers
    }
}
