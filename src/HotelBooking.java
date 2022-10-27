import java.time.LocalDate;
import java.util.*;
public class HotelBooking {
    static int id = 1;
    static int guestId = 1;
    private int bookingId; // stores the booking id for an individual customer.
    private String customerId; // to indicate that this hotelbooking object belongs to that customer.
    private String customerName; // stores the name of the customer.
    private String customerPhoneNumber; // stores the mobile number of the customer.
    HashMap<Integer,String> Guests; // stores the guestId and guestName in the rooms booked...includes the person's name and person's id accompanying the customers.
    HashMap<Room,Integer> bookedRooms; // Integer represents the days at which the room will be in occupied status.....Room represents the total rooms booked by the customer.

    public HotelBooking() {
        this.bookingId = id++;
        Guests = new HashMap<>();
        bookedRooms = new HashMap<>();
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerPhoneNumber() {
        return customerPhoneNumber;
    }

    public void setCustomerPhoneNumber(String customerPhoneNumber) {
        this.customerPhoneNumber = customerPhoneNumber;
    }

    public HashMap<Integer, String> getGuests() {
        return Guests;
    }

    public void addGuests(int guestId, String guestName) {
        Guests.put(guestId,guestName);
    }

    public HashMap<Room, Integer> getBookedRooms() {
        return bookedRooms;
    }

    public void setBookedRooms(HashMap<Room, Integer> bookedRooms) {
        this.bookedRooms = bookedRooms;
    }

    public void addBookedRooms(int days, Room bookedRoom) {
        bookedRooms.put(bookedRoom,days);
    }
    public void createBooking(Customer customer,Room room) {
        this.customerId = customer.getCustomerId();
        this.customerName = customer.getCustomerName();
        this.customerPhoneNumber = customer.getCustomerPhoneNumber();
        bookedRooms.put(room,1);
        room.bookRoom(customer);
    } // to create the booking of the customer
    public void cancelBooking(Customer customer) {
        this.customerId = null;
        this.customerName = null;
        this.customerPhoneNumber = null;
    } // to cancel or checkout customer from hotel
    public void addGuests(String guestName,Room room){
        Guests.put(guestId,guestName);
        room.addGuests(guestId++,guestName);
    }
    public void displayGuestDetails() {
        System.out.println("\n\n\nGuest Information :");
        for(HashMap.Entry Guest : Guests.entrySet()){
            System.out.println("\nGuest id : "+Guest.getKey()+"\nGuest name : "+Guest.getValue());
        }
        System.out.println("***************************************");
    } // to get the guestDetails accompanied with the customer.
    public void displayRoomDetails(){
        System.out.println("\nRooms booked by Customer\n*********************************");
        for(HashMap.Entry Rooms : bookedRooms.entrySet()) {
            Room room = (Room) Rooms.getKey();
            System.out.println("Total Number of Occupied days : " + Rooms.getValue() + "\nRoom type : " + room.getRoomType()+"\n****************************************");
        }
        displayGuestDetails();
    }
    public void displayBookingDetails() {
        System.out.print("\nBooking id : "+this.bookingId+"\nCustomer id : "+this.customerId+"\nCustomer name : "+this.customerName+"\nCustomer phoneNumber :"+this.customerPhoneNumber);
        this.displayRoomDetails();
    } // method is used to display booking details of a customer
}
