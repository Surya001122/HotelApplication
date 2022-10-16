import com.sun.xml.internal.ws.server.SingletonResolver;

public class Main {
    public static void main(String[] args) {
        // abstraction
        Room room = new SingleRoom(1,1);
        room.calculateRoomRent();
    }
}