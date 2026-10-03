public class LibraryMember {
    static String libraryName = "Central Library";
    static int memberCount = 0;
    String name;
    String memberId;
    int booksIssued;

    public LibraryMember(String name, int booksIssued) {
        this.name = name;
        memberCount++;
        this.memberId = "LM-" + (1000 + memberCount);
        this.booksIssued = booksIssued;
    }

    public void printMemberCard() {
        System.out.println(name + " | " + memberId);
    }

    public static void printTotalMembers() {
        System.out.println("Total members: " + memberCount);
    }
}
