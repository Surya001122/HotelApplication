// DeluxeRoom is a type of RoomType(is a relationship)

public class DeluxeRoom extends Room{
    private boolean hasTV; // boolean status to check whether the deluxeroom has tv
    private boolean hasAC; // boolean status to check whether the deluxeroom has ac
    private boolean hasGeyser; // boolean status to check whether the deluxeroom has heater
    private boolean hasWIFI; // boolean status to check whether the deluxeroom has wifi availability
    private boolean hasBalcony; // boolean status to check whether the deluxeroom has balcony
    private boolean hasSwimmingPool; // boolean status to check whether the deluxeroom has pool
    private boolean hasMassageParlour; // boolean status to check whether the deluxeroom has parlour
    private boolean hasMiniBar; // boolean status to check whether the deluxeroom has minibar

    public DeluxeRoom(int roomNumber,int floorNumber)
    {
        super(roomNumber,floorNumber);
    }

    public boolean hasTV() {
        return hasTV;
    }

    public void setHasTV(boolean hasTV) {
        this.hasTV = hasTV;
    }

    public boolean hasAC() {
        return hasAC;
    }

    public void setHasAC(boolean hasAC) {
        this.hasAC = hasAC;
    }

    public boolean hasGeyser() {
        return hasGeyser;
    }

    public void setHasGeyser(boolean hasGeyser) {
        this.hasGeyser = hasGeyser;
    }

    public boolean hasWIFI() {
        return hasWIFI;
    }

    public void setHasWIFI(boolean hasWIFI) {
        this.hasWIFI = hasWIFI;
    }

    public boolean hasBalcony() {
        return hasBalcony;
    }

    public void setHasBalcony(boolean hasBalcony) {
        this.hasBalcony = hasBalcony;
    }

    public boolean hasSwimmingPool() {
        return hasSwimmingPool;
    }

    public void setHasSwimmingPool(boolean hasSwimmingPool) {
        this.hasSwimmingPool = hasSwimmingPool;
    }

    public boolean hasMassageParlour() {
        return hasMassageParlour;
    }

    public void setHasMassageParlour(boolean hasMassageParlour) {
        this.hasMassageParlour = hasMassageParlour;
    }

    public boolean isHasMiniBar() {
        return hasMiniBar;
    }

    public void setHasMiniBar(boolean hasMiniBar) {
        this.hasMiniBar = hasMiniBar;
    }
}
