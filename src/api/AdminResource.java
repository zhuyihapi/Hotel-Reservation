package api;

import model.Customer;
import model.IRoom;
import model.Reservation;
import service.CustomerService;
import service.ReservationService;

import java.util.Collection;
import java.util.List;

public class AdminResource {

    public Customer getCustomer(String email) {
        return CustomerService.getCustomer(email);
    }

    public void addRoom(List<IRoom> rooms) {
        for (IRoom room : rooms) {
            ReservationService.addRoom(room);
        }
    }

    public Collection<IRoom> getAllRooms() {
        return ReservationService.getAllRoom(); //ArrayList
    }

    public Collection<Customer> getAllCustomers() {
        return CustomerService.getAllCustomers();
    }

    public void displayAllReservations() {
        ReservationService.printAllReservation();
    }

}
