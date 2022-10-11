import java.util.ArrayList;

public class HotelBooking {

    private int bookingId; // stores the booking id
    private String fromDate; // initial date of the customer arrival in hotel
    private String toDate; // final date of the customer in hotel
    ArrayList<Room> bookedRooms = new ArrayList<>(); // stores the booked rooms in a hotel
    ArrayList<Integer> reservedDays = new ArrayList<>(); // represents the total days, the room will be reserved

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public ArrayList<Room> getBookedRooms() {
        return bookedRooms;
    }

    public void addBookedRooms(Room bookedRoom) {
        bookedRooms.add(bookedRoom);
    }

    public ArrayList<Integer> getReservedDays() {
        return reservedDays;
    }

    public void addReservedDays(int totalDays) {
        reservedDays.add(totalDays);
    }

    public void createBooking(Customer customer) {} // to create the booking of the customer
    public void cancelBooking(Customer customer) {} // to cancel or checkout customer from hotel
    public int calculateTotalDays(String fromDate,String toDate){return 1;} // to calculate total days the customer stays in the hotel
    public void getBookingDetails() {} // to get the booking details
}
