// SingleRoom is a type of RoomType(is a relationship)
public class SingleRoom extends Room{
    private boolean hasTV; // boolean status to check whether the singleroom has tv
    public SingleRoom(int roomNumber, int floorNumber, boolean hasTV) {
        super(roomNumber, floorNumber);
        this.hasTV = hasTV;
    }
    public boolean isHasTV() {
        return hasTV;
    }
    public void setHasTV(boolean hasTV) { this.hasTV = hasTV; }
    @Override
    public void displayAvailableFacilities() {};
}
