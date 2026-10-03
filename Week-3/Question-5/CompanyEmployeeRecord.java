public class CompanyEmployeeRecord {
    public static int totalRecords = 0;
    String name;
    String empId;
    Employee employee;
    ParkingSlot slot;

    public CompanyEmployeeRecord(String name, String empId, Employee employee, ParkingSlot slot) {
        this.name = name;
        this.empId = empId;
        this.employee = employee;
        this.slot = slot;
        totalRecords++;
    }

    public String fullProfile() {
        double pay = employee.getSalary();
        if (employee instanceof ManagerEmployee) {
            pay = ((ManagerEmployee) employee).effectiveSalary();
        } else if (employee instanceof InternEmployee) {
            pay = ((InternEmployee) employee).effectiveSalary();
        }
        String slotLabel = "no parking assigned";
        if (slot != null) {
            slotLabel = slot.slotNo;
        }
        return name + " | Pay: Rs " + pay + " | Slot: " + slotLabel;
    }
}
