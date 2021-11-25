import java.io.*;

public class Main {
    public static Hotel plaza = new Hotel();

    public static void main(String[] args) {

    /*    Room single1 = new Room("Single",false,1500,true,1,101);
        Room single2 = new Room("Single",false,2000,true,2,201);
        Room double1 = new Room("Double",false,2500,true,1,102);
        Room double2 = new Room("Double",false,3000,true,2,202);
        Room suite1 = new Room("Suite",true,3800,true,1,103);
        Room suite2 = new Room("Suite",true,4000,true,2,203);
        plaza.addAvailableRoom(single1);
        plaza.addAvailableRoom(single2);
        plaza.addAvailableRoom(double1);
        plaza.addAvailableRoom(double2);
        plaza.addAvailableRoom(suite1);
        plaza.addAvailableRoom(suite2);

        plaza.addToListOfRooms(single1);
        plaza.addToListOfRooms(single2);
        plaza.addToListOfRooms(double1);
        plaza.addToListOfRooms(double2);
        plaza.addToListOfRooms(suite1);
        plaza.addToListOfRooms(suite2);

        plaza.printRoomDetails(2);


        Serialization.serialize(plaza,"Database.ser");*/
        plaza = Serialization.deSerialize("Database.ser");
        //plaza.printEmployees();
        //plaza.printAvailableRooms();
        Menu.runMenu();
        Serialization.serialize(plaza, "Database.ser");


    }

}
