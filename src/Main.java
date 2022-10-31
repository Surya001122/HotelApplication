import com.sun.xml.internal.ws.server.SingletonResolver;
import jdk.internal.cmm.SystemResourcePressureImpl;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String,String>usersLoginInfo = new HashMap<>();
        Hotel hotel = new Hotel("KFC","Chennai","54321","KFC@gmail.com");
        Manager manager = new Manager("manager1","MANAGER","manager123");
        Chef chef = new Chef("chef1","CHEF","chef123");
        Menu menu = new Menu();
        menu.foodItems.put("Pizza",100);
        menu.foodItems.put("Burger",200);
        chef.setMenu(menu);
        hotel.addEmployees(chef);
        hotel.addEmployees(manager);
        manager.setHotel(hotel);
        Customer customer;
        HotelBooking booker;
        usersLoginInfo.put(manager.getEmployeeId(), manager.getEmployeePassword());
        usersLoginInfo.put(chef.getEmployeeId(), chef.getEmployeePassword());
        Room room1 = new SingleRoom(1,"Single",1,1,100,1);
        Room room2 = new DoubleRoom(2,"Double",1,2,200,2);
        Room room3 = new DeluxeRoom(3,"Deluxe",1,3,300,3);
        Room room4 = new SingleRoom(4,"Single",1,1,100,4);
        Room room5 = new DoubleRoom(5,"Double",1,2,200,5);
        Room room6 = new DeluxeRoom(6,"Deluxe",1,3,300,6);
        hotel.addRooms(room1);
        hotel.addRooms(room2);
        hotel.addRooms(room3);
        hotel.addRooms(room4);
        hotel.addRooms(room5);
        hotel.addRooms(room6);
        boolean bool = true;
        System.out.println("Start Application.......\n");
        while(bool)
        {
            System.out.print("1.Customer SignUp\n2.Customer Login\n3.Manager Login\n4.Employee Login\n5.Exit\n\n\nEnter your choice : ");
            int login;
            try{
                login = Integer.parseInt(sc.nextLine().trim());
            }
            catch(NumberFormatException numberFormatException){
                System.out.println("Enter valid option...");
                continue;
            }
            switch(login) {
                case 1:
                    System.out.print("\n\nEnter your id : ");
                    String loginId = sc.nextLine().trim();
                    System.out.print("\nEnter your name : ");
                    String name = sc.nextLine().trim();
                    System.out.print("\nEnter your gender : ");
                    String gender = sc.nextLine().trim();
                    System.out.print("\nEnter your location : ");
                    String location = sc.nextLine().trim();
                    System.out.print("\nEnter your mobileNumber : ");
                    String phoneNumber = sc.nextLine().trim();
                    System.out.print("\nEnter your password : ");
                    String password = sc.nextLine().trim();
                    if(usersLoginInfo.containsKey(loginId)){
                        System.out.println("User already exists..Please log in..");
                    }
                    else {
                        customer = new Customer(loginId, name, gender, location, phoneNumber, password);
                        usersLoginInfo.put(customer.getCustomerId(), customer.getCustomerPassword());
                        hotel.addCustomers(customer);
                    }
                    break;
                case 2:
                    System.out.println("\nEnter your CustomerId : ");
                    String customerId = sc.nextLine().trim();
                    if (usersLoginInfo.containsKey(customerId)) {
                        System.out.println("\nEnter your password : ");
                        String customerPassword = sc.nextLine().trim();
                        if(usersLoginInfo.get(customerId).equals(customerPassword))
                        {
                            System.out.println("\n\nCustomer logged in successfully...");
                            boolean customerRun = true;
                            customer = manager.getHotel().getCustomer(customerId,customerPassword);
                            booker = hotel.getBooking(customer);
                            while (customerRun) {
                                System.out.print("\n\n\nEnter 1 to Display Available Rooms\nEnter 2 to book Rooms\nEnter 3 to cancel booking\nEnter 4 to display my room bookings\nEnter 5 to display my guests\nEnter 6 to change my password\nEnter 7 to view Menu\nEnter 8 to call room service\nEnter 9 to view my bill\nEnter 10 to exit\n\n\n\nEnter your choice : ");
                                int customerChoice;
                                try {
                                    customerChoice = Integer.parseInt(sc.nextLine().trim());
                                }
                                catch(NumberFormatException numberFormatException){
                                    System.out.println("Enter valid option...");
                                    continue;
                                }
                                switch (customerChoice) {
                                    case 1:
                                        customer.displayAvailableRooms(booker,hotel);
                                        break;
                                    case 2:
                                        customer.createBooking(booker,hotel);
                                        break;
                                    case 3:
                                        customer.cancelBooking(booker,hotel);
                                        break;
                                    case 4:
                                        customer.viewMyRooms(booker);
                                        break;
                                    case 5:
                                        customer.viewMyGuests(booker);
                                        break;
                                    case 6:
                                        String oldPassword = customer.changeMyPassword();
                                        usersLoginInfo.replace(customer.getCustomerId(),oldPassword,customer.getCustomerPassword());
                                        break;
                                    case 7:
                                        chef.displayMenu();
                                        break;
                                    case 8:
                                        customer.callRoomService(customer,hotel.getBooking(customer),chef);
                                        break;
                                    case 9:
                                        customer.viewMyBill(booker);
                                        break;
                                    case 10:
                                        customerRun = false;
                                        System.out.println("Logged out successfully...");
                                        break;
                                    default:
                                        customerRun = false;
                                        System.out.println("Invalid option...");
                                        break;
                                }
                            }
                        }
                        else
                        {
                            System.out.println("\nYou entered wrong password...Please try again...");
                        }
                    }
                    else
                    {
                        System.out.println("\nYour ID does not exist...Please try again...");
                    }
                    break;
                case 3:
                    System.out.print("\nEnter your ManagerID : ");
                    String managerId = sc.nextLine().trim();
                    if (usersLoginInfo.containsKey(managerId)) {
                        System.out.print("\nEnter your ManagerPassword : ");
                        String managerPassword = sc.nextLine().trim();
                        if(usersLoginInfo.get(managerId).equals(managerPassword))
                        {
                            System.out.println("\n\nManager logged in successfully...");
                            boolean managerRun = true;
                            while(managerRun){
                                System.out.print("\nEnter 1 to add Employees in hotel\n" +
                                        "Enter 2 to remove Employees from hotel\n" +
                                        "Enter 3 to add customers in hotel\n" +
                                        "Enter 4 to remove Customers from hotel\n" +
                                        "Enter 5 to view customers in hotel\n" +
                                        "Enter 6 to view employees in hotel\n" +
                                        "Enter 7 to exit\n\n\n" +
                                        "Enter your choice : ");
                                int managerChoice;
                                try{
                                    managerChoice = Integer.parseInt(sc.nextLine().trim());
                                }
                                catch(NumberFormatException numberFormatException){
                                    System.out.println("Enter valid option...");
                                    continue;
                                }
                                switch(managerChoice){
                                    case 1:
                                        manager.addEmployees(usersLoginInfo);
                                        break;
                                    case 2:
                                        manager.removeEmployees(usersLoginInfo);
                                        break;
                                    case 3:
                                        manager.addCustomers(usersLoginInfo);
                                        break;
                                    case 4:
                                        manager.removeCustomers(usersLoginInfo);
                                        break;
                                    case 5:
                                        manager.viewEmployees();
                                        break;
                                    case 6:
                                        manager.viewCustomers();
                                        break;
                                    case 7:
                                        managerRun = false;
                                        System.out.println("Logged out successfully...");
                                        break;
                                    default:
                                        managerRun = false;
                                        System.out.println("Invalid option...");
                                        break;
                                }
                            }
                        }
                        else
                        {
                            System.out.println("\nYou entered wrong password...Please try again...");
                        }
                    }
                    else
                    {
                        System.out.println("\nYour ID does not exist...Please try again...");
                    }
                    break;
                case 4:
                    System.out.print("\nEnter your EmployeeID : ");
                    String employeeId = sc.nextLine().trim();
                    if (usersLoginInfo.containsKey(employeeId)) {
                        System.out.print("\nEnter your EmployeePassword : ");
                        String employeePassword = sc.nextLine().trim();
                        if(usersLoginInfo.get(employeeId).equals(employeePassword))
                        {
                            System.out.println("\n\nEmployee logged in successfully...");
                            boolean employeeRun = true;
                            while(employeeRun){
                                System.out.println("\nEnter 1 to display menu\nEnter 2 to change menu\nEnter 3 to exit\n\n\nEnter your choice :");
                                int employeeChoice;
                                try{
                                    employeeChoice = Integer.parseInt(sc.nextLine().trim());
                                }
                                catch(NumberFormatException numberFormatException){
                                    System.out.println("Enter valid option...");
                                    continue;
                                }
                                switch(employeeChoice){
                                    case 1:
                                        chef.displayMenu();
                                        break;
                                    case 2:
                                        chef.changeMenu();
                                        break;
                                    case 3:
                                        employeeRun = false;
                                        System.out.println("Logged out successfully...");
                                        break;
                                    default:
                                        employeeRun = false;
                                        System.out.println("Invalid option...");
                                        break;
                                }
                            }
                        }
                        else
                        {
                            System.out.println("\nYou entered wrong password...Please try again...");
                        }
                    }
                    else
                    {
                        System.out.println("\nYour ID does not exist...Please try again...");
                    }
                    break;
                default:
                    bool = false;
                    break;
            }
        }
    }
}