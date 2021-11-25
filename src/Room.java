import java.io.Serializable;
import java.util.ArrayList;

public class Room implements Serializable {
    static final long serialVersionUID = 47L;

    private String roomKind;
    private boolean wifiAccess;
    private double pricePerNight;
    private boolean available;
    private int floorNr;
    private int roomNr;
    private ArrayList<Guest> guestsInRoom;


    public Room(String roomKind, boolean wifiAccess, double pricePerNight, boolean available, int floorNr, int roomNr) {
        this.roomKind = roomKind;
        this.wifiAccess = wifiAccess;
        this.pricePerNight = pricePerNight;
        this.available = available;
        this.floorNr = floorNr;
        this.roomNr = roomNr;


    }

    public String getRoomKind() {
        return roomKind;
    }

    public boolean isWifiAccess() {
        return wifiAccess;
    }

    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public boolean isAvailable() {
        return available;
    }

    public int getRoomNr() {
        return roomNr;
    }

    public int getFloorNr() {
        return floorNr;
    }

    public ArrayList<Guest> getGuestsInRoom() {
        return guestsInRoom;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomKind='" + roomKind + '\'' +
                ", wifiAccess=" + wifiAccess +
                ", pricePerNight=" + pricePerNight +
                ", available=" + available +
                ", floorNr=" + floorNr +
                ", roomNr=" + roomNr +
                ", guestsInRoom=" + guestsInRoom +
                '}';
    }
}

