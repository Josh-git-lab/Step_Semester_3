public class Main {
    public static void main(String[] args) {
        try {
            new EventTicket("ST1", 500);
            System.out.println("construction succeeded");
        } catch (IllegalArgumentException ex) {
            System.out.println("construction rejected");
        }
        WorkshopTicket workshop = new WorkshopTicket("STU2", 1200, "AI/ML");
        workshop.pay(500);
        System.out.println(workshop.getBalanceDue());
        System.out.println(EventTicket.registerBatch(
                new String[] {"STU1", "ST1", "STU2", "   ", "STU3"}, 500));
    }
}
