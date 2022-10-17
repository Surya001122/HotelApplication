import java.util.ArrayList;
import java.util.HashMap;
public abstract class Room {
    private String customerId; // stores the customerId.
    private int roomNumber; // stores the room_number.
    private String roomType; // stores the type of the room.
    private int floorNumber; // stores the floorNumber of the room.
    private boolean roomStatus; // indicates whether the room is vacant or occupied.
    private int totalBeds; // stores the number of beds the room has in it.
    private int weekDayRate; // stores the rent of the room from mon to fri.
    private int weekEndRate; // stores the rent of the room in weekends.
    private int otherServicesRate; // stores the amount of other services to that room.
    private int roomMobileNumber; // stores the room's mobileNumber.
    private static int roomServiceNumber = 123; // stores the room service number.
    private static String wifiName; // common to all rooms
    private static String wifiPassword; // common to all rooms
    private HashMap<String,String> Guests; // stores the guestId and guestName in the room.
    private HashMap<String,Integer> PantryItems; // stores the quantity of item and the food item used in pantry.
    // Integer part represents the quantity of food item initiallly.
    public Room(int roomNumber, int floorNumber) {
        this.roomNumber = roomNumber;
        this.floorNumber = floorNumber;
        Guests = new HashMap<>();
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

    public int getWeekDayRate() {
        return weekDayRate;
    }

    public void setWeekDayRate(int weekDayRate) {
        this.weekDayRate = weekDayRate;
    }

    public int getWeekEndRate() {
        return weekEndRate;
    }

    public void setWeekEndRate(int weekEndRate) {
        this.weekEndRate = weekEndRate;
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

    public int getRoomServiceNumber() {
        return roomServiceNumber;
    }

    public void setRoomServiceNumber(int roomServiceNumber) {
        this.roomServiceNumber = roomServiceNumber;
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

    public HashMap<String, String> getGuests() {
        return Guests;
    }
    public void addGuests(String guestId, String guestName) {
        Guests.put(guestId,guestName);
    }

    public HashMap<String,Integer> getPantryItems() {
        return PantryItems;
    }

    public void addPantryItems(String pantryItem,int quantity) {
        PantryItems.put(pantryItem,quantity);
    }
    public void bookRoom() {} // method is used to change the status of the boolean type roomStatus to true to indicate that ths room is now occupied.
    public void cancelBooking() {} // method is used to change the status of the boolean type roomStatus to false to indicate that the room is now vacant.
    public void displayRoomInfo() {} // method is used to display the room details.
    public void displayGuestInfo() {} // method is used to display the guest info in that particular room.
    public void orderExtraBeds() {} // method is used to order extra beds after checking if that beds can be accomodated on that roomtype and the totalBeds variable will be increased.
    public void callRoomService() {} // method is used to call roomService where related methods will be called.
    public void orderFood() {} // method is used to order food services to that room and add the amount to otherServicesRate.
    public void replaceDefectedItems() {} // method is used to replace the beds and other electrical appliances if it is defected
    public int calculateFoodOrdersAmount() {return 1;}
    abstract void displayAvailableFacilities();// abstract method, as the availability of facilities changes for different rooms and there is no need to implement this method in general class Room.
    abstract int calculateRoomRent(); //abstract method, as the rent differ for each room based on the facilities and the implementation of calculating the rent is hidden.
}
