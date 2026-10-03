public abstract class ServiceableVehicle {
    private double mileage;

    public double getMileage() {
        return mileage;
    }

    public void addMileage(double km) {
        if (km < 0) {
            return;
        }
        mileage += km;
    }

    public abstract String performMaintenance();

    public static String getInsuranceIfApplicable(ServiceableVehicle vehicle) {
        if (vehicle instanceof Insurable) {
            return ((Insurable) vehicle).getInsuranceInfo();
        }
        return "No insurance record exists";
    }
}
