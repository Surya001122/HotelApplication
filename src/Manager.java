public class Manager extends Employee {
    private Hotel hotel;

    public Manager(String employeeId, String employeeName, String employeePassword) {
        super(employeeId, employeeName, employeePassword);
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
    public void removeCustomers(Customer customer) {this.hotel.removeCustomers(customer); }
    public void addEmployees(Employee employee){
        this.hotel.addEmployees(employee);
    }
    public void removeEmployees(Employee employee){
        this.hotel.removeEmployees(employee);
    }
}
