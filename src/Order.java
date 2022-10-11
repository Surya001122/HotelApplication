import java.sql.Array;
import java.util.ArrayList;

public class Order {
    private int orderId; // stores the id of the order
    ArrayList<String> orderedItems = new ArrayList<>(); //stores the ordered items of the customer
    ArrayList<Integer> quantities = new ArrayList<>(); // stores the quantity of the items ordered

    ArrayList<Integer> itemsPrice = new ArrayList<>(); // stores the amount of the food

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public ArrayList<String> getOrderedItems() {
        return orderedItems;
    }

    public void setOrderedItems(ArrayList<String> orderedItems) {
        this.orderedItems = orderedItems;
    }

    public ArrayList<Integer> getQuantities() {
        return quantities;
    }

    public void setQuantities(ArrayList<Integer> quantities) {
        this.quantities = quantities;
    }
}