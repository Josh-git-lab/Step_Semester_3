public class EventTicket {
    private static int issuedCount = 0;
    private static int nextNumber = 1000;

    public final String ticketId;
    private final String attendeeId;
    private final double basePrice;
    private double amountPaid;
    private double lateFees;
    private double[] lateFeeHistory = new double[0];

    public EventTicket(String attendeeId, double basePrice) {
        if (attendeeId == null || attendeeId.trim().length() < 4) {
            throw new IllegalArgumentException("construction rejected");
        }
        this.attendeeId = attendeeId.trim();
        this.basePrice = basePrice;
        issuedCount++;
        nextNumber++;
        this.ticketId = "TCK-" + nextNumber;
    }

    public EventTicket(double basePrice) {
        this("ANON", basePrice);
    }

    public void pay(double amount) {
        amountPaid += amount;
    }

    public void pay(double amount, String mode) {
        System.out.println(mode);
        pay(amount);
    }

    public double getBalanceDue() {
        return basePrice - amountPaid + lateFees;
    }

    protected void applyLateFee(double amount) {
        lateFees += amount;
        double[] updated = new double[lateFeeHistory.length + 1];
        for (int i = 0; i < lateFeeHistory.length; i++) {
            updated[i] = lateFeeHistory[i];
        }
        updated[lateFeeHistory.length] = amount;
        lateFeeHistory = updated;
    }

    public double[] getLateFeeHistory() {
        double[] copy = new double[lateFeeHistory.length];
        for (int i = 0; i < lateFeeHistory.length; i++) {
            copy[i] = lateFeeHistory[i];
        }
        return copy;
    }

    public String printTicket() {
        return "Standard Event Ticket | Balance Due: " + getBalanceDue();
    }

    public String getAttendeeId() {
        return attendeeId;
    }

    public static int getTicketsIssued() {
        return issuedCount;
    }

    public static boolean isValidPromoCode(String code) {
        if (code == null || code.length() != 5 || code.charAt(0) != 'F') {
            return false;
        }
        for (int i = 1; i <= 3; i++) {
            if (!Character.isDigit(code.charAt(i))) {
                return false;
            }
        }
        return Character.isUpperCase(code.charAt(4));
    }

    public static String registerBatch(String[] attendeeIds, double basePrice) {
        int registered = 0;
        int rejected = 0;
        for (int i = 0; i < attendeeIds.length; i++) {
            try {
                new EventTicket(attendeeIds[i], basePrice);
                registered++;
            } catch (IllegalArgumentException ex) {
                rejected++;
            }
        }
        return "Registered: " + registered + " | Rejected: " + rejected;
    }

    public static String classifyGeneration(EventTicket ticket) {
        if (ticket instanceof PremiumWorkshopTicket) {
            return "Multilevel descendant (3 generations deep)";
        }
        if (ticket instanceof HackathonTicket) {
            return "Hierarchical sibling (independent branch)";
        }
        if (ticket instanceof WorkshopTicket) {
            return "Single-inheritance child (2 generations deep)";
        }
        return "Base class (1 generation)";
    }

    public static double getTotalBalanceDue(EventTicket[] tickets) {
        double total = 0;
        for (int i = 0; i < tickets.length; i++) {
            total += tickets[i].getBalanceDue();
        }
        return total;
    }

    public static String batchPrint(EventTicket[] tickets) {
        StringBuilder report = new StringBuilder();
        for (int i = 0; i < tickets.length; i++) {
            tickets[i].printTicket();
            if (tickets[i] instanceof WorkshopTicket) {
                WorkshopTicket workshop = (WorkshopTicket) tickets[i];
                report.append("Workshop | Track: ");
                report.append(workshop.getTrack());
                report.append(" | Balance: ");
                report.append(tickets[i].getBalanceDue());
                report.append(" [Track via downcast: ");
                report.append(workshop.getTrack());
                report.append("] | ");
            } else {
                report.append("Standard | Balance: ");
                report.append(tickets[i].getBalanceDue());
                report.append(" | ");
            }
        }
        return report.toString();
    }

    public static String processNightlySettlement(EventTicket[] tickets) {
        int processed = 0;
        int nullSkipped = 0;
        int group = 0;
        int individual = 0;
        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i] == null) {
                nullSkipped++;
                continue;
            }
            processed++;
            if (tickets[i] instanceof GroupTicket) {
                group++;
            } else {
                individual++;
            }
        }
        return processed + " processed | " + nullSkipped + " null skipped | "
                + group + " group | " + individual + " individual";
    }
}
