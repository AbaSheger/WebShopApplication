package services;

import models.*;
import patterns.builder.CustomerBuilder;
import patterns.builder.PantsBuilder;
import patterns.builder.SkirtBuilder;
import patterns.builder.TShirtBuilder;
import patterns.command.*;
import patterns.obsever.Notification;

import java.util.*;

public class WebShopApplication {
    private static Scanner scanner = new Scanner(System.in);
    private static OrderService orderService = OrderService.getInstance();

    private static List<OrderDetail> orderDetails = new ArrayList<>();
    private static List<Runnable> orderProcesses = new ArrayList<>();

    private static CEO ceo; // CEO instance declared statically

    static {
        // Instantiate CEO and attach it to the Notification object here, ensuring it's done only once.
        ceo = new CEO();
        orderService.getNotification().addPropertyChangeListener(ceo);
    }

    public static void main(String[] args) {

        displayWelcomeMessage();

        boolean running = true;
        while (running) {
            displayMenuOptions();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline left after nextInt()

            switch (choice) {
                case 1:
                case 2:
                case 3:
                    prepareOrderProcess(choice);
                    break;
                case 4:
                    finalizeOrders();
                    running = false;
                    System.out.println("Finalizing your orders. Thank you for visiting!");
                    break;
                case 5:
                    running = false;
                    System.out.println("Exiting WebShop. Thank you for visiting!");
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
            }
        }

        scanner.close();
    }

    private static void displayWelcomeMessage() {
        System.out.println("Welcome to the Wigell WebShop!");
    }

    private static void displayMenuOptions() {
        System.out.println("\nPlease choose an option:");
        System.out.println("1. Add Pants to Order");
        System.out.println("2. Add TShirt to Order");
        System.out.println("3. Add Skirt to Order");
        System.out.println("4. Finalize Order and Checkout");
        System.out.println("5. Exit without ordering");
        System.out.print("Your choice: ");
    }
    private static void prepareOrderProcess(int choice) {
        String itemType = choice == 1 ? "Pants" : choice == 2 ? "TShirt" : "Skirt";
        orderProcesses.add(() -> handleOrderProcess(itemType));
        System.out.println(itemType + " will be customized next. Continue shopping or finalize your order when ready.");
    }

   private static void finalizeOrders() {
        if (orderProcesses.isEmpty()) {
            System.out.println("No orders to process.");
            return;
        }
       orderProcesses.forEach(Runnable::run); // This should now populate orderDetails
       printConsolidatedReceipt();
       orderProcesses.clear(); // Clear the orders after processing
       orderDetails.clear(); // Clear order details after printing the receipt
    }

   /* private static void finalizeOrders() {
        if (orderProcesses.isEmpty()) {
            System.out.println("No orders to process.");
            return;
        }

        // Notify "order placed" at the start of order finalization
        Notification notification = orderService.getNotification();
        notification.notifyOrderPlaced();

        orderProcesses.forEach(Runnable::run);

        // Notify "order ready" after all orders have been processed
        notification.notifyOrderReady();

        orderProcesses.clear(); // Clear the orders after processing
    } */



    private static void handleOrderProcess(String itemType) {

        CustomizationInvoker invoker = new CustomizationInvoker();
        System.out.println("\nLet's customize your " + itemType + ".");

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

       /* System.out.println("Enter your address: ");
        String address = scanner.nextLine();

        System.out.println("Enter your email: ");
        String email = scanner.nextLine();*/


        Customer customer = new CustomerBuilder()
                //.setEmail(email)
                //.setAddress(address)
                .setName(name)
                .build();


        System.out.print("Enter the Garment id number: ");
        String id = scanner.nextLine();

        System.out.print("Enter size (Medium/Large): ");
        String size = scanner.nextLine();

        System.out.print("Enter color preference (Red/Blue): ");
        String color = scanner.nextLine();

        System.out.print("Enter material preference (Cotton/Polyester): ");
        String material = scanner.nextLine();

        // Handling specific item type orders
        switch (itemType) {
            case "Pants":
                processPantsOrder(id,size, color, material, invoker, customer);
                break;
            case "TShirt":
                processTShirtOrder(id,size, color, material, invoker, customer);
                break;
            case "Skirt":
                processSkirtOrder(id, size, color, material, invoker, customer);
                break;
        }
    }

