package models;

import patterns.observer.Observer;
import patterns.observer.Subject;

public class CEO implements Observer {

    private String name;

    // Empty constructor
    public CEO() {
    }

    // Constructor with name parameter for convenience
    public CEO(String name) {
        this.name = name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    @Override
    public void update(String eventMessage) {
        displayNotification(eventMessage);
    }

    private void displayNotification(String message) {
        System.out.println("Notification for CEO " + name + ": " + message);
    }

}
