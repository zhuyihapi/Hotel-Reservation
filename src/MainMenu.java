import service.CustomerService;
import service.ReservationService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class MainMenu {
    static final String DEFAULT_DATE_FORMAT = "MM/dd/yyyy";

    public static void mainMenu() {
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
                    System.out.println("case 2 not complete");
                    break;
                case 3:
                    System.out.println("Please enter your first name");
                    String fn = scan.nextLine();
                    System.out.println("Please enter your last name");
                    String ln = scan.nextLine();
                    System.out.println("Please enter your email");
                    String em = scan.nextLine();
                    System.out.println("Please check: " + fn + " " + ln + ", your email is " + em);

                    break;
                case 4:
                    AdminMenu.adminMenu();
                    break;
                case 5:
                    System.out.println("Exit");
                    break mainWhileLoop;
                case 6:
                    System.out.println("case 6 executed");
                    System.out.println(CustomerService.getAllCustomers());
                    break;
                default:
                    System.out.println("Unknown action");
                    break;
            }

            System.out.println("Return to main menu? y or n?");
            String answer = scan.nextLine();
            if (answer.equals("n")) {
                System.out.println("Bye");
                break;
            } else if (!answer.equals("y")) {
                System.out.println("返回主目录异常");
            }
        }


    }

    public static void printMainMenu() {
        System.out.println("Welcome!");
        System.out.println("------------------------------------");
        System.out.println("1. Find and reserve a room");
        System.out.println("2. See my reservations");
        System.out.println("3. Create a account");
        System.out.println("4. Admin");
        System.out.println("5. Exit");
        System.out.println("6. Main Menu Test");
        System.out.println("------------------------------------");
        System.out.println("Please select a number for menu option");
    }


    private static void findAndReserveRoom() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter Check-In Date mm/dd/yyyy example 01/01/2020");
        Date checkInDate = getInputDate(scan);

        System.out.println("Enter Check-Out Date mm/dd/yyyy example 01/21/2020");
        Date checkOutDate = getInputDate(scan);
        if (checkInDate != null && checkOutDate != null){
            ReservationService.findRooms(checkInDate,checkOutDate);
        }
    }

    private static Date getInputDate(final Scanner scanner) {
        try {
            return new SimpleDateFormat(DEFAULT_DATE_FORMAT).parse(scanner.nextLine());
        } catch (ParseException ex) {
            System.out.println("Error: Invalid date.");
            findAndReserveRoom();
        }
        return null;
    }

    private static void seeMyReservations() {

    }

    private static void createAAccount() {

    }


    /*public static void main(String[] args) {
        mainWhileLoop:
        while (true) {
            System.out.println("Welcome!");
            System.out.println("------------------------------------");
            System.out.println("1. Find a reserve a room");
            System.out.println("2. See my reservations");
            System.out.println("3. Create a account");
            System.out.println("4. Admin");
            System.out.println("5. Exit");
            System.out.println("6. Main Menu Test");
            System.out.println("------------------------------------");
            System.out.println("Please select a number for menu option");

            Scanner scan = new Scanner(System.in);
            int userInput = 0;
            try {
                userInput = Integer.parseInt(scan.nextLine());
                //System.out.println(userInput);
            } catch (NumberFormatException e) {
                //e.printStackTrace();
                System.out.println("Please enter an integer between 1 and 5!");
            }

            switch (userInput) {
                case 1:
                    System.out.println("case 1 not complete");
                    break;
                case 2:
                    System.out.println("case 2 not complete");
                    break;
                case 3:
                    System.out.println("Please enter your first name");
                    String fn = scan.nextLine();
                    System.out.println("Please enter your last name");
                    String ln = scan.nextLine();
                    System.out.println("Please enter your email");
                    String em = scan.nextLine();
                    System.out.println("Please check: "+fn +" "+ ln + ", your email is " + em);
                    CustomerService customer = new CustomerService(fn, ln, em);
                    customer.addCustomer(customer.email, customer.firstName, customer.lastName);
                    break;
                case 4:
                    System.out.println("------------------------------------");
                    System.out.println("1. See all Customers");
                    System.out.println("2. See all Rooms");
                    System.out.println("3. See all Reservations");
                    System.out.println("4. Add a room");
                    System.out.println("5. Add Test Data");
                    System.out.println("6. Back to Main Menu");
                    System.out.println("------------------------------------");
                    System.out.println("Please select a number for menu option");

                case 5:
                    System.out.println("Exit! Bye");
                    break mainWhileLoop;
                case 6:
                    System.out.println("case 6 executed");
                    System.out.println(CustomerService.getAllCustomers());
                    break;

            }

            System.out.println("Return to main menu? y or n?");
            String answer = scan.nextLine();
            if (answer.equals("n")) {
                System.out.println("Bye");
                break;
            } else if (!answer.equals("y")) {
                System.out.println("返回主目录异常");
            }
        }

    }*/

}
