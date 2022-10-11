public class Server extends Employee{
    private int serverId; // stores the server id
    private Order order; // server has the order reference
    public Server(String employeeName)
    {
        super(employeeName);
    }

    public int getServerId() {
        return serverId;
    }

    public void setServerId(int serverId) {
        this.serverId = serverId;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public void takeOrderFromCustomer(Customer customer){} // method is used to take order from customer and assigns the order obj to customer's order obj
}
