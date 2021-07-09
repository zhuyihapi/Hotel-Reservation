package service;

import model.Customer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class CustomerService extends Customer {
    private static Map<String, Customer> mapOfCustomers = new HashMap<>(); //<customerEmail, Customer>

    // ?
    public CustomerService(String firstName, String lastName, String email) {
        super(firstName, lastName, email);
    }

    public static void addCustomer(String email, String firstName, String lastName) {
        Customer customer = new Customer(firstName, lastName, email);
        mapOfCustomers.put(email, customer);
    }

    public static Customer getCustomer(String customerEmail) {
        String emailRegex = "^(.+)@(.+).(.+)$";
        Pattern pattern = Pattern.compile(emailRegex);
        if (!pattern.matcher(customerEmail).matches()) {
            throw new IllegalArgumentException("Error, Invalid email format");
        }else {
            return mapOfCustomers.get(customerEmail);
        }

    }

/*    public static Collection<Customer> getAllCustomer() {
        ArrayList<Customer> customerArrayList = new ArrayList<>(10);
        for (String customerEmail : mapOfCustomers.keySet()) {
            customerArrayList.add(mapOfCustomers.get(customerEmail));
        }
        return customerArrayList;
    }*/

    public static Collection<Customer> getAllCustomers() {

        return mapOfCustomers.values(); //hashmap
    }
}
