import java.util.ArrayList;

public class Manager extends Employee{
    private int managerId; // stores the manager id
    private Hotel hotel; // manager has hotel reference

    public Manager(String name) {
        super(name);
    }

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public void addEmployeesInHotel(){
        // adds the employees in the employee list present in the hotel.
    } //  method in which the manager recruit new Employees for the hotel.
    public void removeEmployeesInHotel(){
        // removes the employees in the employee list present in the hotel.
    } // method in which the manager dismisses the current Employees working in the hotel.
}
