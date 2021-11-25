import java.io.Serializable;
import java.util.ArrayList;

public class Hotel implements Serializable {
    static final long serialVersionUID = 45L;

    private ArrayList<Room> availableRooms = new ArrayList<>();
    private ArrayList<Room> listOfRooms = new ArrayList<>();
    private ArrayList<Room> bookedRoom = new ArrayList<>();
    private ArrayList<Employee> staff = new ArrayList<>();
    private ArrayList<Employee> staffOnDuty = new ArrayList<>();
    private ArrayList<Guest> listOfGuest = new ArrayList<>();


    //Available room methods start
    public void addAvailableRoom(Room room) {
        availableRooms.add(room);
    }

    public void addToAvailableRoom(int index) {
        availableRooms.add(getAvailableRooms().get(index));
    }

    public void removeFromAvailableRoom(int index) {
        availableRooms.remove(getAvailableRooms().get(index));
    }

    public ArrayList<Room> getAvailableRooms() {
        return availableRooms;
    }

    public void printAvailableRooms() {
        System.out.println("The following rooms are available: ");
        System.out.println();
        System.out.printf("%-15s%-15s%-20s%-5s\n", "Room Nr", "Floor Nr", "Room kind", "Price");
        for (int i = 0; i < availableRooms.size(); i++) {
            String navigation = "Press [" + (i + 1) + "] and then [Enter] to Select";
            System.out.printf("%4s%15d%18s%20.3f%45s\n", getAvailableRooms().get(i).getRoomNr(), getAvailableRooms().get(i).getFloorNr(),
                    getAvailableRooms().get(i).getRoomKind(), getAvailableRooms().get(i).getPricePerNight(), navigation);
            System.out.println("........................................................................................." +
                    ".......................................................................................");
        }
    }

    public void printAvailableRooms2() {
        //System.out.println("The following rooms are available: ");
        System.out.println();
        System.out.printf("%-15s%-15s%-15s%-20s%-5s\n", "Nr Of Room", "Floor Nr", "Room Nr", "Room kind", "Price");
        for (int i = 0; i < availableRooms.size(); i++) {
            System.out.printf("%4s%15d%15d%18s%20.3f\n", (i + 1) + ".", getAvailableRooms().get(i).getFloorNr(), getAvailableRooms().get(i).getRoomNr(),
                    getAvailableRooms().get(i).getRoomKind(), getAvailableRooms().get(i).getPricePerNight());
            System.out.println("........................................................................................." +
                    ".......................................................................................");
        }
    }


    //List of room methods start
    public ArrayList<Room> getListOfRooms() {
        return listOfRooms;
    }

    public void addToListOfRooms(Room room) {
        listOfRooms.add(room);
    }

    public void printListOFRooms() {
        System.out.printf("%-15s%-15s%-20s%-5s\n", "Floor Nr", "Room Nr", "Room kind", "Price");

        for (int i = 0; i < getListOfRooms().size(); i++) {
            String navigation = "Press [" + (i + 1) + "] and then [Enter] to Select for change the price";
            System.out.printf("%5d%15d%17s%20.3f%45s\n", getListOfRooms().get(i).getFloorNr(), getListOfRooms().get(i).getRoomNr(),
                    getListOfRooms().get(i).getRoomKind(), getListOfRooms().get(i).getPricePerNight(), navigation);
            System.out.println("........................................................................................." +
                    ".......................................................................................");
        }
    }

    public void printRoomDetails(int index) {
        System.out.printf("%-15s%-15s%-20s%-5s\n", "Floor Nr", "Room Nr", "Room kind", "Price");
        System.out.printf("%5d%15d%17s%20.3f\n", getListOfRooms().get(index).getFloorNr(), getListOfRooms().get(index).getRoomNr(),
                getListOfRooms().get(index).getRoomKind(), getListOfRooms().get(index).getPricePerNight());
        System.out.println("........................................................................................." +
                ".......................................................................................");
    }


    //Booked room methods starts
    public ArrayList<Room> getBookedRoom() {
        return bookedRoom;
    }

    public void addToBookedRooms(int index) {
        bookedRoom.add(getAvailableRooms().get(index));
    }

    public void removeFromBookedRoom(int index) {
        bookedRoom.remove(index);
    }

    public void printBookedRooms() {
        //System.out.println("The following rooms are booked: ");
        System.out.println();
        System.out.printf("%-15s%-15s%-15s%-20s%-5s\n", "Booked Nr", "Floor Nr", "Room Nr", "Room kind", "Price");
        for (int i = 0; i < bookedRoom.size(); i++) {
            System.out.printf("%4s%15d%15d%18s%20.3f\n", (i + 1) + ".", getBookedRoom().get(i).getFloorNr(), getBookedRoom().get(i).getRoomNr(),
                    getBookedRoom().get(i).getRoomKind(), getBookedRoom().get(i).getPricePerNight());
            System.out.println("........................................................................................." +
                    ".......................................................................................");
        }
    }

    public void printBookedRooms(int index) {
        //System.out.println("The following rooms are booked: ");
        System.out.println();
        System.out.printf("%-15s%-15s%-15s%-20s%-5s\n", "Booked Nr", "Floor Nr", "Room Nr", "Room kind", "Price");
        for (int i = 0; i < bookedRoom.size(); i++) {
            System.out.printf("%4s%15d%15d%18s%20.3f\n", (i + 1) + ".", getBookedRoom().get(index).getFloorNr(), getBookedRoom().get(index).getRoomNr(),
                    getBookedRoom().get(index).getRoomKind(), getBookedRoom().get(index).getPricePerNight());
            System.out.println("........................................................................................." +
                    ".......................................................................................");
        }
    }


    //List of employee method
    public void addEmployee(Employee employee) {
        staff.add(employee);
    }

    public ArrayList<Employee> getStaff() {
        return staff;
    }

    public void printEmployees() {
        System.out.println("Current employees are: ");
        for (int i = 0; i < staff.size(); i++) {
            System.out.println((i + 1) + " " + getStaff().get(i).getTitle() + ": " + getStaff().get(i).getFirstName() + " " + getStaff().get(i).getLastName());
        }
    }


    //List of guest method starts:
    public void addToGuestList(Guest guest) {
        listOfGuest.add(guest);
    }

    public void removeFromGuestList(int index) {
        listOfGuest.remove(index);
    }

    public ArrayList<Guest> getListOfGuest() {
        return listOfGuest;
    }

    public void printGuestInRoom() {
        System.out.println("Details of guest: ");
        for (int i = 0; i < listOfGuest.size(); i++) {
            System.out.println("[" + (i + 1) + "]" + " Name: " + getListOfGuest().get(i).getFirstName() + " " + getListOfGuest().get(i).getLastName()
                    + ", Address: " + getListOfGuest().get(i).getAddress() + ",  Phone Number: " + getListOfGuest().get(i).getPhoneNr() +
                    ", Room Number: " + getListOfGuest().get(i).getRoomNumber());
        }
    }

    public void printAGuest(int index) {
        for (int i = 0; i < listOfGuest.size(); i++) {
            System.out.println(" Name: " + getListOfGuest().get(index - 1).getFirstName() + " " + getListOfGuest().get(index - 1).getLastName()
                    + ", Address: " + getListOfGuest().get(index - 1).getAddress() + ",  Phone Number: " + getListOfGuest().get(index - 1).getPhoneNr() +
                    ", Room Number: " + getListOfGuest().get(index - 1).getRoomNumber());
        }
    }


}
