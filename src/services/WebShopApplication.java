package services;

import models.*;
import patterns.builder.CustomerBuilder;
import patterns.builder.PantsBuilder;
import patterns.builder.SkirtBuilder;
import patterns.builder.TShirtBuilder;
import patterns.command.*;
import patterns.obsever.Notification;
import patterns.command;
import java.util.Scanner;

public class WebShopApplication {
    private static Scanner scanner = new Scanner(System.in);
    private static OrderService orderService;



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
        Notification notification = new Notification();

        // Initialize CEO and register as an observer to NotificationService
        ///CEO ceo = new CEO("Wigells VD"); // Optionally set the name

       // notificationService.registerObserver(ceo);

        // Initialize OrderService with NotificationService
        orderService = OrderService.getInstance(notification);
    }

    private static void displayWelcomeMessage() {
        System.out.println("Welcome to Wigell WebShop!");
    }

    private static void displayMenuOptions() {
        System.out.println("\n1. Order Pants\n2. Order TShirt\n3. Order Skirt\n4. Exit");
        System.out.print("Choose an option: ");
    }

    private static void handleOrderProcess(String itemType) {
        Notification notification = new Notification();
        CustomizationInvoker invoker = new CustomizationInvoker();


        System.out.println("You have chosen to order " + itemType + ".");




        System.out.println("Enter your name: ");
        String name = scanner.nextLine();

        Customer customer = new CustomerBuilder()  //build customer
                .setName(name)
                .build();

        //collect common attributes to build the garment

        System.out.println("Enter the Garment id number: ");
        String id = scanner.nextLine();

        System.out.print("Enter size(Medium/Large) : ");
        String size = scanner.nextLine();

        System.out.println("Enter color preference (Red/Blue): ");
        String color = scanner.nextLine();

        //material
        System.out.println("Enter material preference (Cotton/Polyester): ");
        String material = scanner.nextLine();


        switch (itemType) {
            case "Pants":

                Pants customPants = new PantsBuilder()
                        .setSize(size)
                        .setColor(color)
                        .setMaterial(material)
                        .build();

                //inform the ceo that new order is placed using notifyNewOrderPlaced method of the notification service

                notification.notifyNewOrderPlaced();

                //take class exclusive atritbutes for pant Customization

                System.out.println("Enter fit preference (Slim/Regular/Tapered): ");
                String fit = scanner.nextLine();

                System.out.println("Enter length preference (Short/Regular/Long): ");
                String length = scanner.nextLine();

                // now use the command pattern  to customize using  fit and length inputs from the user
                PantsTailoringCommand pantsTailoringCommand = new PantsTailoringCommand(customPants, fit, length);
                invoker.addCommand(pantsTailoringCommand);
                invoker.executeCommand();


                 System.out.println("The customized pant is: " + "here the result from the command pattern should be printed out");

                // when the customization is done and order is ready using notifyOrderReady  method of the notification service

                // then print out a receipt of the order with the details of the order and the customer details






              //Clothing clothing = customPants;

              //Creating and Executing the command


                // Generate a unique order ID
                //String orderId = UUID.randomUUID().toString();

                break;
            case "TShirt":
                System.out.println("Enter sleeves preference (Short/Long/Raglan): ");
                String sleeves = scanner.nextLine();

                System.out.println("Enter neck type preference (Round/Scoop/V-neck): ");
                String neckType = scanner.nextLine();

                TShirt customTShirt = new TShirtBuilder()
                        .setSize(size)
                        .setColor(color)
                        .setMaterial(material)
                        .build();

                notification.notifyOrderPlaced();

                //inform the ceo that new order is placed using notifyNewOrderPlaced method of the notification service

                // use the command pattern to decorate or adjust the order as per the order and show that with a print out

                // when the customization is done and order is ready using notifyOrderReady  method of the notification service

                // then print out a receipt of the order with the details of the order and the customer details


                //System.out.println("Custom TShirt ordered: " + customTShirt);

                break;
            case "Skirt":

                System.out.println("Enter waistline preference (High/Medium/Low");
                String waistline = scanner.nextLine();

                System.out.println("Enter pattern preference (Plain/Printed/Pleated): ");
                String pattern = scanner.nextLine();

                Skirt customSkirt = new SkirtBuilder()
                        .setSize(size)
                        .setColor(color)
                        .setMaterial(material)
                        .build();
                System.out.println("Custom Skirt ordered: " + customSkirt);
                break;

            //inform the ceo that new order is placed using notifyNewOrderPlaced method of the notification service

            // use the command pattern to decorate or adjust the order as Per order and show that with a print out

            // when the customization is done and order is ready using notifyOrderReady  method of the notification service

            // then print out a receipt of the order with the details of the order and the customer details

        }

        notification.notifyOrderReady();
    }
}
