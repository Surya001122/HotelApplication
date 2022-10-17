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
    private String roomMobileNumber; // stores the room's mobileNumber.
    private HashMap<String,String> Guests; // stores the guestId and guestName in the room.
    private HashMap<Integer,String> PantryItems; // stores the quantity of item used and the food item used in pantry.
    // Initially Integer part is zero for all items and the count increases after using that particular item.
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

    public String getRoomMobileNumber() {
        return roomMobileNumber;
    }
    public void setRoomMobileNumber(String roomMobileNumber) {
        this.roomMobileNumber = roomMobileNumber;
    }

    public HashMap<String, String> getGuests() {
        return Guests;
    }
    public void addGuests(String guestId, String guestName) {
        Guests.put(guestId,guestName);
    }

    public HashMap<Integer, String> getPantryItems() {
        return PantryItems;
    }

    public void addPantryItems(String pantryItem) {
        PantryItems.put(0,pantryItem); // 0 represents the count of pantryItem used by the person in that room.
    }

    public void bookRoom() {} // method is used to change the status of the boolean type roomStatus to true to indicate that ths room is now occupied.
    public void cancelBooking() {} // method is used to change the status of the boolean type roomStatus to false to indicate that the room is now vacant.
    public void displayRoomInfo() {} // method is used to display the room details.
    public void displayGuestInfo() {} // method is used to display the guest info in that particular room.
    public void orderExtraBeds() {} // method is used to order extra beds if it is needed and the totalBeds variable will be increased.
    public void orderFood() {} // method is used to order food services to that room and add the amount to otherServicesRate.
    public void replaceDefectedItems() {} // method is used to replace the beds and other electrical appliances if it is defected
    public int calculateFoodOrdersAmount() {return 1;}
    abstract void displayAvailableFacilities();// abstract method, as the availability of facilities changes for different rooms and there is no need to implement this method in general class Room.
    abstract int calculateRoomRent(); //abstract method, as the rent differ for each room based on the facilities and the implementation of calculating the rent is hidden.
    abstract int calculateAmountForPantryItems(); // abstract method, as the pantry items used varies for different rooms.
}
