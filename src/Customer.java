import java.util.*;
public class Customer {
    Scanner sc;
    private String customerId;
    private String customerName;
    private String gender;
    private String customerAddress;
    private String customerPhoneNumber;
    private String customerPassword;
    public Customer(String customerId, String customerName, String gender, String customerAddress, String customerPhoneNumber, String customerPassword) {
        sc = new Scanner(System.in);
        this.customerId = customerId;
        this.customerName = customerName;
        this.gender = gender;
        this.customerAddress = customerAddress;
        this.customerPhoneNumber = customerPhoneNumber;
        this.customerPassword = customerPassword;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerPhoneNumber() {
        return customerPhoneNumber;
    }

    public void setCustomerPhoneNumber(String customerPhoneNumber) {
        this.customerPhoneNumber = customerPhoneNumber;
    }
    public String getCustomerPassword() {
        return customerPassword;
    }
    public void setCustomerPassword(String customerPassword) {
        this.customerPassword = customerPassword;
    }
    public void displayAvailableRooms(HotelBooking booker, Hotel hotel){
        booker.displayAvailableRooms(hotel);
    }
    public void createBooking(HotelBooking booker,Hotel hotel){
        booker.createBooking(hotel.getCustomer(this.customerId,this.customerPassword),hotel);
    }
    public void cancelBooking(HotelBooking booker,Hotel hotel){
        booker.cancelBooking(hotel);
    }
    public void viewMyRooms(HotelBooking booker){
        booker.viewMyRooms();
    }
    public void viewMyGuests(HotelBooking booker){
        booker.viewMyGuests();
    }
    public String changeMyPassword(){
        System.out.println("Enter your id : " );
        String id = sc.nextLine().trim();
        System.out.print("Enter your old Password : ");
        String oldPassword = sc.nextLine().trim();
        if(id.equals(this.customerId) && oldPassword.equals(this.customerPassword)){
            System.out.print("\nEnter your new password : ");
            String newPassword = sc.nextLine().trim();
            this.setCustomerPassword(newPassword);
        }
        else{
            System.out.println("\nYour password is wrong...");
        }
        return oldPassword;
    }
    public void viewMyBill(HotelBooking booker){
        booker.viewMyBill();
    }
    public void callRoomService(Hotel hotel,Chef chef,Customer customer)
    {
        System.out.print("\nEnter 1 to make a foodOrder\nEnter 2 to order beds\n\nEnter your choice : ");
        int choice,roomNumber;
        choice = Integer.parseInt(sc.nextLine().trim());
        String roomType;
        Room room;
        switch(choice)
        {
            case 1:
                System.out.print("\nEnter room Number : ");
                try {
                    roomNumber = Integer.parseInt(sc.nextLine().trim());
                }
                catch(NumberFormatException numberFormatException){
                    System.out.println("Enter valid option...Try again...");
                    break;
                }
                System.out.print("\nEnter the room Type : ");
                roomType = sc.nextLine().trim();
                room = hotel.getRoom(roomType,roomNumber);
                if(room!=null && hotel.getBooking(customer).bookedRooms.contains(room)){
                    room.placeOrder(chef);
                }
                else{
                    System.out.println("Please enter valid room information...Please try again...");
                }
                break;
            case 2:
                System.out.print("\nEnter room Number : ");
                try {
                    roomNumber = Integer.parseInt(sc.nextLine().trim());
                }
                catch(NumberFormatException numberFormatException){
                    System.out.println("Enter valid option...Try again...");
                    break;
                }
                System.out.print("\nEnter the room Type : ");
                roomType = sc.nextLine().trim();
                room = hotel.getRoom(roomType,roomNumber);
                if(room!=null && hotel.getBooking(customer).bookedRooms.contains(room)){
                    System.out.println("\nExtra bed added to room...");
                    room.orderExtraBeds();
                }
                else{
                    System.out.println("Please enter valid room information...Please try again...");
                }
                break;
            default:
                break;
        }
    }
    public boolean payBill(int billAmount,boolean paymentStatus){
        System.out.println("\nEnter 1 to pay the amount\nEnter 2 to cancel payment\n\n\nEnter your choice");
        int paymentChoice = sc.nextInt();
        switch(paymentChoice){
            case 1:
                System.out.println("\nPayment successful..");
                paymentStatus = false;
                break;
            case 2:
                System.out.println("\nPayment cancelled...");
                paymentStatus = true;
                break;
            default:
                System.out.println("\nEnter valid option...");
                paymentStatus = true;
                break;
        }
        return paymentStatus;
    }
}
