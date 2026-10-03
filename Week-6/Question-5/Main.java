public class Main {
    public static void main(String[] args) {
        EventTicket first = new EventTicket(500);
        System.out.println(first.ticketId);
        System.out.println(EventTicket.getTicketsIssued());
        System.out.println(EventTicket.isValidPromoCode("F123A"));
        System.out.println(EventTicket.isValidPromoCode("F12A"));
        System.out.println(EventTicket.isValidPromoCode("X123A"));
        first.pay(200);
        first.pay(200, "UPI");
        System.out.println(first.getBalanceDue());
        System.out.println(EventTicket.processNightlySettlement(new EventTicket[] {
            new GroupTicket(2000, 5),
            null,
            new EventTicket(500)
        }));
    }
}
