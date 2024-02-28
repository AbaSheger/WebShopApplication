package services;

import java.util.HashMap;
import java.util.Map;

public class OrderService {
    private static OrderService instance;
    private NotificationService notificationService;

    // Assuming a simple way to track orders
    private Map<String, OrderDetail> orders = new HashMap<>();

    private OrderService(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public static OrderService getInstance(NotificationService notificationService) {
        if (instance == null) {
            synchronized (OrderService.class) {
                if (instance == null) {
                    instance = new OrderService(notificationService);
                }
            }
        }
        return instance;
    }

    public void placeOrder(OrderDetail orderDetail) {
        // Simplified order placement logic
        orders.put(orderDetail.getOrderId(), orderDetail);
        notificationService.notifyNewOrderPlaced(); // Notify observers when a new order is placed
        System.out.println("Order placed for: " + orderDetail.getItemType());
    }

    public void completeOrder(String orderId) {
        OrderDetail order = orders.get(orderId);
        if (order != null) {
            order.setStatus("COMPLETED");
            notificationService.notifyOrderReady(); // Notify observers when the order is ready
            System.out.println("Order " + orderId + " is completed and ready.");
        } else {
            System.out.println("Order not found.");
        }
    }

}
