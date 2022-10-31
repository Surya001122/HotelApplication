import javafx.scene.input.InputMethodTextRun;
import java.time.LocalDate;
import java.util.*;
import java.time.LocalDateTime;

public abstract class Room {
    Scanner sc = new Scanner(System.in);
    private String customerId; // stores the customerId.
    private int roomNumber; // stores the room_number.
    private String roomType; // stores the type of the room.
    private int floorNumber; // stores the floorNumber of the room.
    private boolean roomStatus; // indicates whether the room is vacant or occupied.
    private int totalBeds; // stores the number of beds the room has in it.
    private int rent;
    private int totalDays;
    private int otherServicesRate; // stores the amount to pay for other services to that room.
    private int foodOrdersAmount;
    private int roomMobileNumber; // stores the room's mobileNumber.
    private static int roomServiceNumber = 123; // stores the room service number. static variable as the roomService number remains same for all the rooms.
    public Room(int roomNumber, String roomType, int floorNumber, int totalBeds, int rent, int roomMobileNumber) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.floorNumber = floorNumber;
        this.totalBeds = totalBeds;
        this.rent = rent;
        this.roomMobileNumber = roomMobileNumber;
        this.totalDays = 0;
        this.otherServicesRate = 0;
        this.foodOrdersAmount = 0;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
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

    public int getTotalDays() {
        return totalDays;
    }

    public void setTotalDays(int totalDays) {
        this.totalDays = totalDays;
    }

    public int getOtherServicesRate() {
        return otherServicesRate;
    }

    public void setOtherServicesRate(int otherServicesRate) {
        this.otherServicesRate = otherServicesRate;
    }

    public int getFoodOrdersAmount() {
        return foodOrdersAmount;
    }

    public void setFoodOrdersAmount(int foodOrdersAmount) {
        this.foodOrdersAmount = foodOrdersAmount;
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

    public void bookRoom(Customer customer) {
        this.customerId = customer.getCustomerId();
        this.roomStatus = true;
    } // method is used to change the status of the boolean type roomStatus to true to indicate that ths room is now occupied.
    public void cancelBooking() {
        this.customerId = null;
        this.roomStatus = false;
        this.totalDays = 0;
        this.otherServicesRate = 0;
        this.foodOrdersAmount = 0;
        if( (this.roomType.equals("Single") && this.totalBeds==2) || (this.roomType.equals("Double") && this.totalBeds==3) || (this.roomType.equals("Deluxe") && this.totalBeds==4) ) {
            this.totalBeds -= 1;
        }
    } // method is used to change the status of the boolean type roomStatus to false to indicate that the room is now vacant.

    public void displayRoomInfo() {
        System.out.println("\n\nRoom Type : "+this.roomType+"\nRoom Number : "+this.roomNumber+"" +"\nFloorNumber : "+this.floorNumber+"\nTotal beds : "+this.totalBeds+"\nRoom rent : "+this.rent);
    } // method is used to display the room details.
    public void orderExtraBeds() {
        if( (this.roomType.equals("Single") && this.totalBeds==1) || (this.roomType.equals("Double") && this.totalBeds==2) || (this.roomType.equals("Deluxe") && this.totalBeds==3) ) {
            this.totalBeds += 1;
            this.otherServicesRate += 100;
        }
    } // method is used to order extra beds after checking if that beds can be accomodated on that roomtype and the totalBeds variable will be increased.
    public int calculateOtherServices(){
        return this.getOtherServicesRate();
    }
    public int calculateFoodOrdersAmount(){
        return this.getFoodOrdersAmount();
    }
    public void placeOrder(Chef chef)
    {


    }
    abstract void viewAvailableFacilities();// abstract method, as the availability of facilities changes for different rooms and there is no need to implement this method in general class Room.
    abstract int calculateRoomRent(); //abstract method, as the rent differ for each room based on the facilities and the implementation of calculating the rent is hidden.
}
