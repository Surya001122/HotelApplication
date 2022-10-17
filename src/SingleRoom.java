// SingleRoom is a type of RoomType(is a relationship)
public class SingleRoom extends Room{
    public SingleRoom(int roomNumber, int floorNumber) {
        super(roomNumber, floorNumber);
    }
    @Override
    public void displayAvailableFacilities() {}
    @Override
    public int calculateRoomRent() {return 1;}
}
