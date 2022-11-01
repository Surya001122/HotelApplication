import javafx.scene.input.InputMethodTextRun;

import java.time.LocalDate;
import java.util.*;
import java.time.LocalDateTime;

public abstract class Room {
    Scanner sc = new Scanner(System.in);
    private int roomNumber;
    private String roomType;
    private int floorNumber;
    private boolean roomStatus;
    private int totalBeds;
    private int rent;
    private int roomMobileNumber;
    private static int roomServiceNumber = 123;

    public Room(int roomNumber, String roomType, int floorNumber, int totalBeds, int rent, int roomMobileNumber) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.floorNumber = floorNumber;
        this.totalBeds = totalBeds;
        this.rent = rent;
        this.roomMobileNumber = roomMobileNumber;
    }


    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public boolean getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(boolean roomStatus) {
        this.roomStatus = roomStatus;
    }

    public int getTotalBeds() {
        return totalBeds;
    }

    public void setTotalBeds(int totalBeds) {
        this.totalBeds = totalBeds;
    }

    public int getRent() {
        return rent;
    }

    public void setRent(int rent) {
        this.rent = rent;
    }

    public int getRoomMobileNumber() {
        return roomMobileNumber;
    }

    public void setRoomMobileNumber(int roomMobileNumber) {
        this.roomMobileNumber = roomMobileNumber;
    }

    public static int getRoomServiceNumber() {
        return roomServiceNumber;
    }

    public static void setRoomServiceNumber(int roomServiceNumber) {
        Room.roomServiceNumber = roomServiceNumber;
    }

    public void displayRoomInfo() {
        System.out.println("\n\nRoom Type : " + this.roomType +
                "\nRoom Number : " + this.roomNumber +
                "\nFloorNumber : " + this.floorNumber +
                "\nTotal beds : " + this.totalBeds +
                "\nRoom rent : " + this.rent);
    }

    abstract void viewAvailableFacilities();// abstract method, as the availability of facilities changes for different rooms and there is no need to implement this method in general class Room.

    abstract int calculateRoomRent(int days);
}
