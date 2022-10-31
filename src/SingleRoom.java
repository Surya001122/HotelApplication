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

        System.out.println("\nBill amount to pay\n\nRoom number : "+this.getRoomNumber()+"\nRoom type: "+this.getRoomType()+"\nRoom rent : "+this.getRent()*this.getTotalDays());
        return this.getRent()*this.getTotalDays();
    }
}
