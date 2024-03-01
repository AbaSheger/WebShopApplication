package services;

import patterns.obsever.Notification;

public class OrderService {
    private static OrderService instance;
    private Notification notification;

    // Assuming a simple way to track orders
    //private Map<String, OrderDetail> orders = new HashMap<>();

    private OrderService(Notification notification) {
        this.notification = notification;
    }

    public static OrderService getInstance(Notification notification) {
        if (instance == null) {
            synchronized (OrderService.class) {
                if (instance == null) {
                    instance = new OrderService(notification);
                }
            }
        }
        return instance;
    }

}
