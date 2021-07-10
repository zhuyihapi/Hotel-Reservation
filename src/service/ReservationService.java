package service;

import model.Customer;
import model.IRoom;
import model.Reservation;

import java.util.*;
//TODO Search for recommended rooms
public class ReservationService {

    //private static int RECOMMENDED_ROOMS_DEFAULT_PLUS_DAYS = 7;
    //storing room information in a map
    private static Map<String, IRoom> mapOfRooms = new HashMap<>(); //room number, room object
    private static Map<String, Reservation> mapOfReservations = new HashMap<>();

    public static void addRoom(IRoom room) {
        try {
            if (mapOfRooms.containsKey(room.getRoomNumber())) {
                throw new Exception();
            } else {
                mapOfRooms.put(room.getRoomNumber(), room);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Room has already exist!");
        }
    }

    public static IRoom getRoom(String roomID) {
        return mapOfRooms.get(roomID);
    }

    public static Collection<IRoom> getAllRoom() {
/*        ArrayList<IRoom> roomArrayList = new ArrayList<>(10);
        for (String roomID : mapOfRooms.keySet()) {
            roomArrayList.add(mapOfRooms.get(roomID));
        }
        return roomArrayList;*/
        return mapOfRooms.values();
    }

    public static Reservation reserveARoom(Customer customer, IRoom room, Date checkInData, Date checkOutData) {
        Reservation reservation = new Reservation(customer, room, checkInData, checkOutData);
        mapOfReservations.put(room.getRoomNumber(), reservation);
        return reservation;
    }

    public static Collection<IRoom> findRooms(Date checkInData, Date checkOutData) {
        ArrayList<IRoom> freeRoomList = new ArrayList<>(5);

        for (String roomID : mapOfRooms.keySet()) {
            if (!mapOfReservations.containsKey(roomID)) {
                freeRoomList.add(mapOfRooms.get(roomID));
                //System.out.println(mapOfRooms.get(roomID));
            } else {
                if (mapOfReservations.get(roomID).getCheckOutData().getTime() <= checkInData.getTime()
                        || mapOfReservations.get(roomID).getCheckInData().getTime() >= checkOutData.getTime()) {
                    freeRoomList.add(mapOfRooms.get(roomID));
                    //System.out.println(mapOfRooms.get(roomID));
                }
            }
        }
        return freeRoomList;
    }

    public static Collection<Reservation> getCustomerReservation(Customer customer) {
        ArrayList<Reservation> customerReservation = new ArrayList<>(5);

        for (String roomID : mapOfReservations.keySet()) {
            if (mapOfReservations.get(roomID).getCustomer().equals(customer)) {
                customerReservation.add(mapOfReservations.get(roomID));
            }
        }
        return customerReservation;
    }

    public static void printAllReservation() {
        if (mapOfReservations.values() == null) {
            System.out.println("No reservation exist");
        } else {
            for (Reservation reservation : mapOfReservations.values()) {
                int i = 1;
                System.out.println(i + ". " + reservation.toString());
                i++;
            }
        }
    }
}
