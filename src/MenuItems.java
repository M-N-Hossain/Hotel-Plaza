import java.util.ArrayList;

public class MenuItems {
    public static void bookARoom(Hotel hotel, int index) {
        hotel.addToBookedRooms((index));
        hotel.removeFromAvailableRoom((index));
    }

    public static void checkOut(Hotel hotel, int index) {
        hotel.removeFromBookedRoom(index - 1);
        hotel.addToAvailableRoom(index - 1);
        hotel.removeFromGuestList(index - 1);
    }

    public void workingSchedule() {
    }

    public void revenue() {
    }
}
