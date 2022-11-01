import java.util.*;
public class Manager extends Employee {
    private Hotel hotel;
    String employeeId,employeePassword,customerId,customerPassword;
    Scanner sc;
    public Manager(String employeeId, String employeeName, String employeePassword,String employeeAddress,String employeePhoneNumber) {
        super(employeeId, employeeName, employeePassword,employeeAddress,employeePhoneNumber);
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
    public void addCustomers(HashMap<String,String>usersLoginInfo){
        System.out.print("\nEnter CustomerID : ");
        customerId = sc.nextLine().trim();
        System.out.print("\nEnter CustomerPassword : ");
        customerPassword = sc.nextLine().trim();
        Customer customer = this.hotel.getCustomer(customerId,customerPassword);
        if(customer!=null){
            this.hotel.addCustomers(customer);
            usersLoginInfo.put(customerId,customerPassword);
            System.out.println("\nCustomer added in hotel");
        }
        else{
            System.out.println("\nYou have entered wrong id and password...Please try again...");
        }
    }
    public void removeCustomers(HashMap<String,String>usersLoginInfo) {
        System.out.print("\nEnter CustomerID : ");
        customerId = sc.nextLine().trim();
        System.out.print("\nEnter CustomerPassword : ");
        customerPassword = sc.nextLine().trim();
        Customer customer = this.hotel.getCustomer(customerId,customerPassword);
        if(customer!=null){
            this.hotel.removeCustomers(customer);
            usersLoginInfo.remove(customerId,customerPassword);
            System.out.println("\nCustomer removed from hotel");
        }
        else{
            System.out.println("\nYou have entered wrong id and password...Please try again...");
        }
    }
    public void addEmployees(HashMap<String, String> usersLoginInfo){
        System.out.print("\nEnter EmployeeID : ");
        employeeId = sc.nextLine().trim();
        System.out.print("\nEnter EmployeePassword : ");
        employeePassword = sc.nextLine().trim();
        Employee employee = this.hotel.getEmployee(employeeId,employeePassword);
        if(employee!=null){
            this.hotel.addEmployees(employee);
            System.out.println("\nEmployee added in hotel");
            usersLoginInfo.put(employeeId,employeePassword);
        }
        else{
            System.out.println("\nYou have entered wrong id and password...Please try again...");
        }
    }
    public void removeEmployees(HashMap<String,String>usersLoginInfo){
        System.out.print("\nEnter EmployeeID : ");
        employeeId = sc.nextLine().trim();
        System.out.print("\nEnter EmployeePassword : ");
        employeePassword = sc.nextLine().trim();
        Employee employee = this.hotel.getEmployee(employeeId,employeePassword);
        if(employee!=null){
            this.hotel.removeEmployees(employee);
            usersLoginInfo.remove(employeeId,employeePassword);
            System.out.println("\nEmployee removed from hotel");

        }
        else{
            System.out.println("\nYou have entered wrong id and password...Please try again...");
        }
    }
    public void viewCustomers(HashMap<String,String>usersLoginInfo)
    {
        System.out.println("1.View certain Customer\n2.View all Customers\n\n\nEnter your choice :");
        int viewCustomerChoice = 0;
        try{
            viewCustomerChoice = Integer.parseInt(sc.nextLine().trim());
        }
        catch(NumberFormatException numberFormatException){
            System.out.println("Enter valid option...");
            return;
        }
        switch(viewCustomerChoice){
            case 1:
                System.out.print("\nEnter CustomerID : ");
                customerId = sc.nextLine().trim();
                System.out.print("\nEnter CustomerPassword : ");
                customerPassword = sc.nextLine().trim();
                Customer customer = this.hotel.getCustomer(customerId,customerPassword);
                if(customer!=null){
                    System.out.println("\nCustomer ID : "+customer.getCustomerId()+"  Customer Name : "+customer.getCustomerName()+"  Customer Password : "+customer.getCustomerPassword()+"  CustomerNumber : "+customer.getCustomerPhoneNumber());
                }
                else{
                    System.out.println("\nYou have entered wrong id and password...Please try again...");
                    return;
                }
            case 2:
                for(Customer cus : hotel.customers){
                    System.out.println("\nEmployee ID : "+cus.getCustomerId()+"  Employee Name : "+cus.getCustomerName()+"  Employee Password : "+cus.getCustomerPassword());
                }
                break;
            default:
                System.out.println("\nEnter valid option...Try again");
                break;
        }
    }
    public void viewEmployees(HashMap<String,String>usersLoginInfo)
    {
        System.out.println("1.View certain employee\n2.View all employees\n\n\nEnter your choice :");
        int viewEmpChoice = 0;
        try{
            viewEmpChoice = Integer.parseInt(sc.nextLine().trim());
        }
        catch(NumberFormatException numberFormatException){
            System.out.println("Enter valid option...");
            return;
        }

        switch(viewEmpChoice){
            case 1:
                System.out.print("\nEnter EmployeeID : ");
                employeeId = sc.nextLine().trim();
                System.out.print("\nEnter EmployeePassword : ");
                employeePassword = sc.nextLine().trim();
                Employee employee = this.hotel.getEmployee(employeeId,employeePassword);
                if(employee!=null){
                    System.out.println("\nEmployee ID : "+employee.getEmployeeId()+"  Employee Name : "+employee.getEmployeeName()+"  Employee Password : "+employee.getEmployeePassword());
                }
                else{
                    System.out.println("\nYou have entered wrong id and password...Please try again...");
                    return;
                }
                break;
            case 2:
                for(Employee emp : hotel.employees){
                    System.out.println("\nEmployee ID : "+emp.getEmployeeId()+"  Employee Name : "+emp.getEmployeeName()+"  Employee Password : "+emp.getEmployeePassword());
                }
                break;
            default:
                System.out.println("\nEnter valid option...Try again");
                break;
        }

    }
}
