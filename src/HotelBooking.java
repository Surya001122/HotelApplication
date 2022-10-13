import java.time.LocalDate;
import java.util.*;
public class HotelBooking {
    private String bookingId; // stores the booking id for an individual customer.
    private String customerId; // to indicate that this hotelbooking object belongs to that customer.
    private String customerName; // stores the name of the customer.
    private String customerPhoneNumber; // stores the mobile number of the customer.
    private Date fromDate; // stores the initial date of the customer in the hotel.
    private Date toDate; // stores the final date of the customer in the hotel.
    private int totalNumberOfAdults; // stores the total number of adults.
    private int totalNumberOfChildren; // stores the total number of children.
    private int totalNightsStay; // stores the total night stay of the person in the room.
    HashMap<String,String> Guests; // stores the guestId and guestName in the rooms booked...includes the person's name and person's id accompanying the customers.
    HashMap<Integer,Room> bookedRooms; // Integer represents the days at which the room will be in occupied status.....Room represents the total rooms booked by the customer.

    public HotelBooking()
    {
        Guests = new HashMap<>();
        bookedRooms = new HashMap<>();
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
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

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public int getTotalNumberOfAdults() {
        return totalNumberOfAdults;
    }

    public void setTotalNumberOfAdults(int totalNumberOfAdults) {
        this.totalNumberOfAdults = totalNumberOfAdults;
    }

    public int getTotalNumberOfChildren() {
        return totalNumberOfChildren;
    }

    public void setTotalNumberOfChildren(int totalNumberOfChildren) {
        this.totalNumberOfChildren = totalNumberOfChildren;
    }

    public int getTotalNightsStay() {
        return totalNightsStay;
    }

    public void setTotalNightsStay(int totalNightsStay) {
        this.totalNightsStay = totalNightsStay;
    }

    public HashMap<String, String> getGuests() {
        return Guests;
    }

    public void addGuests(String guestId, String guestName) {
        Guests.put(guestId,guestName);
    }

    public HashMap<Integer, Room> getBookedRooms() {
        return bookedRooms;
    }

    public void addBookedRooms(Integer days, Room bookedRoom) {
        bookedRooms.put(days,bookedRoom);
    }
    public void createBooking(Customer customer) {} // to create the booking of the customer
    public void cancelBooking(Customer customer) {} // to cancel or checkout customer from hotel
    public void getGuestDetails(Customer customer) {} // to get the guestDetails accompanied with the customer
    public int calculateTotalDays(String fromDate,String toDate){return 1;} // to calculate total days the customer stays in the hotel
    public void displayBookingDetails() {} // method is used to display booking details of a customer
}
