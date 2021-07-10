import api.AdminResource;
import api.HotelResource;
import model.Room;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class MainMenu {
    static final String DEFAULT_DATE_FORMAT = "MM/dd/yyyy";

    public static void mainMenu() {
        //pre-test
        HotelResource.createCustomer("1@1.c", "yihan", "zhu");
        HotelResource.createCustomer("admin@a.com", "admin", "");
        Room room1 = new Room("99", 99.0, Room.RoomType.SINGLE);
        Room room2 = new Room("98", 98.0, Room.RoomType.DOUBLE);
        AdminResource.addRoom(room1);
        AdminResource.addRoom(room2);

        //main program
        System.out.println("Welcome!");
        mainWhileLoop:
        while (true) {
            printMainMenu();
            Scanner scan = new Scanner(System.in);
            int userInput = 0;
            try {
                userInput = Integer.parseInt(scan.nextLine());
                if (userInput / 10 != 0) {
                    System.out.println(userInput % 10);
                    System.out.println("Invalid input! The input are supposed to between 1 and 5");
                }
                //System.out.println(userInput);
            } catch (NumberFormatException e) {
                //e.printStackTrace();
                System.out.println("Please enter an integer between 1 and 5!");
            }

            switch (userInput) {
                case 1:
                    findAndReserveRoom();
                    break;
                case 2:
                    seeMyReservations();
                    break;
                case 3:
                    createAAccount();
                    break;
                case 4:
                    AdminMenu.adminMenu();
                    continue mainWhileLoop;
                case 5:
                    break mainWhileLoop;
                default:
                    System.out.println("Unknown action");
                    break mainWhileLoop;
            }
        }
        System.out.println("Application exits");
    }

    public static void printMainMenu() {
        System.out.println("-------------main menu--------------");
        System.out.println("1. Find and reserve a room");
        System.out.println("2. See my reservations");
        System.out.println("3. Create a account");
        System.out.println("4. Admin");
        System.out.println("5. Exit");
        System.out.println("------------------------------------");
        System.out.println("Please select a number for menu option:");
    }


    private static void findAndReserveRoom() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Check-In Date mm/dd/yyyy example 01/01/2020");
        Date checkInDate = getInputDate(scanner);

        System.out.println("Enter Check-Out Date mm/dd/yyyy example 01/21/2020");
        Date checkOutDate = getInputDate(scanner);
        if (checkInDate != null && checkOutDate != null) {
            System.out.println("Available rooms:");
            HotelResource.findARoom(checkInDate, checkOutDate);
        }
        System.out.println("Please select a room number to reserve, or enter e to exit:");
        String userChoice = scanner.nextLine();
        if (userChoice.equals("e")) {
            System.out.println("Return to main menu");
        } else {
            System.out.println("Please enter your email:");
            String currentCustomerEmail = scanner.nextLine();
            //TODO 格式化输出
            if (HotelResource.getCustomer(currentCustomerEmail) != null) {
                System.out.println("Please confirm your reservation:\n" +
                        HotelResource.bookARoom(currentCustomerEmail, HotelResource.getRoom(userChoice), checkInDate, checkOutDate).toString());
                confirm();
            }
        }

    }

    private static Date getInputDate(final Scanner scanner) {
        try {
            return new SimpleDateFormat(DEFAULT_DATE_FORMAT).parse(scanner.nextLine());
        } catch (ParseException ex) {
            System.out.println("Error: Invalid date.");
            getInputDate(scanner);
        }
        return null;
    }

    private static void seeMyReservations() {
        System.out.println("please enter your email address:");
        Scanner scanner = new Scanner(System.in);
        String inputEmail = scanner.nextLine();
        //TODO 格式化输出?
        System.out.println(HotelResource.getCustomerReservations(inputEmail));
        confirm();
    }

    private static void createAAccount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your first name");
        String fn = scanner.nextLine();
        System.out.println("Please enter your last name");
        String ln = scanner.nextLine();
        System.out.println("Please enter your email");
        String em = scanner.nextLine();
        //check component option
        HotelResource.createCustomer(em, fn, ln);
    }

    public static void confirm() {
        System.out.println("--------------------------");
        System.out.println("Enter anything to continue");
        Scanner scanner = new Scanner(System.in);
        String anything = scanner.nextLine();
    }

}
