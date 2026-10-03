public class PatientProfile {
    private String patientId;
    private String name;
    private boolean discharged;
    private String lockerPinHash;
    private boolean patientIdSet;

    public PatientProfile() {
        this((String) null);
    }

    public PatientProfile(String name) {
        this(null, name);
    }

    public PatientProfile(String patientId, String name) {
        this.name = name;
        if (patientId != null) {
            this.patientId = patientId;
            this.patientIdSet = true;
        }
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String id) {
        if (patientIdSet) {
            return;
        }
        this.patientId = id;
        this.patientIdSet = true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isDischarged() {
        return discharged;
    }

    public void setDischarged(boolean discharged) {
        this.discharged = discharged;
    }

    public void setLockerPin(String pin) {
        if (pin == null || pin.length() < 4 || pin.length() > 6) {
            return;
        }
        for (int i = 0; i < pin.length(); i++) {
            if (!Character.isDigit(pin.charAt(i))) {
                return;
            }
        }
        lockerPinHash = Integer.toHexString(pin.hashCode());
    }
}
