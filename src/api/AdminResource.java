package api;

import model.Customer;
import model.IRoom;
import service.CustomerService;

import java.util.Collection;
import java.util.List;

public class AdminResource {

    public Customer getCustomer(String email){
        return CustomerService.getCustomer(email);
    }

    public void addRoom(List<IRoom> room){

    }

    public Collection<IRoom> getAllRooms(){
        return null;
    }

    public Collection<Customer> getAllCustomers(){
        return null;
    }

    public void displayAllReservations(){

    }

}
