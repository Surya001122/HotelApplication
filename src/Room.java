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
    private int otherServicesRate; // stores the amount of other services to that room.
    private int roomMobileNumber; // stores the room's mobileNumber.
    private static int roomServiceNumber = 123; // stores the room service number. static variable as the roomService number remains same for all the rooms.
    private static String wifiName = "KFC"; // common to all rooms
    private static String wifiPassword = "KFC123"; // common to all rooms
    HashMap<Integer,String> guests; // stores the guestId and guestName in the rooms booked...includes the person's name and person's id accompanying the customers.
    private HashMap<String,Integer> PantryItems; // stores the quantity of item and the food item used in pantry.

    public Room(int roomNumber, String roomType, int floorNumber, int totalBeds, int rent, int roomMobileNumber) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.floorNumber = floorNumber;
        this.totalBeds = totalBeds;
        this.rent = rent;
        this.roomMobileNumber = roomMobileNumber;
        this.totalDays = 0;
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

    public static String getWifiName() {
        return wifiName;
    }

    public static void setWifiName(String wifiName) {
        Room.wifiName = wifiName;
    }

    public static String getWifiPassword() {
        return wifiPassword;
    }

    public static void setWifiPassword(String wifiPassword) {
        Room.wifiPassword = wifiPassword;
    }

    public HashMap<String, Integer> getPantryItems() {
        return PantryItems;
    }

    public void setPantryItems(HashMap<String, Integer> pantryItems) {
        PantryItems = pantryItems;
    }

    public HashMap<Integer, String> getGuests() {
        return guests;
    }

    public void setGuests(HashMap<Integer, String> guests) {
        this.guests = guests;
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
    public void callRoomService(int number) {
        if(number==roomServiceNumber)
        {
            System.out.println("\n\nWelcome!!!Select your choice\n\n\nSelect 1 to order food\nEnter 2 to order extra bed\nEnter 4 to exit\n");
            int choice = sc.nextInt();
            switch(choice){
                case 1:
                    orderFood();
                    break;
                case 2:
                    orderExtraBeds();
                    break;
                default:
                    break;
            }
        }
    } // method is used to call roomService where related methods will be called.
    public void orderFood() {

    } // method is used to order food services to that room and add the amount to otherServicesRate.
    abstract void viewAvailableFacilities();// abstract method, as the availability of facilities changes for different rooms and there is no need to implement this method in general class Room.
    abstract int calculateRoomRent(); //abstract method, as the rent differ for each room based on the facilities and the implementation of calculating the rent is hidden.
}
