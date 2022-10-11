// SingleRoom is a type of RoomType(is a relationship)
public class SingleRoom extends Room{
    private boolean hasTV; // boolean status to check whether the deluxeroom has tv
    public SingleRoom(int roomNumber,int floorNumber)
    {
        super(roomNumber,floorNumber);
    }

    public boolean isHasTV() {
        return hasTV;
    }
    public void setHasTV(boolean hasTV) { this.hasTV = hasTV; }
}
