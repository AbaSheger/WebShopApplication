package services;

import patterns.obsever.Notification;

public class OrderService {
    private static OrderService instance;
    private Notification notification;

    private OrderService() {
        // Initialize the notification within the OrderService constructor
        this.notification = new Notification();
    }

    public static OrderService getInstance() {
        if (instance == null) {
            synchronized (OrderService.class) {
                if (instance == null) {
                    instance = new OrderService();
                }
            }
        }
        return instance;
    }

    public Notification getNotification() {
        return notification;
    }

}
