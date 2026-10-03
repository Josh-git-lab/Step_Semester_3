public class Main {
    public static void main(String[] args) {
        ParkingSlot[] available = {
            new ParkingSlot("A1", 4, 3),
            new ParkingSlot("A2", 5, 5)
        };
        ParkingSlot.safeAllot(available, "TN09AB1234");
        ParkingSlot[] full = {
            new ParkingSlot("A1", 4, 4),
            new ParkingSlot("A2", 5, 5)
        };
        ParkingSlot.safeAllot(full, "TN09AB1234");
    }
}
