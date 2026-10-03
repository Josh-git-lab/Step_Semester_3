public class Main {
    public static void main(String[] args) {
        DeliveryAccount[] accounts = {
            new PremiumDeliveryAccount("STU001", 500),
            null,
            new DeliveryAccount("STU002", 300)
        };
        double[] amounts = {500, 400, 300};
        int[] delayMinutes = {10, 5, 0};
        ReconciliationEngine.processBatch(accounts, amounts, delayMinutes);
    }
}
