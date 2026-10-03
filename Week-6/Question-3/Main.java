public class Main {
    public static void main(String[] args) {
        WorkshopTicket workshop = new WorkshopTicket(1200);
        workshop.pay(1200);
        workshop.applyLateFee(100);
        System.out.println(workshop.getBalanceDue());
        double[] history = workshop.getLateFeeHistory();
        System.out.println(formatHistory(history));
        history[0] = 999;
        System.out.println(formatHistory(workshop.getLateFeeHistory()));
    }

    private static String formatHistory(double[] history) {
        StringBuilder line = new StringBuilder();
        line.append('[');
        for (int i = 0; i < history.length; i++) {
            if (i > 0) {
                line.append(", ");
            }
            line.append(history[i]);
        }
        line.append(']');
        return line.toString();
    }
}
