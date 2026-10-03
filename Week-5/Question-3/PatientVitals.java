public class PatientVitals {
    private double[] readings = new double[0];

    public PatientVitals(double[] initialReadings) {
        if (initialReadings == null) {
            return;
        }
        for (int i = 0; i < initialReadings.length; i++) {
            recordReading(initialReadings[i]);
        }
    }

    public void recordReading(double reading) {
        if (reading <= 0 || reading > 45) {
            return;
        }
        double[] updated = new double[readings.length + 1];
        for (int i = 0; i < readings.length; i++) {
            updated[i] = readings[i];
        }
        updated[readings.length] = reading;
        readings = updated;
    }

    public double getAverage() {
        if (readings.length == 0) {
            return 0;
        }
        double total = 0;
        for (int i = 0; i < readings.length; i++) {
            total += readings[i];
        }
        return total / readings.length;
    }

    public double[] getAllReadings() {
        double[] copy = new double[readings.length];
        for (int i = 0; i < readings.length; i++) {
            copy[i] = readings[i];
        }
        return copy;
    }
}
