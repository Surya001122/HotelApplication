import java.sql.Array;
import java.util.ArrayList;
class Hotel {
    private String hotelName; // stores the name of the hotel
    private String hotelAddress; // stores the address of the hotel
    private String mobileNo; // stores the mobile number of the hotel
    private String email_id; // stores the mailId of the hotel
    private int totalFloors; // stores the total floors present in a hotel;
    private Manager manager; // Hotel has Manager
    ArrayList<String> Location = new ArrayList<>(); // stores the different location in which the hotel is present
    ArrayList<Room> rooms = new ArrayList<>(); // Hotel has Rooms(has a relationship)
    ArrayList<Employee> employees = new ArrayList<>(); // Hotel has Employees (has a relationship)

    ArrayList<Customer> customers = new ArrayList<>(); // stores the customers in the hotel
    private int rating; // stores the rating of the hotel;
    public Hotel(String hotelName, String hotelAddress, String mobileNo, String email_id) {
        this.hotelName = hotelName;
        this.hotelAddress = hotelAddress;
        this.mobileNo = mobileNo;
        this.email_id = email_id;
    }
    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getHotelAddress() {
        return hotelAddress;
    }

    public void setHotelAddress(String hotelAddress) {
        this.hotelAddress = hotelAddress;
    }

    public int getTotalFloors() {
        return totalFloors;
    }

    public void setTotalFloors(int totalFloors) {
        this.totalFloors = totalFloors;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }
    public ArrayList<String> getLocation() {
        return Location;
    }

    public void addLocation(String location) {
        Location.add(location);
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getEmail_id() {
        return email_id;
    }

    public void setEmail_id(String email_id) {
        this.email_id = email_id;
    }

    public ArrayList<Room> getRooms() { return rooms; }
    public void addRooms(Room room) {
        rooms.add(room);
    }
    public void deleteRooms(Room room) {
        rooms.remove(room);
    }
    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void addEmployees(Employee employee) {
        employees.add(employee);
    }
    public void deleteEmployees(Employee employee) {
        employees.remove(employee);
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public void addCustomers(Customer customer) {} // method is used to add the new customers in the hotel
    public void getAvailableRooms() {} // method which gets the available rooms in the hotel
}
