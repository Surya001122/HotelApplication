// DeluxeRoom is a type of RoomType(is a relationship)

import java.util.HashMap;

public class DeluxeRoom extends Room{
    public DeluxeRoom(int roomNumber, String roomType, int floorNumber, int totalBeds, int rent, int roomMobileNumber) {
        super(roomNumber, roomType, floorNumber, totalBeds, rent, roomMobileNumber);
    }

    @Override
    public void viewAvailableFacilities() {
        System.out.println("\n\nFACILITIES : \n\nTRIPLE COT\nAIR CONDITIONING\nTELIVISION\nGEYSER\nMASSAGE SPA\nMINI FRIDGE\nSWIMMING POOL");
    }
    @Override
    public int calculateRoomRent(int days) {
        return this.getRent()*days;
    }
}
