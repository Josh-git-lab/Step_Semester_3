public class ReconciliationEngine {
    public void processAccount(DeliveryAccount account, double amount, int delayMinutes) {
        if (account == null) {
            return;
        }
        if (amount < 0 || delayMinutes < 0) {
            throw new IllegalArgumentException("Negative values are not allowed");
        }
        account.calculateSurgeFee(delayMinutes);
    }

    public static void processBatch(DeliveryAccount[] accounts, double[] amounts, int[] delayMinutesArray) {
        if (accounts == null || amounts == null || delayMinutesArray == null
                || accounts.length != amounts.length
                || accounts.length != delayMinutesArray.length) {
            System.out.println("Batch rejected: array lengths do not match");
            return;
        }
        int processed = 0;
        int nullSkipped = 0;
        int premium = 0;
        int regular = 0;
        double total = 0;
        for (int i = 0; i < accounts.length; i++) {
            DeliveryAccount account = accounts[i];
            if (account == null) {
                nullSkipped++;
                continue;
            }
            double fee = account.calculateSurgeFee(delayMinutesArray[i]);
            total += fee;
            processed++;
            if (account instanceof PremiumDeliveryAccount) {
                premium++;
            } else {
                regular++;
            }
        }
        System.out.println(processed + " processed | " + nullSkipped + " null skipped | "
                + premium + " premium | " + regular + " regular | grand total surge fees = " + total);
    }
}
