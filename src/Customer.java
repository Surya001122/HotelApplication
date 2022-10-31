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
    public void callRoomService(Customer customer,HotelBooking booker,Chef chef)
    {
        System.out.print("\nEnter 1 to make a foodOrder\nEnter 2 to order beds\n\nEnter your choice : ");
        int choice,roomNumber;
        try {
            choice = sc.nextInt();
        }
        catch(NumberFormatException numberFormatException){
            System.out.println("Enter valid option...Try again..");
            return;
        }
        String roomType;
        Room room = null;
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
                for(Room bookedRoom : booker.getBookedRooms()){
                    if(bookedRoom.getRoomNumber()==roomNumber && bookedRoom.getRoomType().equals(roomType)){
                        room = bookedRoom;
                        break;
                    }
                }
                if(room != null){
                    boolean orderRun = true;
                    int orderChoice;
                    HashMap<String,Integer>orders = new HashMap<>();
                    while(orderRun){
                        System.out.print("\nEnter 1 to continue adding food items\nEnter 2 to place order\nEnter 3 to exit\n\n\nEnter your choice : ");
                        try {
                            orderChoice = sc.nextInt();
                        }
                        catch(NumberFormatException numberFormatException){
                            System.out.println("Enter valid option...Please try again..");
                            continue;
                        }
                        switch(orderChoice){
                            case 1:
                                System.out.print("\nEnter the food Item : ");
                                String foodItem = sc.nextLine().trim();
                                System.out.print("\nEnter the quantity : ");
                                int foodQuantity;
                                try {
                                    foodQuantity = Integer.parseInt(sc.nextLine().trim());
                                }
                                catch(NumberFormatException numberFormatException){
                                    System.out.println("Enter valid option...");
                                    break;
                                }
                                orders.put(foodItem,foodQuantity);
                                break;
                            case 2:
                                System.out.println("\nOrder completed...");
                                booker.setFoodOrdersAmount(chef.takeOrder(orders));
                                booker.setPaymentStatus(true);
                                booker.viewMyBill();
                                booker.setPaymentStatus(customer.payBill(booker.getFoodOrdersAmount()));
                                if(!booker.getPaymentStatus()) {
                                    booker.setFoodOrdersAmount(0);
                                    booker.viewMyBill();
                                }
                                break;
                            default:
                                orderRun = false;
                                break;
                        }
                    }
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
//                if(roomType)
//                {
//
//                }
//                else{
//                    System.out.println("Please enter valid room information...Please try again...");
//                }
                break;
            default:
                break;
        }
    }
    public boolean payBill(int billAmount){
        System.out.println("\nEnter 1 to pay the amount\nEnter 2 to cancel payment\n\n\nEnter your choice");
        boolean paymentStatus;
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
