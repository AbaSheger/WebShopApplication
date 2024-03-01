package patterns.builder;

import models.Customer;

public class CustomerBuilder {

    private Customer customer = new Customer();



    public CustomerBuilder setName(String name) {
        customer.setName(name);
        return this;
    }


    public CustomerBuilder setAddress(String address) {
        customer.setAddress(address);
        return this;
    }


    public CustomerBuilder setEmail(String email) {
        customer.setEmail(email);
        return this;
    }

    public Customer build() {
        return customer;
    }


}
