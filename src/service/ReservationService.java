package service;

import model.Customer;
import model.IRoom;
import model.Reservation;

import javax.xml.crypto.Data;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ReservationService {

    //private static int RECOMMENDED_ROOMS_DEFAULT_PLUS_DAYS = 7;
    //storing room information in a map
    private Map<String, IRoom> mapOfRooms = new HashMap<>(); //room number, room object
    private Map<String, Collection<Reservation>> mapOfReservations = new HashMap<>(); //

    public void addRoom(IRoom room) {
        mapOfRooms.put(room.getRoomNumber(), room);
    }

    public IRoom getRoom(String roomID) {
        return mapOfRooms.get(roomID);
    }

    public Reservation reserveARoom(Customer customer, IRoom room, Date checkInData, Date checkOutData) {
        Reservation reservation = new Reservation(customer, room, checkInData, checkOutData);
        return reservation;
    }

    public Collection<IRoom> findRooms(Data checkInData, Data checkOutData) {
        return mapOfReservations.get();
    }

    public Collection<Reservation> getCustomerReservation(Customer customer) {
        return null;
    }

    public void printAllReservation() {

    }

}
