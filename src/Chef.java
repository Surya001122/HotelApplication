public class Chef extends Employee{
    private int chefId; // stores the chef id
    private Menu menu; // chef has menu reference and checks the food availability and has the action of changing the menu details
    public Chef(String employeeName)
    {
        super(employeeName);
    }

    public int getChefId() {
        return chefId;
    }

    public void setChefId(int chefId) {
        this.chefId = chefId;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public void changeMenu(){} // method is used to change the menu
}
