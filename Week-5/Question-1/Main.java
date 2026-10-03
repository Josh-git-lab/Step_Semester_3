public class Main {
    public static void main(String[] args) {
        System.out.println(AccessRuleEngine.classifyAccess("private", "SAME_CLASS"));
        System.out.println(AccessRuleEngine.classifyAccess("default", "DIFFERENT_PACKAGE"));
        System.out.println(AccessRuleEngine.summarizeBatch(new String[][] {
            {"protected", "SAME_PACKAGE"},
            {"protected", "DIFFERENT_PACKAGE"},
            {"public", "DIFFERENT_PACKAGE"}
        }));
        try {
            new PatientRecord("MT9", "W3", 98.2, "MediTrack Central");
            System.out.println("construction succeeded");
        } catch (IllegalArgumentException ex) {
            System.out.println("construction rejected");
        }
        PatientRecord accepted = new PatientRecord("MT94", "W3", 98.2, "MediTrack Central");
        System.out.println(accepted.getPatientId());
    }
}
