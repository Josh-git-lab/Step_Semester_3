public class Main {
    public static void main(String[] args) {
        ParkingSlot slotA1 = new ParkingSlot("A1", 2, 0);
        ParkingSlot slotA2 = new ParkingSlot("A2", 2, 0);
        slotA1.allot("DIVYA");
        slotA2.allot("KARAN");
        CompanyEmployeeRecord divya = new CompanyEmployeeRecord(
                "Divya", "M1", new ManagerEmployee("M1", "Divya", 70000, 8000), slotA1);
        CompanyEmployeeRecord karan = new CompanyEmployeeRecord(
                "Karan", "E1", new Employee("E1", "Karan", 40000), slotA2);
        CompanyEmployeeRecord meera = new CompanyEmployeeRecord(
                "Meera", "I1", new InternEmployee("I1", "Meera", 12000, 10000), null);
        System.out.println(divya.fullProfile());
        System.out.println(karan.fullProfile());
        System.out.println(meera.fullProfile());
        System.out.println("Total records: " + CompanyEmployeeRecord.totalRecords);
    }
}
