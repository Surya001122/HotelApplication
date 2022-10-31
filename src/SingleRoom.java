import java.util.HashMap;

// SingleRoom is a type of RoomType(is a relationship)
public class SingleRoom extends Room{
    public SingleRoom(int roomNumber, String roomType, int floorNumber, int totalBeds, int rent, int roomMobileNumber) {
        super(roomNumber, roomType, floorNumber, totalBeds, rent,roomMobileNumber);
    }

    @Override
    public void viewAvailableFacilities() {
        System.out.println("\n\nFACILITIES : \n\nSINGLE COT\nAIR CONDITIONING\nTELIVISION");
    }
    @Override
    public int calculateRoomRent() {
        return this.getRent()*this.getTotalDays();
    }
}
