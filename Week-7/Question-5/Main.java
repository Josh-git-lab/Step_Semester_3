public class Main {
    public static void main(String[] args) {
        WashingMachine washer = new WashingMachine(500.0);
        System.out.println(washer.activate());
        System.out.println(washer.connect("HomeConnect"));
        Refrigerator fridge = new Refrigerator(150.0);
        System.out.println(HomeDevice.getConsumptionIfTrackable(fridge));
        MobileApp app = new MobileApp("HomeConnect App");
        System.out.println(app.connect("HomeConnect"));
        HomeDevice ref = washer;
        System.out.println(HomeDevice.getConsumptionIfTrackable(ref));
        RemoteControllable.connectAll(new RemoteControllable[] {washer, app}, "HomeConnect");
    }
}
