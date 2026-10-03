public class Main {
    public static void main(String[] args) {
        System.out.println(new PatientProfile("Arjun Iyer").getPatientId());
        System.out.println(new PatientProfile("MT2026-0142", "Arjun Iyer").getPatientId());
        PatientProfile profile = new PatientProfile();
        profile.setPatientId("MT2026-0142");
        profile.setPatientId("HACKED-0000");
        System.out.println(profile.getPatientId());
        profile.setLockerPin("4820");
        profile.setDischarged(true);
        System.out.println(profile.isDischarged());
    }
}
