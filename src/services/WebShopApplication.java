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

    private static CEO ceo;

    static {

        ceo = new CEO();
        orderService.getNotification().addPropertyChangeListener(ceo);
    }

    public static void main(String[] args) {

        displayWelcomeMessage();

        System.out.print("Enter your name (only letters and spaces allowed, e.g., John Doe): ");
        String name = scanner.nextLine();

        System.out.print("Enter your address (must be at least 10 characters long, e.g., Storgatan 1, 123 45 Stockholm): ");
        String address = scanner.nextLine();

        System.out.print("Enter your email (valid format, e.g., user@example.com): ");
        String email = scanner.nextLine();

      Customer customer = new CustomerBuilder()
                .setName(name)
                .setAddress(address)
                .setEmail(email)
                .build();

        boolean running = true;
        while (running) {
            displayMenuOptions();
            try {
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                    case 2:
                    case 3:
                        prepareOrderProcess(choice, customer);
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
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid option.");
                scanner.next();
            }
        }
        scanner.close();


    }

    private static void displayWelcomeMessage() {
        System.out.println("\n" +
                "*************************************************\n" +
                "*                                               *\n" +
                "*      Welcome to the Wigell WebShop!           *\n" +
                "*                                               *\n" +
                "*************************************************\n" +
                "* Find the perfect garment tailored just for you*\n" +
                "*************************************************\n");
        System.out.println("Our exclusive collection awaits your customization. Let's create something unique together!");
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

    private static void prepareOrderProcess(int choice, Customer customer) {
        String itemType = choice == 1 ? "Pants" : choice == 2 ? "TShirt" : "Skirt";
        orderProcesses.add(() -> handleOrderProcess(itemType, customer));
        System.out.println(itemType + " will be customized next. Continue shopping or finalize your order when ready.");
    }


   private static void finalizeOrders() {
        if (orderProcesses.isEmpty()) {
            System.out.println("No orders to process.");
            return;
        }
       orderProcesses.forEach(Runnable::run);
       printConsolidatedReceipt();
       orderProcesses.clear();
       orderDetails.clear();
    }


    private static void handleOrderProcess(String itemType, Customer customer) {
        GarmentCustomizationHandler handler = new GarmentCustomizationHandler();


        System.out.println("\nLet's customize your " + itemType + ".");

        System.out.print("Enter a four-digit Garment ID number (e.g., 1234): ");
        String id = scanner.nextLine();

        System.out.print("Enter size (Medium/Large): ");
        String size = scanner.nextLine();

        System.out.print("Enter color preference (Red/Blue): ");
        String color = scanner.nextLine();

        System.out.print("Enter material preference (Cotton/Polyester): ");
        String material = scanner.nextLine();


        switch (itemType) {
            case "Pants":
                processPantsOrder(id, size, color, material, handler, customer);
                break;
            case "TShirt":
                processTShirtOrder(id, size, color, material, handler, customer);
                break;
            case "Skirt":
                processSkirtOrder(id, size, color, material, handler, customer);
                break;
        }
    }


    private static void processPantsOrder(String id, String size, String color, String material, GarmentCustomizationHandler handler, Customer customer) {

        Notification notification = orderService.getNotification();

        Pants customPants = new PantsBuilder()
                .setId(id)
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
        handler.addCommand(pantsTailoringCommand);
        handler.executeCommands();



        notification.notifyOrderReady();


        List<String> customizations = Arrays.asList("Fit: " + fit, "Length: " + length);
        orderDetails.add(new OrderDetail("Pants", customPants.getId(), customPants.getPrice(), customer.getName(), customer.getEmail(), customer.getAddress(), size, material, color, customizations));


    }

    private static void processTShirtOrder(String id, String size, String color, String material, GarmentCustomizationHandler handler, Customer customer) {
        Notification notification = orderService.getNotification();

        TShirt customTShirt = new TShirtBuilder()
                .setId(id)
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
        handler.addCommand(tShirtTailoringCommand);
        handler.executeCommands();

        notification.notifyOrderReady();

        List<String> customizations = Arrays.asList("Neck Type: " + neckType, "Sleeves: " + sleeves);
        orderDetails.add(new OrderDetail("TShirt", customTShirt.getId(), customTShirt.getPrice(),customer.getName(),customer.getEmail(),customer.getAddress(), size, material, color, customizations));


    }

    private static void processSkirtOrder(String id, String size, String color, String material, GarmentCustomizationHandler handler, Customer customer) {

        Notification notification = orderService.getNotification();

        Skirt customSkirt = new SkirtBuilder()
                .setId(id)
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
        handler.addCommand(skirtTailoringCommand);
        handler.executeCommands();



        notification.notifyOrderReady();

       List<String> customizations = Arrays.asList("Waistline: " + waistline, "Pattern: " + pattern);
        orderDetails.add(new OrderDetail("Skirt", customSkirt.getId(), customSkirt.getPrice(),customer.getName(),customer.getEmail(), customer.getAddress(), size, material, color, customizations));



    }

    private static void printConsolidatedReceipt() {
        String orderId = UUID.randomUUID().toString();
        double subtotal = 0.0;

        System.out.println("\n==================================================");
        System.out.println("                   Receipt");
        System.out.println("==================================================");
        System.out.println("Order ID: " + orderId);

        if (!orderDetails.isEmpty()) {
            System.out.println("Customer Name: " + orderDetails.get(0).getCustomerName());
            System.out.println("Email Address: " + orderDetails.get(0).getEmail());
            System.out.println("Shipping Address: " + orderDetails.get(0).getAddress());
            System.out.println("==================================================");
        }

        for (OrderDetail detail : orderDetails) {
            System.out.println("--------------------------------------------------");
            System.out.println("Item Type: " + detail.getItemType());
            System.out.println("Item ID: " + detail.getItemId());
            System.out.println("Size: " + detail.getSize());
            System.out.println("Material: " + detail.getMaterial());
            System.out.println("Color: " + detail.getColor());
            System.out.println("Customizations:");
            for (String customization : detail.getCustomizations()) {
                System.out.println("* " + customization);
            }
            System.out.println("Price: $" + String.format("%.2f", detail.getPrice()));
            subtotal += detail.getPrice();
            System.out.println("--------------------------------------------------");
        }

        System.out.println("Subtotal: $" + String.format("%.2f", subtotal));
        System.out.println("==================================================");
        System.out.println("Thank you for shopping with us!");
        System.out.println("==================================================\n");
    }



}
