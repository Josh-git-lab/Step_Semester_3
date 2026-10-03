public class Main {
    public static void main(String[] args) {
        BookIssue[] issues = {
            new BookIssue("Clean Code", "Asha", 18),
            new BookIssue("Effective Java", "Ravi", 5),
            new BookIssue("Refactoring", "Neha", 0),
            new BookIssue("DSA Handbook", "Kiran", 21),
            new BookIssue("Design Patterns", "Meera", 9)
        };
        for (int i = 0; i < issues.length; i++) {
            String status = issues[i].isSeverelyOverdue() ? "Severely overdue" : "OK";
            System.out.println(issues[i].title + " - " + issues[i].daysOverdue + " days - " + status);
        }
        System.out.println("Total fine collected: Rs " + BookIssue.totalFineCollected(issues));
    }
}
