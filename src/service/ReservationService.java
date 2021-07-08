package service;

import model.Customer;
import model.IRoom;
import model.Reservation;
import model.Room;

import javax.xml.crypto.Data;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ReservationService {

    //private static int RECOMMENDED_ROOMS_DEFAULT_PLUS_DAYS = 7;
    //storing room information in a map
    private static Map<String, Room> mapOfRooms = new HashMap<>(); //room number, room object
    private static Map<String, Collection<Reservation>> mapOfReservations = new HashMap<>();

    public static void addRoom(Room room) {
        mapOfRooms.put(room.getRoomNumber(), room);
    }

    public static IRoom getRoom(String roomID) {
        return mapOfRooms.get(roomID);
    }

    public static Reservation reserveARoom(Customer customer, IRoom room, Date checkInData, Date checkOutData) {
        Reservation reservation = new Reservation(customer, room, checkInData, checkOutData);
        return reservation;
    }

/*    public Collection<IRoom> findRooms(Data checkInData, Data checkOutData) {
        for (String roomID :
                mapOfReservations.keySet()) {
            if (mapOfReservations.get(roomID).getCheckInData() <= checkInData){

            }
        }
        return mapOfReservations.get();
    }*/

    public Collection<Reservation> getCustomerReservation(Customer customer) {
        return null;
    }

    public void printAllReservation() {

    }

    public static void main(String[] args) {

    }

}
