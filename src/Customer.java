import java.util.ArrayList;

public class Customer {
    private int customer_id; // stores the id of the customer
    private Order order; // stores the reference of the order

    private Payment payment; // stores the reference of the payment
    private String name; //stores the customer name
    private String gender; // stores the gender of the customer
    private String address; // stores the address of the customer
    private String phone_no; // stores the phone number of the customer
    ArrayList<Room> customerBookedRooms = new ArrayList<>(); // Customer can have  many rooms.Customer has bookedRooms(has a relationship)

    public Customer(int customer_id, String name, String gender, String address, String phone_no) {
        this.customer_id = customer_id;
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.phone_no = phone_no;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }

    public ArrayList<Room> getCustomerRooms() {
        return customerBookedRooms;
    }

    public void addCustomerRooms(Room room) {
        customerBookedRooms.add(room);
    }

}