    private static void processPantsOrder(String id, String size, String color, String material, CustomizationInvoker invoker, Customer customer) {

        Notification notification = orderService.getNotification();

        Pants customPants = new PantsBuilder()
                .setId(id) //set id is not working
                .setSize(size)
                .setColor(color)
                .setMaterial(material)
                .setPrice(599.00)
                .build();



        System.out.print("Enter fit preference (Slim/Regular/Tapered): ");
        String fit = scanner.nextLine();

        System.out.print("Enter length preference (Short/Regular/Long): ");
        String length = scanner.nextLine();


        notification.notifyOrderPlaced();

        PantsTailoringCommand pantsTailoringCommand = new PantsTailoringCommand(customPants, fit, length);
        invoker.addCommand(pantsTailoringCommand);
        invoker.executeCommands();



        notification.notifyOrderReady();

        List<String> customizations = Arrays.asList("Fit: " + fit, "Length: " + length);
        orderDetails.add(new OrderDetail("Pants", customPants.getId(), customPants.getPrice(), customer.getName(), customizations));

    }

    private static void processTShirtOrder(String id, String size, String color, String material, CustomizationInvoker invoker, Customer customer) {
        Notification notification = orderService.getNotification();

        TShirt customTShirt = new TShirtBuilder()
                .setId(id) //set id is not working
                .setSize(size)
                .setColor(color)
                .setMaterial(material)
                .setPrice(399.00)
                .build();



        System.out.print("Enter neck type preference (Round/Scoop/V-neck): ");
        String neckType = scanner.nextLine();

        System.out.print("Enter sleeves preference (Short/Long/Raglan): ");
        String sleeves = scanner.nextLine();


        notification.notifyOrderPlaced();

        TShirtTailoringCommand tShirtTailoringCommand = new TShirtTailoringCommand(customTShirt, neckType, sleeves);
        invoker.addCommand(tShirtTailoringCommand);
        invoker.executeCommands();

        notification.notifyOrderReady();

        List<String> customizations = Arrays.asList("Neck Type: " + neckType, "Sleeves: " + sleeves);
        orderDetails.add(new OrderDetail("TShirt", customTShirt.getId(), customTShirt.getPrice(), customer.getName(), customizations));
    }

    private static void processSkirtOrder(String id, String size, String color, String material, CustomizationInvoker invoker, Customer customer) {

        Notification notification = orderService.getNotification();

        Skirt customSkirt = new SkirtBuilder()
                .setId(id) //set id is not working
                .setSize(size)
                .setColor(color)
                .setMaterial(material)
                .setPrice(499.00)
                .build();


        System.out.print("Enter waistline preference (High/Medium/Low): ");
        String waistline = scanner.nextLine();

        System.out.print("Enter pattern preference (Plain/Printed/Pleated): ");
        String pattern = scanner.nextLine();


        notification.notifyOrderPlaced();

        SkirtTailoringCommand skirtTailoringCommand = new SkirtTailoringCommand(customSkirt, waistline, pattern);
        invoker.addCommand(skirtTailoringCommand);
        invoker.executeCommands();



        notification.notifyOrderReady();

        List<String> customizations = Arrays.asList("Waistline: " + waistline, "Pattern: " + pattern);
        orderDetails.add(new OrderDetail("Skirt", customSkirt.getId(), customSkirt.getPrice(), customer.getName(), customizations));

    }

    private static void printConsolidatedReceipt() {
        String orderId = UUID.randomUUID().toString();
        double subtotal = 0.0;

        System.out.println("\nConsolidated Receipt:");
        System.out.println("Order ID: " + orderId);


        for (OrderDetail detail : orderDetails) {
            System.out.println("Item Type: " + detail.itemType);
            System.out.println("Item ID: " + detail.itemId);
            System.out.println("Price: $" + detail.price);
            subtotal+=detail.price;
            System.out.println("Customer Name: " + detail.customerName);
            for (String customization : detail.customizations) {
                System.out.println("Customization: " + customization);
            }
            System.out.println("---------------------------");
        }

        System.out.println("Subtotal: $" + subtotal); // Print subtotal
        System.out.println("Thank you for shopping with us!");
    }
}
