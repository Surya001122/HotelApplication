// DeluxeRoom is a type of RoomType(is a relationship)

public class DeluxeRoom extends Room{
    public DeluxeRoom(int roomNumber, int floorNumber) {
        super(roomNumber, floorNumber);
    }
    @Override
    public void displayAvailableFacilities() {}
    @Override
    public int calculateRoomRent() {return 1;}
    @Override
    public int calculateAmountForPantryItems() {return 1;}
}
