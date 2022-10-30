import java.util.ArrayList;

public class Admin {
    private String adminId;
    private String adminName;
    private String adminPassword;
    private Hotel hotel;
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

    public void addBookings(HotelBooking booking){
        this.hotel.bookings.add(booking);
    }
    public void displayAvailableRooms(){
        this.hotel.displayAllAvailableRooms();
    }
    public void addCustomers(Customer customer){
        this.hotel.addCustomers(customer);
    }
    public void removeCustomers(Customer customer) {this.hotel.addCustomers(customer); }
    public void addRooms(Room room){
        this.hotel.addRooms(room);
    }
}
