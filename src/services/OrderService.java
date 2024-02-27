package services;

public class OrderService {
    private static OrderService instance;

    private OrderService() {
        // Private constructor to prevent external instantiation
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

}
