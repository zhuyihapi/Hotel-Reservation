package service;

import model.Customer;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class CustomerService extends Customer {
    private static Map<String, Customer> mapOfCustomers = new HashMap<>();

    // ?
    public CustomerService(String firstName, String lastName, String email) {
        super(firstName, lastName, email);
    }

    public static void addCustomer(String email, String firstName, String lastName) {
        Customer customer = new Customer(firstName, lastName, email);
        mapOfCustomers.put(email, customer);
    }

    public static Customer getCustomer(String customerEmail) {

        return mapOfCustomers.get(customerEmail);
    }

    public static Collection<Customer> getAllCustomers() {

        return mapOfCustomers.values(); // ?
    }
}
