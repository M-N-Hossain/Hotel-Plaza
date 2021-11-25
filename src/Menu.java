import java.util.Date;
import java.util.Scanner;

public class Menu {
    private static boolean exit = true;


    public static void menuHeader() {
        System.out.println("  _    _  ____ _______ ______ _         _____  ____  __  __ ______ _______ _    _ _____ _   _  _____ \n" +
                " | |  | |/ __ \\__   __|  ____| |       / ____|/ __ \\|  \\/  |  ____|__   __| |  | |_   _| \\ | |/ ____|\n" +
                " | |__| | |  | | | |  | |__  | |      | (___ | |  | | \\  / | |__     | |  | |__| | | | |  \\| | |  __ \n" +
                " |  __  | |  | | | |  |  __| | |       \\___ \\| |  | | |\\/| |  __|    | |  |  __  | | | | . ` | | |_ |\n" +
                " | |  | | |__| | | |  | |____| |____   ____) | |__| | |  | | |____   | |  | |  | |_| |_| |\\  | |__| |\n" +
                " |_|  |_|\\____/  |_|  |______|______| |_____/ \\____/|_|  |_|______|  |_|  |_|  |_|_____|_| \\_|\\_____|\n" +
                "                                                                                                     \n" +
                "                                                                                                     ");

    }

    //Showing the menu
    public static void chooseMenu() {
        menuHeader();
        System.out.println("1) Book a Room");
        System.out.println("2) Show Booked Rooms");
        System.out.println("3) Show Available Rooms");
        System.out.println("4) Check Out");
        System.out.println("5) Update Room Price");
        System.out.println("6) Show Working Schedule");
        System.out.println("7) Show Revenue");
        System.out.println("0) Exit");
    }

