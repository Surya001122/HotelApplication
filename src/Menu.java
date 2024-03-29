import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Menu {
    Scanner sc ;
    HashMap<String,Integer> foodItems;
    public Menu() {
        sc = new Scanner(System.in);
        foodItems = new HashMap<>();
    }
    public void displayMenu(){
        for(HashMap.Entry<String,Integer> menu : foodItems.entrySet()){
            System.out.println("\nItem: "+menu.getKey()+"  Price: "+menu.getValue());
        }
    }
    public void changeMenu(){
        displayMenu();
        System.out.print("\n\nEnter 1 to remove an item\nEnter 2 to add an item\nEnter 3 to exit\n\n\nEnter your choice :");
        int choice,foodPrice;
        try {
            choice = Integer.parseInt(sc.nextLine().trim());
        }
        catch(NumberFormatException numberFormatException){
            System.out.println("Enter valid option...Try again...");
            return;
        }
        String foodItem;
        switch(choice){
            case 1:
                System.out.print("\nEnter the item to remove : ");
                foodItem = sc.nextLine().trim();
                foodItems.remove(foodItem);
                System.out.println("\nItem removed from menu...");
                break;
            case 2:
                System.out.print("\nEnter the item to add : ");
                foodItem = sc.nextLine().trim();
                System.out.print("\nEnter the price : ");
                try {
                    foodPrice = Integer.parseInt(sc.nextLine().trim());
                }
                catch(NumberFormatException numberFormatException){
                    System.out.println("Enter valid option...Try again...");
                    return;
                }
                foodItems.put(foodItem,foodPrice);
                System.out.println("\nNew item added to the menu...");
                break;
            default:
                break;
        }
    }
}
