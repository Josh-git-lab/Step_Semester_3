public final class SurgeFeeCalculator {
    private final double minimumSurgePercent;

    public SurgeFeeCalculator(double minimumSurgePercent) {
        this.minimumSurgePercent = minimumSurgePercent;
    }

    public final double calculateSurgeFee(double orderValue, int delayMinutes) {
        if (orderValue < 0 || delayMinutes < 0) {
            throw new IllegalArgumentException("Negative values are not allowed");
        }
        if (delayMinutes == 0) {
            return 0;
        }
        int firstBand = Math.min(delayMinutes, 5);
        int secondBand = delayMinutes > 5 ? Math.min(delayMinutes, 15) - 5 : 0;
        int thirdBand = delayMinutes > 15 ? delayMinutes - 15 : 0;
        double tiered = (orderValue * firstBand * 0.5 + orderValue * secondBand + orderValue * thirdBand * 2) / 100.0;
        double floor = orderValue * minimumSurgePercent / 100.0;
        return Math.max(tiered, floor);
    }
}
