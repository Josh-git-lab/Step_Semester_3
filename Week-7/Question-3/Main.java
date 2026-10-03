public class Main {
    public static void main(String[] args) {
        Forklift forklift = new Forklift("FL-22");
        forklift.addMileage(120);
        forklift.addMileage(-5);
        System.out.println(forklift.getMileage());
        System.out.println(forklift.performMaintenance());
        HeavyDutyForklift heavy = new HeavyDutyForklift("HD-9");
        System.out.println(heavy.performMaintenance());
        System.out.println(ServiceableVehicle.getInsuranceIfApplicable(forklift));
        ServiceableVehicle plain = new ServiceableVehicle() {
            @Override
            public String performMaintenance() {
                return "basic service";
            }
        };
        System.out.println(ServiceableVehicle.getInsuranceIfApplicable(plain));
    }
}
