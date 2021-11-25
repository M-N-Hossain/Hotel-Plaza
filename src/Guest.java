import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Guest extends PersonalInfo implements Serializable {
    static final long serialVersionUID = 44L;
    private String address;
    private int roomNumber;


    public Guest(String firstName, String lastName, String phoneNr, String address, int roomNumber) {
        super(firstName, lastName, phoneNr);
        this.address = address;
        this.roomNumber = roomNumber;
    }

    public String getAddress() {
        return address;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    @Override
    public String toString() {
        return "Guest{" +
                "address='" + address + '\'' +
                ", roomNumber=" + roomNumber +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNr=" + phoneNr +
                '}';
    }
}
