package service;

import model.Customer;
import model.IRoom;
import model.Reservation;
import model.Room;

import java.util.*;

public class ReservationService {

    //private static int RECOMMENDED_ROOMS_DEFAULT_PLUS_DAYS = 7;
    //storing room information in a map
    private static Map<String, IRoom> mapOfRooms = new HashMap<>(); //room number, room object
    private static Map<String, Reservation> mapOfReservations = new HashMap<>();

    public static void addRoom(IRoom room) {
        mapOfRooms.put(room.getRoomNumber(), room);
    }

    public static IRoom getRoom(String roomID) {
        return mapOfRooms.get(roomID);
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
        System.out.println(mapOfReservations);
    }

    public static void main(String[] args) {
        Customer customer1 = new Customer("yihan", "zhu", "1@2.c");
        IRoom room1 = new Room("100", 10.0, Room.RoomType.SINGLE);
        IRoom room2 = new Room("101", 15.0, Room.RoomType.DOUBLE);

        //Date checkInDate1 = new Date(10 / 1);
        //Date checkOutDate1 = new Date(10 / 3);

        Calendar calendar = Calendar.getInstance();
        calendar.set(2000, 00, 01);
        Date Date1 = calendar.getTime();
        calendar.set(2000, 00, 03);
        Date Date2 = calendar.getTime();
        calendar.set(2000, 00, 05);
        Date Date3 = calendar.getTime();

        Reservation reservation1 = new Reservation(customer1, room1, Date1, Date2);
        ReservationService.addRoom(room1);
        ReservationService.addRoom(room2);

        ReservationService.reserveARoom(customer1, room1, Date1, Date2);

        for (IRoom i : ReservationService.findRooms(Date3,Date3)) {
            System.out.println(i);
        }
        for (Reservation r : ReservationService.getCustomerReservation(customer1)) {
            System.out.println(r);
        }

        ReservationService.printAllReservation();


/*        System.out.println(mapOfReservations);
        for (String roomID :
                mapOfReservations.keySet()) {
            System.out.println(mapOfReservations.get(roomID));
        }*/

        //System.out.println(ReservationService.getRoom("101"));

    }

}
