public class BrokenLibraryMember {
    // name is static, so the second member overwrites the first member's name.
    static String name;
    // memberId is static, so every member shares one id instead of keeping a separate id.
    static String memberId;
    // booksIssued is static, so every member shares one issue count instead of an individual count.
    static int booksIssued;

    public BrokenLibraryMember(String memberName, int issued) {
        name = memberName;
        memberId = "LM-1001";
        booksIssued = issued;
    }

    public void printName() {
        System.out.println(name);
    }
}
