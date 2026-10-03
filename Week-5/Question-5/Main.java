public class Main {
    public static void main(String[] args) {
        try {
            new DischargeSummary("MT2026-0142", new String[] {"MED-A", "bad"});
            System.out.println("construction succeeded");
        } catch (IllegalArgumentException ex) {
            System.out.println("construction rejected");
        }
        DischargeSummary summary = new DischargeSummary("MT2026-0142", new String[] {"MED-A", "MED-B"});
        String[] codes = summary.getMedicationCodes();
        codes[0] = "TAMPERED";
        System.out.println(summary.getMedicationCodes()[0]);
        DischargeSummary corrected = summary.withCorrectedMedication(0, "MED-C");
        System.out.println(summary.getMedicationCodes()[0]);
        System.out.println(corrected.getMedicationCodes()[0]);
        System.out.println(NightlyLedger.processNightlyBatch(new DischargeSummary[] {
            new CriticalCareDischargeSummary("MT001", new String[] {"MED-X"}, 4),
            null,
            new DischargeSummary("MT002", new String[] {"MED-Y"})
        }));
    }
}
