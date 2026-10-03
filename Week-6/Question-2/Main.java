public class Main {
    public static void main(String[] args) {
        EventTicket standard = new EventTicket("STU1", 500);
        WorkshopTicket workshop = new WorkshopTicket("STU2", 1200, "AI/ML");
        PremiumWorkshopTicket premium = new PremiumWorkshopTicket("STU3", 2000, "Cloud Native", 300);
        HackathonTicket hackathon = new HackathonTicket("STU4", 800, "Byte Force");
        System.out.println(standard.printTicket());
        System.out.println(workshop.printTicket());
        System.out.println(premium.printTicket());
        System.out.println(hackathon.printTicket());
        System.out.println(EventTicket.classifyGeneration(premium));
        System.out.println(EventTicket.classifyGeneration(hackathon));
        System.out.println(EventTicket.getTotalBalanceDue(
                new EventTicket[] {standard, workshop, premium, hackathon}));
    }
}
