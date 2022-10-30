import java.util.*;
public class Manager extends Employee {
    private Hotel hotel;
    String employeeId,employeePassword,customerId,customerPassword;
    Scanner sc;

    public Manager(String employeeId, String employeeName, String employeePassword) {
        super(employeeId, employeeName, employeePassword);
        sc = new Scanner(System.in);
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
    public void addCustomers(){
        System.out.print("\nEnter CustomerID : ");
        customerId = sc.next();
        System.out.print("\nEnter CustomerPassword : ");
        customerPassword = sc.next();
        Customer customer = this.hotel.getCustomer(customerId,customerPassword);
        if(customer!=null){
            this.hotel.addCustomers(customer);
            System.out.println("\nCustomer added in hotel");
        }
        else{
            System.out.println("\nYou have entered wrong id and password...Please try again...");
        }
    }
    public void removeCustomers() {
        System.out.print("\nEnter CustomerID : ");
        customerId = sc.next();
        System.out.print("\nEnter CustomerPassword : ");
        customerPassword = sc.next();
        Customer customer = this.hotel.getCustomer(customerId,customerPassword);
        if(customer!=null){
            this.hotel.removeCustomers(customer);
            System.out.println("\nCustomer removed from hotel");
        }
        else{
            System.out.println("\nYou have entered wrong id and password...Please try again...");
        }
    }
    public void addEmployees(){
        System.out.print("\nEnter EmployeeID : ");
        employeeId = sc.next();
        System.out.print("\nEnter EmployeePassword : ");
        employeePassword = sc.next();
        Employee employee = this.hotel.getEmployee(employeeId,employeePassword);
        if(employee!=null){
            this.hotel.addEmployees(employee);
            System.out.println("\nEmployee added in hotel");
        }
        else{
            System.out.println("\nYou have entered wrong id and password...Please try again...");
        }
    }
    public void removeEmployees(){
        System.out.print("\nEnter EmployeeID : ");
        employeeId = sc.next();
        System.out.print("\nEnter EmployeePassword : ");
        employeePassword = sc.next();
        Employee employee = this.hotel.getEmployee(employeeId,employeePassword);
        if(employee!=null){
            this.hotel.removeEmployees(employee);
            System.out.println("\nEmployee removed from hotel");

        }
        else{
            System.out.println("\nYou have entered wrong id and password...Please try again...");
        }
    }
}
