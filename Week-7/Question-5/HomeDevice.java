public abstract class HomeDevice {
    private static int nextNumber = 1000;
    private final String serialNumber;

    public HomeDevice() {
        nextNumber++;
        serialNumber = "HD-" + nextNumber;
    }

    public abstract String activate();

    public String getSerialNumber() {
        return serialNumber;
    }

    public static double getConsumptionIfTrackable(HomeDevice device) {
        if (device instanceof EnergyTrackable) {
            return ((EnergyTrackable) device).getConsumptionWatts();
        }
        return 0;
    }
}
