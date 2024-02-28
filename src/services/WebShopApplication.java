package services;
import models.CEO;
import models.*;
import java.util.UUID;
import patterns.builder.PantsBuilder;
import patterns.builder.SkirtBuilder;
import patterns.builder.TShirtBuilder;
import patterns.command.*;
import java.util.Scanner;

public class WebShopApplication {
    private static Scanner scanner = new Scanner(System.in);
    private static OrderService orderService;

    private static Clothing clothing;

    public static void main(String[] args) {
        initializeServices();
        displayWelcomeMessage();

        boolean running = true;
        while (running) {
            displayMenuOptions();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (choice) {
                case 1:
                    handleOrderProcess("Pants");
                    break;
                case 2:
                    handleOrderProcess("TShirt");
                    break;
                case 3:
                    handleOrderProcess("Skirt");
                    break;
                case 4:
                    running = false;
                    System.out.println("Exiting WebShop. Thank you for visiting!");
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
            }
        }

        scanner.close();
    }

    private static void initializeServices() {
        // Initialize NotificationService
        NotificationService notificationService = new NotificationService();

        // Initialize CEO and register as an observer to NotificationService
        CEO ceo = new CEO("Wigells VD"); // Optionally set the name

        notificationService.registerObserver(ceo);

        // Initialize OrderService with NotificationService
        orderService = OrderService.getInstance(notificationService);
    }

    private static void displayWelcomeMessage() {
        System.out.println("Welcome to Wigell WebShop!");
    }

    private static void displayMenuOptions() {
        System.out.println("\n1. Order Pants\n2. Order TShirt\n3. Order Skirt\n4. Exit");
        System.out.print("Choose an option: ");
    }

    private static void handleOrderProcess(String itemType) {
        NotificationService notificationService = new NotificationService();



        System.out.println("You have chosen to order " + itemType + ".");

        // Collect common customization options
        System.out.println("Enter your id number: ");
        String id = scanner.nextLine();

        System.out.println("Enter your name: ");
        String name = scanner.nextLine();

        System.out.println("Enter color preference (Red/Blue): ");
        String color = scanner.nextLine();

        System.out.print("Enter size(Medium/Large) : ");
        String size = scanner.nextLine();

        switch (itemType) {
            case "Pants":
                System.out.println("Enter fit preference (Slim/Regular/Tapered): ");
                String fit = scanner.nextLine();

                System.out.println("Enter length preference (Short/Regular/Long): ");
                String length = scanner.nextLine();

                Pants customPants = new PantsBuilder()
                        .setColor(color)
                        .setSize(size)
                        .setFit(fit)
                        .setLength(length)
                        .build();

               clothing = customPants;


                // Generate a unique order ID
                String orderId = UUID.randomUUID().toString();

                OrderDetail orderDetail = new OrderDetail(itemType, color,orderId, size, "PENDING");
                orderService.placeOrder(orderDetail);

                System.out.println("Custom Pants ordered: " + customPants);
                break;
            case "TShirt":
                System.out.println("Enter sleeves preference (Short/Long/Raglan): ");
                String sleeves = scanner.nextLine();

                System.out.println("Enter neck type preference (Round/Scoop/V-neck): ");
                String neckType = scanner.nextLine();

                TShirt customTShirt = new TShirtBuilder()
                        .setColor(color)
                        .setSize(size)
                        .setSleeves(sleeves)
                        .setNeckType(neckType)
                        .build();
                //System.out.println("Custom TShirt ordered: " + customTShirt);

                break;
            case "Skirt":

                System.out.println("Enter waistline preference (High/Medium/Low");
                String waistline = scanner.nextLine();

                System.out.println("Enter pattern preference (Plain/Printed/Pleated): ");
                String pattern = scanner.nextLine();

                Skirt customSkirt = new SkirtBuilder()
                        .setColor(color)
                        .setSize(size)
                        .setWaistLine(waistline)
                        .setPattern(pattern)
                        .build();
                System.out.println("Custom Skirt ordered: " + customSkirt);
                break;
        }

        // Place the order (Assuming a generalized method for now)
        // orderService.placeOrder(); // You might need to adjust this part based on your actual implementation
       // System.out.println(itemType + " ordered with color " + color + " and size " + size + ". Notification sent to CEO.");


        notificationService.notifyOrderReady();
    }
}
