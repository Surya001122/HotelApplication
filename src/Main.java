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
        Manager manager = new Manager("admin1","ADMIN","admin123");
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
            System.out.print("1.Customer SignIn\n2.Customer Login\n3.Manager Login\n4.Employee Login\n5.Exit\n\n\nEnter your choice : ");
            int login = sc.nextInt();
            switch(login) {
                case 1:
                    System.out.print("\n\nEnter your id : ");
                    String loginId = sc.next();
                    System.out.print("\nEnter your name : ");
                    String name = sc.next();
                    System.out.print("\nEnter your gender : ");
                    String gender = sc.next();
                    System.out.print("\nEnter your location : ");
                    String location = sc.next();
                    System.out.print("\nEnter your mobileNumber : ");
                    String phoneNumber = sc.next();
                    System.out.print("\nEnter your password : ");
                    String password = sc.next();
                    customer = new Customer(loginId,name,gender,location,phoneNumber,password);
                    usersLoginInfo.put(customer.getCustomerId(),customer.getCustomerPassword());
                    hotel.addCustomers(customer);
                    break;
                case 2:
                    System.out.println("\nEnter your CustomerId : ");
                    String customerId = sc.next();
                    if (usersLoginInfo.containsKey(customerId)) {
                        System.out.println("\nEnter your password : ");
                        String customerPassword = sc.next();
                        if(usersLoginInfo.get(customerId).equals(customerPassword))
                        {
                            System.out.println("\n\nCustomer logged in successfully...");
                            boolean customerRun = true;
                            customer = manager.getHotel().getCustomer(customerId,customerPassword);
                            booker = hotel.getBooking(customer);
                            while (customerRun) {
                                System.out.print("\n\n\nEnter 1 to Display Available Rooms\nEnter 2 to book Rooms\nEnter 3 to cancel booking\nEnter 4 to display my room bookings\nEnter 5 to display my guests\nEnter 6 to change my password\nEnter 7 to view Menu\nEnter 8 to call room service\nEnter 9 to view my bill\n\n\n\nEnter your choice : ");
                                int customerChoice = sc.nextInt();
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
                                        customer.callRoomService(hotel,chef,customer);
                                        break;
                                    case 9:
                                        customer.viewMyBill(booker);
                                        break;
                                    default:
                                        customerRun = false;
                                        System.out.println("Logged out successfully...");
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
                    String managerId = sc.next();
                    if (usersLoginInfo.containsKey(managerId)) {
                        System.out.print("\nEnter your ManagerPassword : ");
                        String managerPassword = sc.next();
                        if(usersLoginInfo.get(managerId).equals(managerPassword))
                        {
                            System.out.println("\n\nManager logged in successfully...");
                            boolean managerRun = true;
                            while(managerRun){
                                System.out.print("\nEnter 1 to add Employees in hotel\nEnter 2 to remove Employees from hotel\nEnter 3 to add customers in hotel\nEnter 4 to remove Customers from hotel\nEnter 5 to view customers in hotel\nEnter 6 to view employees in hotel\n\n\nEnter your choice : ");
                                int managerChoice = sc.nextInt();
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
                                    default:
                                        managerRun = false;
                                        System.out.println("Logged out successfully...");
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
                    String employeeId = sc.next();
                    if (usersLoginInfo.containsKey(employeeId)) {
                        System.out.print("\nEnter your EmployeePassword : ");
                        String employeePassword = sc.next();
                        if(usersLoginInfo.get(employeeId).equals(employeePassword))
                        {
                            System.out.println("\n\nEmployee logged in successfully...");
                            boolean employeeRun = true;
                            while(employeeRun){
                                System.out.println("\nEnter 1 to display menu\nEnter 2 to change menu\nEnter 3 to exit\n\n\nEnter your choice :");
                                int employeeChoice = sc.nextInt();
                                switch(employeeChoice){
                                    case 1:
                                        chef.displayMenu();
                                        break;
                                    case 2:
                                        chef.changeMenu();
                                        break;
                                    default:
                                        employeeRun = false;
                                        System.out.println("Logged out successfully...");
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