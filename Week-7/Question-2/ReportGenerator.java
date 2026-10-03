public class ReportGenerator implements Exportable {
    private final String reportName;

    public ReportGenerator(String reportName) {
        this.reportName = reportName;
    }

    @Override
    public String exportData() {
        ExportCounter.recordExport();
        return "Exported report: " + reportName;
    }
}
