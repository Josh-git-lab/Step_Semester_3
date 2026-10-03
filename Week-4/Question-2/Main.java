public class Main {
    public static void main(String[] args) {
        System.out.println(new DeliverySlot("ORD101", "13:00-14:00").isPeakHour());
        System.out.println(new DeliverySlot("ORD102").isPeakHour());
    }
}
