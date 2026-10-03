public class ExportCounter {
    private static int totalExports = 0;

    public static void recordExport() {
        totalExports++;
    }

    public static int getTotalExports() {
        return totalExports;
    }

    public static void exportAll(Exportable[] items) {
        for (int i = 0; i < items.length; i++) {
            System.out.println(items[i].exportData());
        }
    }
}
