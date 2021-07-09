package api;

import model.Customer;
import model.IRoom;
import model.Reservation;
import model.Room;
import service.CustomerService;
import service.ReservationService;

import java.util.Collection;
import java.util.List;

public class AdminResource {

    public static Customer getCustomer(String email) {
        return CustomerService.getCustomer(email);
    }

    //para: List<IRoom> rooms
    public static void addRoom(Room room) {
            ReservationService.addRoom(room);

    }

    public static Collection<IRoom> getAllRooms() {
        return ReservationService.getAllRoom(); //ArrayList
    }

    public static Collection<Customer> getAllCustomers() {
        return CustomerService.getAllCustomers();
    }

    public static void displayAllReservations() {
        ReservationService.printAllReservation();
    }

}
