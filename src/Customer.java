import java.util.*;
public class Customer {
    Scanner sc;
    private String customerId;
    private String customerName;
    private String gender;
    private String customerAddress;
    private String customerPhoneNumber;
    private String customerPassword;
    private boolean paymentStatus;
    public Customer(String customerId, String customerName, String gender, String customerAddress, String customerPhoneNumber, String customerPassword) {
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

    public boolean getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(boolean paymentStatus) {
        this.paymentStatus = paymentStatus;
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
        sc = new Scanner(System.in);
        System.out.println("Enter your id : " );
        String id = sc.next();
        System.out.print("Enter your old Password : ");
        String oldPassword = sc.next();
        if(id.equals(this.customerId) && oldPassword.equals(this.customerPassword)){
            System.out.print("\nEnter your new password : ");
            String newPassword = sc.next();
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
}
