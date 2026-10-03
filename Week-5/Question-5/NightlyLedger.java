public class NightlyLedger {
    public static String processNightlyBatch(DischargeSummary[] summaries) {
        if (!"ready".equals(DischargeSummary.ledgerState())) {
            return "ledger unavailable";
        }
        int processed = 0;
        int nullSkipped = 0;
        int critical = 0;
        int routine = 0;
        for (int i = 0; i < summaries.length; i++) {
            if (summaries[i] == null) {
                nullSkipped++;
                continue;
            }
            processed++;
            if (summaries[i] instanceof CriticalCareDischargeSummary) {
                critical++;
            } else {
                routine++;
            }
        }
        return processed + " processed | " + nullSkipped + " null skipped | "
                + critical + " critical-care | " + routine + " routine";
    }
}
