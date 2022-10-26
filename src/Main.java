import com.sun.xml.internal.ws.server.SingletonResolver;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
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
        admin.getHotel().addRooms(singleRoom);
        admin.getHotel().addRooms(doubleRoom);
        admin.getHotel().addRooms(deluxeRoom);
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
                    System.out.println("Enter 1 to Display Available Rooms\nEnter 2 to book Rooms\n\n\nEnter your choice : ");
                    int choice = sc.nextInt();
                    switch(choice) {
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
                                    booker.createBooking(customer,room);
                                    System.out.println("\nEnter guest details : \n");
                                    System.out.println("\nEnter total guests : ");
                                    int guests = sc.nextInt();
                                    while(guests>0) {
                                        System.out.print("\nEnter guest name :");
                                        String guestName = sc.next();
                                        booker.addGuests(guestName,room);
                                        guests--;
                                    }
                                    System.out.println("Booking successful\n");
                                }
                                totalRooms--;
                            }
                            booker.displayBookingDetails();
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