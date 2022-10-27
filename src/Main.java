import com.sun.xml.internal.ws.server.SingletonResolver;
import jdk.internal.cmm.SystemResourcePressureImpl;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String,String>usersLoginInfo = new HashMap<>();
        Hotel hotel = new Hotel("KFC","Chennai","54321","KFC@gmail.com");
        Admin admin = new Admin("admin1","ADMIN","admin12345");
        admin.setHotel(hotel);
        usersLoginInfo.put(admin.getAdminId(), admin.getAdminPassword());
        Room room1 = new SingleRoom(1,"Single",1,1);
        Room room2 = new DoubleRoom(2,"Double",1,2);
        Room room3 = new DeluxeRoom(3,"Deluxe",1,3);
        Room room4 = new SingleRoom(4,"Single",1,4);
        Room room5 = new DoubleRoom(5,"Double",1,5);
        Room room6 = new DeluxeRoom(6,"Deluxe",1,6);
        Room room7 = new SingleRoom(7,"Single",1,7);
        admin.addRooms(room1);
        admin.addRooms(room2);
        admin.addRooms(room3);
        admin.addRooms(room4);
        admin.addRooms(room5);
        admin.addRooms(room6);
        admin.addRooms(room7);
        boolean bool = true;
        System.out.println("Start Application.......\n");
        while(bool)
        {
            System.out.print("1,Customer SignIn\n2.Customer Login\n3.Admin Login\n\n\nEnter your choice : ");
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
                    Customer customer = new Customer(loginId,name,gender,location,phoneNumber,password);
                    usersLoginInfo.put(customer.getCustomerId(),customer.getCustomerPassword());
                    admin.addCustomers(customer);
                    break;
                case 2:
                    System.out.println("\nEnter your CustomerId : ");
                    String customerId = sc.next();
                    System.out.println("\nEnter your password : ");
                    String customerPassword = sc.next();
                    if (usersLoginInfo.containsKey(customerId) && usersLoginInfo.containsValue(customerPassword)) {
                        System.out.println("Customer Logged In Successfully");
                        boolean customerRun = true;
                        while (customerRun) {
                            System.out.print("Enter 1 to Display Available Rooms\nEnter 2 to book Rooms\nEnter 3 to calculate bill\nEnter 4 to display all bookings\nEnter 5 to logout\n\n\nEnter your choice : ");
                            int customerChoice = sc.nextInt();
                            switch (customerChoice) {
                                case 1:
                                    admin.displayAvailableRooms();
                                    break;
                                case 2:
                                    HotelBooking booker = new HotelBooking();
                                    System.out.println("Enter total number of rooms for booking : ");
                                    int totalRooms = sc.nextInt();
                                    while (totalRooms > 0) {
                                        System.out.print("\nEnter room type : ");
                                        String roomType = sc.next();
                                        System.out.print("\nEnter room number : ");
                                        int roomNumber = sc.nextInt();
                                        System.out.println();
                                        Room room = admin.getHotel().getRoom(roomType, roomNumber);
                                        if (room == null) {
                                            System.out.println("Enter valid room information....\n");
                                            break;
                                        } else {
                                            booker.createBooking(admin.getHotel().getCustomer(customerId,customerPassword), room);
                                            System.out.println("\nEnter guest details : \n");
                                            System.out.println("\nEnter total guests : ");
                                            int guests = sc.nextInt();
                                            while (guests > 0) {
                                                System.out.print("\nEnter guest name :");
                                                String guestName = sc.next();
                                                booker.addGuests(guestName, room);
                                                guests--;
                                            }
                                            System.out.println("Booking successful\n");
                                        }
                                        totalRooms--;
                                    }
                                    if(totalRooms!=0){
                                        System.out.println("Please try again!!!");
                                    }
                                    else{
                                        admin.addBookings(booker);
                                    }
                                    break;
                                case 3:

                                    break;
                                case 4:
                                    admin.displayBookings(customerId,customerPassword);
                                    break;
                                default:
                                    customerRun = false;
                                    break;
                            }
                        }
                    }
                    else
                    {
                        System.out.println("\nCustomer entered wrong Id and Password...Please try again...");
                    }
                    break;
//                case 3:
//                    System.out.println("\nEnter your loginId : ");
//                    String adminId = sc.next();
//                    System.out.println("\nEnter your password : ");
//                    String adminPassword = sc.next();
//                    if (usersLoginInfo.containsKey(adminId) && usersLoginInfo.containsValue(adminPassword)) {
//                        System.out.println("Admin Logged In Successfully");
//                        boolean adminRun = true;
//                        while(adminRun){
//                            System.out.print("\nEnter 1 to remove customers from hotel\nEnter 2 to generate bill for customer\n\n\nEnter your choice : ");
//                            int adminChoice = sc.nextInt();
//                            switch(adminChoice){
//                                case 1:
////                                    usersLoginInfo.put(customer.getCustomerId(),customer.getCustomerPassword());
//                                    break;
//                                default:
//                                    adminRun = false;
//                                    break;
//                            }
//                        }
//                    }
//                    else
//                    {
//                        System.out.println("\nAdmin entered wrong Id and Password...Please try again...");
//                    }
//                    break;
                default:
                    bool = false;
                    break;
            }
        }
    }
}