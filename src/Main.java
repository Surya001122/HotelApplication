import com.sun.xml.internal.ws.server.SingletonResolver;
import jdk.internal.cmm.SystemResourcePressureImpl;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        Date date1 = new Date("27 10 2022");
//        Date date2 = new Date("28 11 2022");
//        System.out.println(date2.getDay()-date1.getDay());
        LocalDate date1 = LocalDate.of(2022, 10, 26);
        LocalDate date2 = date1.with(Month.NOVEMBER).withDayOfMonth(04);
        int numDays = Period.between(date1, date2).getDays();
        System.out.println("Number of days between two dates = "+numDays);
        System.exit(1);
        HashMap<String,String>usersLoginInfo = new HashMap<>();
        Hotel hotel = new Hotel("KFC","Chennai","54321","KFC@gmail.com");
        Admin admin = new Admin("admin1","ADMIN","admin12345");
        admin.setHotel(hotel);
        Customer customer = new Customer("customer1","Surya","Male","Chennai","1234567890","customer12345");
        usersLoginInfo.put(admin.getAdminId(), admin.getAdminPassword());
        usersLoginInfo.put(customer.getCustomerId(),customer.getCustomerPassword());
        Room singleRoom = new SingleRoom(1,"Single",1,1);
        Room doubleRoom = new DoubleRoom(2,"Double",1,2);
        Room deluxeRoom = new DeluxeRoom(3,"Deluxe",1,3);
        admin.getHotel().customers.add(customer);
        boolean bool = true;
        System.out.println("Start Application.......\n");
        while(bool)
        {
            System.out.print("\n1.Customer Login\n2.Admin Login\n\n\nEnter your choice : ");
            int login = sc.nextInt();
            switch(login) {
                case 1:
                    System.out.println("\nEnter your CustomerId : ");
                    String customerId = sc.next();
                    System.out.println("\nEnter your password : ");
                    String customerPassword = sc.next();
                    if (usersLoginInfo.containsKey(customerId) && usersLoginInfo.containsValue(customerPassword)) {
                        System.out.println("Customer Logged In Successfully");
                        boolean customerRun = true;
                        while (customerRun) {
                            System.out.print("Enter 1 to Display Available Rooms\nEnter 2 to book Rooms\n\n\nEnter your choice : ");
                            int customerChoice = sc.nextInt();
                            switch (customerChoice) {
                                case 1:
                                    admin.getHotel().displayAllAvailableRooms();
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
                                            booker.createBooking(customer, room);
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
                                    booker.displayBookingDetails();
                                    admin.addBookings(booker);
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
                case 2:
                    System.out.println("\nEnter your loginId : ");
                    String adminId = sc.next();
                    System.out.println("\nEnter your password : ");
                    String adminPassword = sc.next();
                    if (usersLoginInfo.containsKey(adminId) && usersLoginInfo.containsValue(adminPassword)) {
                        System.out.println("Admin Logged In Successfully");
                        boolean adminRun = true;
                        while(adminRun){
                            System.out.print("\nEnter 1 to add rooms in hotel\nEnter 2 to add customers in hotel\n\n\nEnter your choice : ");
                            int adminChoice = sc.nextInt();
                            switch(adminChoice){
                                case 1:

                                    break;
                                case 2:
                                    admin.getHotel().addCustomers(customer);
                                    break;
                                default:
                                    adminRun = false;
                                    break;
                            }
                        }
                    }
                    else
                    {
                        System.out.println("\nAdmin entered wrong Id and Password...Please try again...");
                    }
                    break;
                default:
                    bool = false;
                    break;
            }
        }
    }
}