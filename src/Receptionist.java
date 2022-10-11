public class Receptionist extends Employee{
    private int receptionistId; // stores the receptionist id

    private Bill bill; // stores the reference of the bill
    public Receptionist(String employeeName)
    {
        super(employeeName);
    }

    public int getReceptionistId() {
        return receptionistId;
    }

    public void setReceptionistId(int receptionistId) {
        this.receptionistId = receptionistId;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public void generateBill(Customer customer){} // method is used to generate bill by assigning the customer's order obj to bill's order obj
}
