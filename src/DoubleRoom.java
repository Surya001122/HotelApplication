// DoubleRoom is a type of RoomType(is a relationship)

class DoubleRoom extends Room{
    private boolean hasTV; // boolean status to check whether the doubleroom has tv
    private boolean hasAC; // boolean status to check whether the doubleroom has ac
    private boolean hasGeyser; // boolean status to check whether the doubleroom has heater

    public DoubleRoom(int roomNumber, int floorNumber, boolean hasTV, boolean hasAC, boolean hasGeyser) {
        super(roomNumber, floorNumber);
        this.hasTV = hasTV;
        this.hasAC = hasAC;
        this.hasGeyser = hasGeyser;
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
    @Override
    public void displayAvailableFacilities() {};
}
