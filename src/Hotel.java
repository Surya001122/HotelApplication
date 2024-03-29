import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.Callable;

class Hotel {
    private String hotelName;
    private String hotelAddress;
    private String hotelMobileNumber;
    private String hotelEmailId;
    private String hotelLandmark;
    private int totalFloors;
    ArrayList<String> hotelLocations;
    ArrayList<Room> rooms;
    ArrayList<Customer> customers;
    ArrayList<HotelBooking> bookings;
    ArrayList<Employee> employees;
    private int hotelRating;
    public Hotel(String hotelName, String hotelAddress, String hotelMobileNumber, String hotelEmailId,String hotelLandmark,int totalFloors) {
        this.hotelName = hotelName;
        this.hotelAddress = hotelAddress;
        this.hotelMobileNumber = hotelMobileNumber;
        this.hotelEmailId = hotelEmailId;
        this.hotelLandmark = hotelLandmark;
        this.totalFloors = totalFloors;
        rooms = new ArrayList<>();
        customers = new ArrayList<>();
        bookings = new ArrayList<>();
        employees = new ArrayList<>();
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

    public ArrayList<String> getHotelLocations() {
        return hotelLocations;
    }

    public void addLocation(String location) {
        hotelLocations.add(location);
    }

    public String getHotelMobileNumber() {
        return hotelMobileNumber;
    }

    public void setHotelMobileNumber(String hotelMobileNumber) {
        this.hotelMobileNumber = hotelMobileNumber;
    }

    public String getHotelEmailId() {
        return hotelEmailId;
    }

    public void setHotelEmailId(String hotelEmailId) {
        this.hotelEmailId = hotelEmailId;
    }

    public String getHotelLandmark() {
        return hotelLandmark;
    }

    public void setHotelLandmark(String hotelLandmark) {
        this.hotelLandmark = hotelLandmark;
    }

    public int getHotelRating() {
        return hotelRating;
    }

    public void setHotelRating(int hotelRating) {
        this.hotelRating = hotelRating;
    }
    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(ArrayList<Customer> customers) {
        this.customers = customers;
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }
    public void addRooms(Room room){
        rooms.add(room);
    }
    public void addCustomers(Customer customer){
        customers.add(customer);
    }
    public void removeCustomers(Customer customer){
        customers.remove(customer);
    }
    public void addEmployees(Employee employee){
        employees.add(employee);
    }
    public void removeEmployees(Employee employee){
        employees.remove(employee);
    }
    public void displayAllAvailableRooms() {
        for(Room room:rooms){
            if(!room.getRoomStatus())
            System.out.println("\nRoom number : "+room.getRoomNumber()+"     Room type : "+room.getRoomType());
        }
    }
    public int totalAvailableRooms(){

        int availableRooms = 0;
        for(Room room:rooms){
            if(!room.getRoomStatus())
                availableRooms+=1;
        }
        return availableRooms;
    }
    public Room getRoom(String roomType,int roomNumber){
        for(Room room:rooms){
            if(room.getRoomNumber()==roomNumber && room.getRoomType().equals(roomType))
                return room;
        }
        return null;
    }
    public Customer getCustomer(String customerId,String customerPassword){
        for(Customer customer:customers){
            if(customer.getCustomerId().equals(customerId) && customer.getCustomerPassword().equals(customerPassword))
                return customer;
        }
        return null;
    }
    public Employee getEmployee(String employeeId,String employeePassword){
        for(Employee employee:employees){
            if(employee.getEmployeeId().equals(employeeId) && employee.getEmployeePassword().equals(employeePassword))
                return employee;
        }
        return null;
    }
    public HotelBooking getBooking(Customer customer){
        for(HotelBooking booking:bookings){
            if(booking.getCustomerId().equals(customer.getCustomerId())){
                return booking;
            }
        }
        HotelBooking booking = new HotelBooking(customer.getCustomerId(), customer.getCustomerName(),customer.getCustomerPhoneNumber());
        this.bookings.add(booking);
        return booking;
    }
}
