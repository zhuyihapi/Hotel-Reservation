import api.AdminResource;
import model.Customer;
import model.IRoom;
import model.Room;
import service.CustomerService;
import service.ReservationService;

import java.util.Collections;
import java.util.Locale;
import java.util.Scanner;

public class AdminMenu {
    public static void adminMenu() {
        adminWhileLoop:
        while (true) {
            printAdminMenu();
            Scanner scan = new Scanner(System.in);
            int userInput = 0;
            try {
                userInput = Integer.parseInt(scan.nextLine());
                if (userInput / 10 != 0) {
                    System.out.println(userInput % 10);
                    System.out.println("Invalid input! The input are supposed to between 1 and 6");
                }
            } catch (NumberFormatException e) {
                //e.printStackTrace();
                System.out.println("Please enter an integer between 1 and 5!");
            }

            switch (userInput) {
                case 1:
                    seeAllCustomers();
                    break;
                case 2:
                    seeAllRooms();
                    break;
                case 3:
                    break;
                case 4:
                    addARoom();
                    break;
                case 5:
                    break;
                case 6:

                    break;
                default:
                    System.out.println("Unknown action");
                    break;
            }

        }
    }

    public static void printAdminMenu() {
        System.out.println("------------------------------------");
        System.out.println("1. See all Customers");
        System.out.println("2. See all Rooms");
        System.out.println("3. See all Reservations");
        System.out.println("4. Add a room");
        System.out.println("5. Add Test Data");
        System.out.println("6. Back to Main Menu");
        System.out.println("------------------------------------");
        System.out.println("Please select a number for menu option");
    }

    private static void seeAllCustomers(){
        for (Customer customer : AdminResource.getAllCustomers()) {
            System.out.println(customer.toString());
        }
        adminMenu();
    }

    private static void seeAllRooms(){
        //AdminResource.getAllRooms();
        for (IRoom room : AdminResource.getAllRooms()) {
            System.out.println(room.toString());
        }
        adminMenu();
    }

    private static void addARoom() {
        String answer = "N";
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter room number:");
            String roomNumber = scanner.nextLine();
            System.out.println("Enter price per night:");
            double roomPrice = Double.parseDouble(scanner.nextLine());
            System.out.println("Enter room type: single or double(enter s or d):");
            Room.RoomType roomType = enterRoomType(scanner);

            Room newRoom = new Room(roomNumber, roomPrice, roomType);
            ReservationService.addRoom(newRoom);
            System.out.println("Room added successfully!");

            System.out.println("Would like to add another room? Y/N");
            answer = scanner.nextLine().toUpperCase(Locale.ROOT);
        } while (answer.equals("Y"));
        adminMenu();
    }

    private static Room.RoomType enterRoomType(Scanner scanner) {
        //transform String to roomType
        try {
            Room.RoomType roomType = Room.RoomType.valueOfLabel(scanner.nextLine().toLowerCase(Locale.ROOT));
            return roomType;
        } catch (IllegalArgumentException exp) {
            System.out.println("Invalid room type! Please, choose s for single bed or d for double bed");
            return enterRoomType(scanner);
        }
    }
}
