public class Main {
    public static void main(String[] args) {
        BrokenLibraryMember first = new BrokenLibraryMember("Aditi", 2);
        BrokenLibraryMember second = new BrokenLibraryMember("Rohan", 1);
        first.printName();
        second.printName();
        LibraryMember aditi = new LibraryMember("Aditi", 2);
        LibraryMember rohan = new LibraryMember("Rohan", 1);
        aditi.printMemberCard();
        rohan.printMemberCard();
        LibraryMember.printTotalMembers();
    }
}
