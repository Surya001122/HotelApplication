public class Payment {
    private int paymentId; // stores the payment id
    private String paymentType; // represents the payment mode(cash or card)
    private Bill bill; // payment depends on bill & payment cannot exist without bill(composition)
    private boolean paymentStatus; // status of the payment (paid or not paid)

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public boolean isPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(boolean paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public void payBill(){
        // change the boolean value of paymentStatus;
    } // method is used to pay the bill by getting the bill obj and assigning to payment's bill obj
}
