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
}
