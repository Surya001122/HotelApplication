import java.util.ArrayList;

public class Admin {
    private String adminId;
    private String adminName;
    private String adminPassword;
    private Hotel hotel;
    ArrayList<HotelBooking> bookings = new ArrayList<>();
    public Admin(String adminId, String adminName, String adminPassword) {
        this.adminId = adminId;
        this.adminName = adminName;
        this.adminPassword = adminPassword;
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public ArrayList<HotelBooking> getBookings() {
        return bookings;
    }
    public void setBookings(ArrayList<HotelBooking> bookings) {
        this.bookings = bookings;
    }
}
