// DoubleRoom is a type of RoomType(is a relationship)

class DoubleRoom extends Room{
    public DoubleRoom(int roomNumber, String roomType, int floorNumber, int roomMobileNumber) {
        super(roomNumber, roomType, floorNumber, roomMobileNumber);
    }

    @Override
    public void displayAvailableFacilities() {}
    @Override
    public int calculateRoomRent() {return 1;}
}
