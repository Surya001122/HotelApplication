import com.sun.xml.internal.ws.server.SingletonResolver;
import jdk.internal.cmm.SystemResourcePressureImpl;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String,String>usersLoginInfo = new HashMap<>();
        Hotel hotel = new Hotel("KFC","Chennai","54321","KFC@gmail.com");
        Admin admin = new Admin("admin1","ADMIN","admin12345");
        admin.setHotel(hotel);
        Customer customer;
        HotelBooking booker;
        usersLoginInfo.put(admin.getAdminId(), admin.getAdminPassword());
        Room room1 = new SingleRoom(1,"Single",1,1,100,1);
        Room room2 = new DoubleRoom(2,"Double",1,2,200,2);
        Room room3 = new DeluxeRoom(3,"Deluxe",1,3,300,3);
        Room room4 = new SingleRoom(4,"Single",1,1,100,4);
        Room room5 = new DoubleRoom(5,"Double",1,2,200,5);
        Room room6 = new DeluxeRoom(6,"Deluxe",1,3,300,6);
        admin.addRooms(room1);
        admin.addRooms(room2);
        admin.addRooms(room3);
        admin.addRooms(room4);
        admin.addRooms(room5);
        admin.addRooms(room6);
        boolean bool = true;
        System.out.println("Start Application.......\n");
        while(bool)
        {
            System.out.print("1.Customer SignIn\n2.Customer Login\n3.Admin Login\n4.Exit\n\n\nEnter your choice : ");
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
                    admin.addCustomers(customer);
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
                            customer = admin.getHotel().getCustomer(customerId,customerPassword);
                            booker = hotel.getBooking(customer);
                            while (customerRun) {
                                System.out.print("\n\n\nEnter 1 to Display Available Rooms\nEnter 2 to book Rooms\nEnter 3 to cancel booking\nEnter 4 to display my room bookings\nEnter 5 to display my guests\nEnter 6 to change my password\nEnter 8 to call Room Service\n\n\nEnter your choice : ");
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
                                        customer.viewMyBill(booker);
                                        break;
                                    case 8:
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
                default:
                    bool = false;
                    break;
            }
        }
    }
}