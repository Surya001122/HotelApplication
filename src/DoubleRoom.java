// DoubleRoom is a type of RoomType(is a relationship)

class DoubleRoom extends Room{
    public DoubleRoom(int roomNumber, int floorNumber) {
        super(roomNumber, floorNumber);
    }
    @Override
    public void displayAvailableFacilities() {}
    @Override
    public int calculateRoomRent() {return 1;}
    @Override
    public int calculateFoodOrdersAmount() {return 1;}
    @Override
    public int calculateItemsUsedInPantry() {return 1;}
}
