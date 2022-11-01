import com.sun.org.apache.xpath.internal.operations.Bool;

import java.sql.Array;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;
public class HotelBooking {
    Scanner sc;
    static int id = 1;
    static int guestId = 1;
    private int bookingId; // stores the booking id for an individual customer.
    private String customerId; // to indicate that this hotelbooking object belongs to that customer.
    private String customerName; // stores the name of the customer.
    private String customerPhoneNumber; // stores the mobile number of the customer.
    private int billAmount;
    private int foodOrdersAmount;
    private int otherServicesAmount;
    HashMap<Integer,String> guests; // stores the guestId and guestName in the rooms booked...includes the person's name and person's id accompanying the customers.
    ArrayList<Room> bookedRooms; // Integer represents the days at which the room will be in occupied status.....Room represents the total rooms booked by the customer.
    private boolean paymentStatus;

    public HotelBooking(String customerId,String customerName,String customerPhoneNumber) {
        this.bookingId = id++;
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerPhoneNumber = customerPhoneNumber;
        guests = new HashMap<>();
        bookedRooms = new ArrayList<>();
        billAmount = 0;
        foodOrdersAmount = 0;
        otherServicesAmount = 0;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
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

    public String getCustomerPhoneNumber() {
        return customerPhoneNumber;
    }

    public void setCustomerPhoneNumber(String customerPhoneNumber) {
        this.customerPhoneNumber = customerPhoneNumber;
    }

    public int getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(int billAmount) {
        this.billAmount = billAmount;
    }

    public int getFoodOrdersAmount() {
        return foodOrdersAmount;
    }

    public void setFoodOrdersAmount(int foodOrdersAmount) {
        this.foodOrdersAmount = foodOrdersAmount;
    }

    public int getOtherServicesAmount() {
        return otherServicesAmount;
    }

    public void setOtherServicesAmount(int otherServicesAmount) {
        this.otherServicesAmount = otherServicesAmount;
    }

    public boolean getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(boolean paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public HashMap<Integer, String> getGuests() {
        return guests;
    }

    public void addGuests(int guestId, String guestName) {
        guests.put(guestId,guestName);
    }


    public ArrayList<Room> getBookedRooms() {
        return bookedRooms;
    }

    public void setBookedRooms(ArrayList<Room> bookedRooms) {
        this.bookedRooms = bookedRooms;
    }

    public void addBookedRooms(Room bookedRoom) {
        bookedRooms.add(bookedRoom);
    }
    public void displayAvailableRooms(Hotel hotel){
        hotel.displayAllAvailableRooms();
    }
    public void createBooking(Customer customer,Hotel hotel) {
        sc = new Scanner(System.in);
        System.out.println("Total rooms available : "+hotel.totalAvailableRooms());
        System.out.println("Enter number of rooms for booking : ");
        int totalRooms;
        try {
            totalRooms = Integer.parseInt(sc.nextLine().trim());
        }
        catch(NumberFormatException numberFormatException){
            System.out.println("Enter valid option.Please try again...");
            return;
        }
        ArrayList<Room> rooms = new ArrayList<>();
        ArrayList<Integer> daysList = new ArrayList<>();
        HashMap<Integer,String> otherCustomers = new HashMap<>();
        if(totalRooms <= hotel.totalAvailableRooms())
        {
            while (totalRooms > 0) {
                System.out.println("\n\nThe available rooms are : ");
                hotel.displayAllAvailableRooms();
                System.out.print("\n\n\nEnter room type : ");
                String roomType = sc.nextLine().trim();
                System.out.print("\nEnter room number : ");
                int roomNumber;
                try {
                    roomNumber = Integer.parseInt(sc.nextLine().trim());
                }
                catch(NumberFormatException numberFormatException){
                    System.out.println("Enter valid option.Please try again...");
                    continue;
                }
                Room room = hotel.getRoom(roomType, roomNumber);
                if (room == null || room.getRoomStatus()) {
                    System.out.println("Enter valid room information....\n");
                } else {
                    room.displayRoomInfo();
                    room.viewAvailableFacilities();
                    try{
                        System.out.print("\nEnter fromDate : ");
                        String fromDate = sc.nextLine().trim();
                        System.out.print("\nEnter toDate : ");
                        String toDate = sc.nextLine().trim();
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                        LocalDate Date1 = LocalDate.parse(fromDate,formatter);
                        LocalDate Date2 = LocalDate.parse(toDate,formatter);
                        Period period = Period.between(Date1, Date2);
                        int months =(int)period.toTotalMonths();
                        int days = Math.abs(period.getDays());
                        daysList.add(months*30+days);
                    }
                    catch (DateTimeParseException dateTimeParseException){
                        System.out.println("\nEnter valid date..Please try again...");
                        continue;
                    }
                    rooms.add(room);
                    System.out.println("\nEnter guest details : \n");
                    System.out.println("\nEnter total guests : ");
                    int guests;
                    try {
                        guests = Integer.parseInt(sc.nextLine().trim());
                    }
                    catch(NumberFormatException numberFormatException){
                        System.out.println("Enter valid option...");
                        continue;
                    }
                    while (guests > 0) {
                        System.out.print("\nEnter guest name :");
                        String guestName = sc.nextLine().trim();
                        otherCustomers.put(guestId++, guestName);
                        guests--;
                    }
                    totalRooms--;
                    this.paymentStatus = true;
                }
            }
            for(Room room : rooms){
                room.setTotalDays(daysList.get(0));
                daysList.remove(0);
                this.billAmount += room.calculateRoomRent();
                viewMyBill();
            }
            System.out.println("\nEnter 1 to pay the bill Amount\nEnter 2 to exit\n\n\nEnter your choice");
            int paymentChoice = sc.nextInt();
            switch(paymentChoice){
                case 1:
                    paymentStatus = customer.payBill(billAmount);
                    break;
                case 2:
                    System.out.println("Booking cancelled...");
                    break;
                default:
                    System.out.println("Booking cancelled...Enter valid option...");
                    break;
            }
            if(!this.paymentStatus)
            {
                this.bookedRooms.addAll(rooms);
                this.guests.putAll(otherCustomers);
                this.customerId = customer.getCustomerId();
                this.customerName = customer.getCustomerName();
                this.customerPhoneNumber = customer.getCustomerPhoneNumber();
                for(Room room:bookedRooms) {
                    room.bookRoom(customer);
                }
                this.billAmount = 0;
                this.paymentStatus = false;
                viewMyBill();
            }
        }
        else
        {
            System.out.println("\nSorry...Please try again!!! Your requirement is not satisfied");
        }
    }
    public void cancelBooking(Hotel hotel) {
        sc = new Scanner(System.in);
        System.out.println("\n\nEnter 1 to cancel all rooms\nEnter 2 to cancel certain rooms\nEnter 3 to exit\n");
        int choice;
        try {
            choice = Integer.parseInt(sc.nextLine().trim());
        }
        catch(NumberFormatException numberFormatException){
            System.out.println("Enter valid option...");
            return;
        }
        switch(choice){
            case 1:
                this.viewMyRooms();
                for(Room room:bookedRooms){
                    this.billAmount+= room.calculateOtherServices();
                    this.billAmount+= room.calculateFoodOrdersAmount();
                    room.cancelBooking();
                }
                bookedRooms.clear();
                guests.clear();

                System.out.println("\nBooking cancelled...");
                break;
            case 2:
                Boolean repeat = true;
                int roomNumber;
                while(repeat) {
                    System.out.println("\nEnter 1 to continue cancel booking\nEnter 2 to exit\n");
                    choice = Integer.parseInt(sc.nextLine().trim());
                    switch(choice){
                        case 1:
                            this.viewMyRooms();
                            System.out.println("\nEnter 1 to continue cancel booking\nEnter 2 to exit\n");
                            System.out.println("Enter the roomNumber to cancel : ");
                            try {
                                roomNumber = Integer.parseInt(sc.nextLine().trim());
                            }
                            catch (NumberFormatException numberFormatException){
                                System.out.println("Enter valid room number...");
                                break;
                            }
                            System.out.println("Enter the roomType to cancel : ");
                            String roomType = sc.nextLine().trim();
                            Room room = hotel.getRoom(roomType,roomNumber);
                            if (bookedRooms.contains(room)) {
                                this.billAmount+= room.calculateOtherServices();
                                this.billAmount+= room.calculateFoodOrdersAmount();
                                room.cancelBooking();
                                bookedRooms.remove(room);
                            } else {
                                System.out.println("Enter valid room information..Please try again...");
                            }
                            break;
                        case 2:
                            repeat = false;
                            break;
                        default:
                            System.out.println("Enter valid option...");
                            break;
                    }
                }
                break;
            case 3:
                System.out.println("\nBooking not cancelled...");
                break;
            default:
                System.out.println("Invalid option...");
                break;
        }
    }
    public void viewMyGuests() {
        if(guests.size()>0) {
            System.out.println("\n\n\nGuest Information\n*********************************");
            for (HashMap.Entry guest : guests.entrySet()) {
                System.out.println("\nGuest id : " + guest.getKey() + "   Guest name : " + guest.getValue());
            }
        }
        else {
            System.out.println("\n\nNo guests available...");
        }

    }
    public void viewMyRooms() {
        if(bookedRooms.size()>0) {
            System.out.println("\nRooms booked by Customer\n*********************************");
            for (Room room : bookedRooms) {
                System.out.println("\nRoom Type : " + room.getRoomType() + "   Room Number : " + room.getRoomNumber()+"  Total Days : "+room.getTotalDays()+"  Room rent for total days : "+room.calculateRoomRent());
            }
        }
        else {
            System.out.println("\n\nYour bookings are empty...");
        }
    }
    public void viewMyBill(){
        System.out.println("\nTotal rent Amount : "+this.billAmount);
        System.out.println("\nTotal foodOrders Amount : "+this.foodOrdersAmount);
        System.out.println("\nTotal otherServices Amount : "+this.otherServicesAmount);
        System.out.println("\nPayment Status : "+(this.paymentStatus?"NOT PAID" : "PAID"));
    }
}
