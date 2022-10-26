// DeluxeRoom is a type of RoomType(is a relationship)

public class DeluxeRoom extends Room{
    public DeluxeRoom(int roomNumber, String roomType, int floorNumber, int roomMobileNumber) {
        super(roomNumber, roomType, floorNumber, roomMobileNumber);
    }

    @Override
    public void displayAvailableFacilities() {}
    @Override
    public int calculateRoomRent() {return 1;}
}
