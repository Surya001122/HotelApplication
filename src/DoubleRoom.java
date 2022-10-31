// DoubleRoom is a type of RoomType(is a relationship)

import java.util.HashMap;

class DoubleRoom extends Room{
    public DoubleRoom(int roomNumber, String roomType, int floorNumber, int totalBeds, int rent, int roomMobileNumber) {
        super(roomNumber, roomType, floorNumber, totalBeds, rent, roomMobileNumber);
    }
    @Override
    public void viewAvailableFacilities() {
        System.out.println("\n\nFACILITIES : \n\nDOUBLE COT\nAIR CONDITIONING\nTELIVISION\nGEYSER\n");
    }
    @Override
    public int calculateRoomRent() {
        return this.getRent() * this.getTotalDays();
    }
}
