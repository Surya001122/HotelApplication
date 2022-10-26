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
    HashMap<Integer,Room> bookedRooms; // Integer represents the days at which the room will be in occupied status.....Room represents the total rooms booked by the customer.

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

    public HashMap<Integer, Room> getBookedRooms() {
        return bookedRooms;
    }

    public void addBookedRooms(int days, Room bookedRoom) {
        bookedRooms.put(days,bookedRoom);
    }
    public void createBooking(Customer customer) {
        this.customerId = customer.getCustomerId();
        this.customerName = customer.getCustomerName();
        this.customerPhoneNumber = customer.getCustomerPhoneNumber();
    } // to create the booking of the customer
    public void cancelBooking(Customer customer) {
        this.customerId = null;
        this.customerName = null;
        this.customerPhoneNumber = null;
    } // to cancel or checkout customer from hotel
    public void addGuests(String guestName){
        Guests.put(guestId++,guestName);
    }
    public void getGuestDetails() {
        System.out.println(Guests);
    } // to get the guestDetails accompanied with the customer
    public int calculateTotalDays(String fromDate,String toDate){return 1;} // to calculate total days the customer stays in the hotel
    public void displayBookingDetails() {
        System.out.print("\nBooking id : "+this.bookingId+"\nCustomer id : "+this.customerId+"\nCustomer name : "+this.customerName+"\nCustomer phoneNumber"+this.customerPhoneNumber);
        System.out.println("Rooms booked by Customer \n");
        System.out.println(bookedRooms);
    } // method is used to display booking details of a customer
}
