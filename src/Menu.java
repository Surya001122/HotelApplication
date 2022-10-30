import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Menu {
    Scanner sc ;
    HashMap<String,String> foodItems;
    public Menu() {
        sc = new Scanner(System.in);
        foodItems = new HashMap<>();
    }
    public void displayMenu(){
        for(HashMap.Entry<String,String> menu : foodItems.entrySet()){
            System.out.println("\nItem : "+menu.getKey()+"Price : "+menu.getValue());
        }
    }
    public void changeMenu(){
        displayMenu();
        System.out.println("Enter 1 to remove an item\nEnter 2 to add an item\nEnter 3 to exit\n\n");
        int choice = sc.nextInt();
        String foodItem,foodPrice;
        switch(choice){
            case 1:
                System.out.print("\nEnter the item to remove : ");
                foodItem = sc.next();
                foodItems.remove(foodItem);
                break;
            case 2:
                System.out.print("\nEnter the item to add : ");
                foodItem = sc.next();
                System.out.print("\nEnter the price : ");
                foodPrice = sc.next();
                foodItems.put(foodItem,foodPrice);
                System.out.println("New item added...");
                break;
            default:
                break;
        }
    }
}
