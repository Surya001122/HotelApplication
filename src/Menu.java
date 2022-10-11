import java.util.ArrayList;

public class Menu {
    ArrayList<Integer> foodIds = new ArrayList<>(); // stores the ids of the food
    ArrayList<String> foodItems = new ArrayList<>(); // stores the name of the food Items
    ArrayList<Integer> itemsAmount = new ArrayList<>(); // stores the amount of the foodItems

    public ArrayList<Integer> getFoodIds() {
        return foodIds;
    }

    public void addFoodIds(int foodId) {
        foodIds.add(foodId);
    }

    public ArrayList<String> getFoodItems() {
        return foodItems;
    }

    public void addFoodItems(ArrayList<String> foodItems) {
        this.foodItems = foodItems;
    }

    public ArrayList<Integer> getItemAmount() {
        return itemsAmount;
    }

    public void addItemAmount(Integer itemAmount) {
        itemsAmount.add(itemAmount);
    }

    public void displayMenu() {} // method is used to display the menu for teh customer
}
