import com.sun.xml.internal.ws.server.SingletonResolver;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String,String>usersLoginInfo = new HashMap<>();
        Hotel hotel = new Hotel("KFC","Chennai","54321","KFC@gmail.com");
        Admin admin = new Admin("admin1","ADMIN","admin12345");
        Customer customer = new Customer("customer1","Surya","Male","Chennai","1234567890","customer12345");
        usersLoginInfo.put(admin.getAdminId(), admin.getAdminPassword());
        usersLoginInfo.put(customer.getCustomerId(),customer.getCustomerPassword());
        Room singleRoom = new SingleRoom(1,"Single",1,Integer.parseInt("1"));
        Room doubleRoom = new DoubleRoom(2,"Double",1,Integer.parseInt("2"));
        Room deluxeRoom = new DeluxeRoom(3,"Deluxe",1,Integer.parseInt("3"));
        hotel.addRooms(singleRoom);
        hotel.addRooms(doubleRoom);
        hotel.addRooms(deluxeRoom);
        boolean bool = true;
        while(bool)
        {
            System.out.println("\nEnter your loginId : ");
            String loginId = sc.next();
            System.out.println("\nEnter your password : ");
            String loginPassword = sc.next();
            if(usersLoginInfo.containsKey(loginId) && usersLoginInfo.containsValue(loginPassword)){
                System.out.println("Logged In Successfully");
                while (bool) {
                    System.out.println("Enter 1 to Display Available Rooms\n\n\nEnter your choice : ");
                    int choice = sc.nextInt();
                    switch(choice) {
                        case 1:
                            hotel.displayAllRooms();
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
                                Room room = hotel.getRoom(roomType, roomNumber);
                                if (room == null) {
                                    System.out.println("Enter valid room information....\n");
                                } else {
                                    booker.createBooking(customer);
                                    System.out.println("\nEnter guest details : \n");
                                    System.out.println("Enter total guests : ");
                                    int guests = sc.nextInt();
                                    while(guests>0) {
                                        System.out.println("Enter guest name :");
                                        String guestName = sc.next();
                                        booker.addGuests(guestName);
                                        guests--;
                                    }
                                    System.out.println("Booking successful\n");
                                    booker.displayBookingDetails();
                                    totalRooms--;
                                }
                            }
                            break;
                        default:
                            bool = false;
                            break;
                    }
                }
            }
            else{
                System.out.println("\nUser entered wrong Id and Password...Please try again...");
            }
        }
    }
}