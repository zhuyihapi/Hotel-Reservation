package api;

import model.Customer;
import model.IRoom;
import model.Reservation;
import model.Room;
import service.CustomerService;
import service.ReservationService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.regex.Pattern;

public class HotelResource {
    public static Customer getCustomer(String email) {
        return CustomerService.getCustomer(email);
    }

    public static void createCustomer(String email, String firstName, String lastName) {
        CustomerService.addCustomer(email, firstName, lastName);
    }

    public static IRoom getRoom(String roomNumber) {
        return ReservationService.getRoom(roomNumber);
    }

    public static Reservation bookARoom(String customerEmail, IRoom room, Date checkInDate, Date checkOutDate) {
        return ReservationService.reserveARoom(CustomerService.getCustomer(customerEmail),
                room, checkInDate, checkOutDate);
    }

    public static Collection<Reservation> getCustomerReservations(String customerEmail) {
        String emailRegex = "^(.+)@(.+).(.+)$";
        Pattern pattern = Pattern.compile(emailRegex);
        if (!pattern.matcher(customerEmail).matches()) {
            throw new IllegalArgumentException("Error, Invalid email format");
        }else{
            return ReservationService.getCustomerReservation(CustomerService.getCustomer(customerEmail));
        }
    }

    public static void findARoom(Date checkInDate, Date checkOutDate) {
        for (IRoom freeRoom : ReservationService.findRooms(checkInDate, checkOutDate)) {
            System.out.println("room number: "+freeRoom.getRoomNumber()+
                    ", room price: "+freeRoom.getRoomPrice()+
                    ", room type: "+freeRoom.getRoomType());
        }

    }
}
