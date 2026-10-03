public class Main {
    public static void main(String[] args) {
        PatientVitals vitals = new PatientVitals(new double[] {36.5, -2, 37.1});
        printReadings(vitals.getAllReadings());
        double[] copy = vitals.getAllReadings();
        copy[0] = 999;
        System.out.println(vitals.getAllReadings()[0]);
        System.out.println(vitals.getAverage());
    }

    private static void printReadings(double[] readings) {
        StringBuilder line = new StringBuilder();
        line.append('[');
        for (int i = 0; i < readings.length; i++) {
            if (i > 0) {
                line.append(", ");
            }
            line.append(readings[i]);
        }
        line.append(']');
        System.out.println(line);
    }
}
