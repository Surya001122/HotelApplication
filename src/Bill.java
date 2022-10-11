public class Bill {
    private int billId; // stores the billId
    private Order order; // bill depends on order & bill cannot exist without order(composition)

    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
    public int calculateBill() {return 1;} // this method returns the amount to be paid by the customer.
}
