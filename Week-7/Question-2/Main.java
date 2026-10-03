public class Main {
    public static void main(String[] args) {
        ReportGenerator report = new ReportGenerator("Sales Q1");
        UserProfile profile = new UserProfile("jane_doe");
        Exportable ref = report;
        ExportCounter.exportAll(new Exportable[] {ref, profile});
        System.out.println(ExportCounter.getTotalExports());
    }
}
