public class DischargeSummary {
    private static final String LEDGER_STATE;

    static {
        LEDGER_STATE = "ready";
    }

    private final String patientId;
    private final String[] medicationCodes;

    public DischargeSummary(String patientId, String[] medicationCodes) {
        if (medicationCodes == null) {
            throw new IllegalArgumentException("construction rejected");
        }
        for (int i = 0; i < medicationCodes.length; i++) {
            if (!isValidCode(medicationCodes[i])) {
                throw new IllegalArgumentException("construction rejected");
            }
        }
        this.patientId = patientId;
        this.medicationCodes = new String[medicationCodes.length];
        for (int i = 0; i < medicationCodes.length; i++) {
            this.medicationCodes[i] = medicationCodes[i];
        }
    }

    static boolean isValidCode(String code) {
        if (code == null || code.length() != 5 || !code.startsWith("MED-")) {
            return false;
        }
        return Character.isUpperCase(code.charAt(4));
    }

    public String getPatientId() {
        return patientId;
    }

    public String[] getMedicationCodes() {
        String[] copy = new String[medicationCodes.length];
        for (int i = 0; i < medicationCodes.length; i++) {
            copy[i] = medicationCodes[i];
        }
        return copy;
    }

    public DischargeSummary withCorrectedMedication(int index, String newCode) {
        String[] updated = getMedicationCodes();
        updated[index] = newCode;
        return new DischargeSummary(patientId, updated);
    }

    static String ledgerState() {
        return LEDGER_STATE;
    }
}
