import java.util.ArrayList;
import java.util.HashMap;

public class Chef extends Employee{
    private Menu menu;
    public Chef(String employeeId, String employeeName, String employeePassword) {
        super(employeeId, employeeName, employeePassword);

    }
    public Menu getMenu() {
        return menu;
    }
    public void setMenu(Menu menu) {
        this.menu = menu;
    }
    public void displayMenu(){
        menu.displayMenu();
    }
    public void changeMenu(){
        menu.changeMenu();
    }
    public int takeOrder(HashMap<String,Integer> orders)
    {
        int totalAmount = 0;
        for(String itemName:orders.keySet()){
            if(menu.foodItems.containsKey(itemName)){
                totalAmount += menu.foodItems.get(itemName)*orders.get(itemName);
            }
        }
        System.out.println("\nYour order is placed...");
        return totalAmount;
    }
}