    //Keep looping until valid input
    public static int getInput() {
        Scanner scan = new Scanner(System.in);
        boolean didPrintError = false;
        int input = -1;
        while (input < 0 || input > 7) {
            boolean wordFormat = true;
            try {
                System.out.println("Enter Your input: ");
                input = Integer.parseInt(scan.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Wrong Format. Please try with numeric value");
                didPrintError = true;

                //return input;
            }
            if ((input < 0 || input > 7) && !didPrintError) {
                System.out.println("Wrong Input. Please try with correct input");
            }
            didPrintError = false;
        }
        return input;
    }

    public static void runMenu() {
        while (exit) {
            Menu.chooseMenu();
            int choice = Menu.getInput();
            menuOption(choice);
        }
    }

    //Menu Option
    public static void menuOption(int choice) {
        switch (choice) {
            case 0:
                System.out.println("See you soon!");
                exit = false;
                break;
            case 1:
                //Book a Room
                //System.out.println("Book a Room");
                System.out.println("=====  B O K I N G - M E N U  ======================================================" +
                        "============================================================================================" +
                        "=====================================================\n");
                Main.plaza.printAvailableRooms();
                System.out.println("PRESS [0] and then ENTER to go main menu!");
                boolean something = true;
                Scanner scan = new Scanner(System.in);
                while (something) {
                    try {
                        System.out.println("Chose the option");
                        int choice2 = Integer.parseInt(scan.next());
                        if (choice2 == 0) {
                            break;
                        }
                        while (choice2 > Main.plaza.getAvailableRooms().size()) {
                            try {
                                System.out.println("Invalid option. Please choose the available option ");
                                choice2 = Integer.parseInt(scan.next());

                            } catch (NumberFormatException e) {
                                System.out.println("Wrong format. Please try with numeric value");
                                choice2 = Integer.parseInt(scan.next());
                            }
                        }

                        int roomNr = Main.plaza.getListOfRooms().get(choice2 - 1).getRoomNr();
                        System.out.println("First Name: ");
                        String firstName = scan.next();
                        System.out.println("Last Name: ");
                        String lastName = scan.next();
                        System.out.println("Phone Number: ");
                        String phoneNr = scan.next();
                        while (!(phoneNr.length() == 8)) {
                            System.out.println(" At least 8");
                            phoneNr = scan.next();
                        }
                        System.out.println("Address: ");
                        String address = scan.next();
                        for (int i = 0; i < Main.plaza.getAvailableRooms().size(); i++) {
                            if (roomNr == Main.plaza.getAvailableRooms().get(i).getRoomNr()) {
                                MenuItems.bookARoom(Main.plaza, i);
                            }
                        }
                        Main.plaza.addToGuestList(new Guest(firstName, lastName, phoneNr, address, roomNr));
                        System.out.println("Booked SuccessFully. Welcome to our sweet place.");
                        something = false;
                    } catch (NumberFormatException n) {
                        System.out.println("\"Wrong Format. Please try with numeric value\"");
                        something = true;
                    }
                }
                break;

            case 2:
                //Show Booked Room
                System.out.println("=====  B O K E D - R O O M S  =========================================" +
                        "=========================================================================================================\n");
                Main.plaza.printBookedRooms();
                System.out.println();
                Scanner scan1 = new Scanner(System.in);
                System.out.println("Do you want to see the guest details? (Write 'Yes')");
                System.out.println("PRESS [0] and then ENTER to go main menu!");
                boolean ans = true;
                while (ans) {
                    String answer = scan1.next();
                    if (answer.equalsIgnoreCase("yes")) {
                        Main.plaza.printGuestInRoom();
                        System.out.println();
                        boolean something2 = false;
                        while (!something2) {
                            try {

                                System.out.println("*Do you want to see the rooms in details. Type room Nr. Or PRESS [0] and then Enter to go back*");
                                int chooseSpecific = Integer.parseInt(scan1.next());
                                for (int i = 0; i < Main.plaza.getBookedRoom().size(); i++) {
                                    if (chooseSpecific == Main.plaza.getBookedRoom().get(i).getRoomNr()) {
                                        Main.plaza.printBookedRooms(i);
                                        something2 = true;
                                    } else if (chooseSpecific == 0) {
                                        System.out.println("Thank you!");
                                        something2 = true;
                                    } else {
                                        System.out.println("Wrong input!");
                                        something2 = false;
                                    }
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("wrong input");
                            }
                        }
                        ans = false;
                    } else if (answer.equalsIgnoreCase("0")) {
                        System.out.println("Thank You!");
                        ans = false;
                    } else {
                        System.out.println("Wrong option, write 'yes' or Press 0");
                        ans = true;
                    }
                }
                break;

            case 3:
                //Show Available Room

                System.out.println("=====  A V A I L A B L E - R O O M S  ======================================================" +
                        "============================================================================================" +
                        "=====================================================\n");
                Main.plaza.printAvailableRooms2();
                System.out.println("PRESS [0] and then ENTER to go main menu!");
                Scanner scan2 = new Scanner(System.in);
                boolean ans2 = true;
                while (ans2) {
                    String answer2 = scan2.next();
                    if (answer2.equalsIgnoreCase("0")) {
                        System.out.println("Thank You!");
                        break;
                    } else {
                        System.out.println(" Wrong option, PRESS 0 to go back.");
                        ans2 = true;
                    }
                }
                break;

            case 4:
                //Check out
                System.out.println("=====  L E T' S - C H E C K E D - O U T  ==============================================================" +
                        "==========================================================================\n");
                Main.plaza.printBookedRooms();
                System.out.println("Select Booked Nr to check out");
                Scanner scan3 = new Scanner(System.in);
                int index = scan3.nextInt();
                Main.plaza.printAGuest(index);
                System.out.println("Successfully Checked out. See you again! Thank you. ");
                MenuItems.checkOut(Main.plaza, index);
                break;

            case 5:
                Main.plaza.printAvailableRooms();
                System.out.println("Select: ");
                Scanner scan4 = new Scanner(System.in);
                boolean case5 = false;
                int select;
                while (!case5) {
                    try {
                        select = Integer.parseInt(scan4.next());
                        if (select > 0 && select < Main.plaza.getAvailableRooms().size() + 1) {
                            System.out.println("Current price");
                            System.out.println(Main.plaza.getAvailableRooms().get(select - 1).getPricePerNight());
                            System.out.println("Enter new price");
                            double newPrice = Double.valueOf(scan4.next());
                            Main.plaza.getAvailableRooms().get(select - 1).setPricePerNight(newPrice);
                            System.out.println("Price is changed");
                            System.out.println("New price is: ");
                            System.out.println(Main.plaza.getAvailableRooms().get(select - 1).getPricePerNight());
                            case5 = true;

                        } else {
                            System.out.println("Wrong Selection. Select correct number");
                            Main.plaza.printAvailableRooms();
                            System.out.println("Select: ");
                        }

                    } catch (NumberFormatException e) {
                        System.out.println("Inappropriate word");
                        Main.plaza.printAvailableRooms();
                        System.out.println("Select: ");
                    }
                }
                break;

            case 6:
                //working schedule
                System.out.println("Show working schedule");
                break;
            case 7:
                //Show the revenue
                System.out.println("Show the revenue");
                break;

        }
    }


}

