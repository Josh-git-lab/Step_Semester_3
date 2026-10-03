public class Main {
    public static void main(String[] args) {
        System.out.println(EventTicket.batchPrint(new EventTicket[] {
            new EventTicket(500),
            new WorkshopTicket(1200, "AI/ML")
        }));
    }
}
