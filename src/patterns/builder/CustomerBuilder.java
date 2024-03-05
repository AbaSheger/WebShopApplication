package patterns.builder;

import models.Customer;

public class CustomerBuilder {

    private Customer customer = new Customer();



    public CustomerBuilder setName(String name) {

        if (name == null || name.trim().isEmpty()) {
            throw new RuntimeException ("Name cannot be null or empty");
        }
        if (!name.matches("[a-zA-Z\\s]+")) {
            throw new RuntimeException("Name must only contain letters and spaces");
        }

        customer.setName(name);
        return this;
    }


    public CustomerBuilder setAddress(String address) {


        if (address == null || address.trim().isEmpty()) {
            throw new RuntimeException("Address cannot be null or empty");
        }

        if (address.length() < 10) {
            throw new RuntimeException("Address seems too short. Please provide a full address.");
        }
        customer.setAddress(address);
        return this;
    }


    public CustomerBuilder setEmail(String email) {

        if (email == null || email.trim().isEmpty()) {
            throw new RuntimeException("Email cannot be null or empty");
        }

        if (!email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")) {
            throw new RuntimeException("Email format is invalid. Please provide a valid email address.");
        }

        customer.setEmail(email);
        return this;
    }

    public Customer build() {

        boolean hasInvalidProperty = customer.getName() == null || customer.getName().trim().isEmpty() ||
                customer.getAddress() == null || customer.getAddress().trim().isEmpty() ||
                customer.getEmail() == null || customer.getEmail().trim().isEmpty();

        if (hasInvalidProperty) {
            throw new RuntimeException("Please make sure all required information (name, address, email) is filled out correctly.");
        }

        return customer;
    }


}
