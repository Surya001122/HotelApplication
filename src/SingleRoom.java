// SingleRoom is a type of RoomType(is a relationship)
public class SingleRoom extends Room{
    public SingleRoom(int roomNumber, String roomType, int floorNumber, int roomMobileNumber) {
        super(roomNumber, roomType, floorNumber, roomMobileNumber);
    }@Override
    public void displayAvailableFacilities() {}
    @Override
    public int calculateRoomRent() {return 1;}
}
