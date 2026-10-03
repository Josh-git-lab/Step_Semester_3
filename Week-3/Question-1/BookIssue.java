public class BookIssue {
    String title;
    String borrowerName;
    int daysOverdue;

    public BookIssue(String title, String borrowerName, int daysOverdue) {
        this.title = title;
        this.borrowerName = borrowerName;
        this.daysOverdue = daysOverdue;
    }

    public double fineAmount() {
        if (daysOverdue > 0) {
            return daysOverdue * 5.0;
        }
        return 0;
    }

    public boolean isSeverelyOverdue() {
        return daysOverdue > 14;
    }

    // totalFineCollected is static because it sums many books and belongs to the class. fineAmount is not static because it uses one book's daysOverdue.
    public static double totalFineCollected(BookIssue[] issues) {
        double total = 0;
        for (int i = 0; i < issues.length; i++) {
            total += issues[i].fineAmount();
        }
        return total;
    }
}
