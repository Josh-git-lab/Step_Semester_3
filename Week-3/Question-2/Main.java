public class Main {
    public static void main(String[] args) {
        Employee plain = new Employee("E001", "Plain", 40000);
        Employee manager = new ManagerEmployee("E002", "Manager", 70000, 8000);
        Employee intern = new InternEmployee("E003", "Intern", 12000, 10000);
        if (plain instanceof ManagerEmployee) {
            System.out.println("Manager effective pay: Rs " + ((ManagerEmployee) plain).effectiveSalary());
        } else if (plain instanceof InternEmployee) {
            System.out.println("Intern effective pay: Rs " + ((InternEmployee) plain).effectiveSalary());
        } else {
            System.out.println("Plain employee pay: Rs " + plain.getSalary());
        }
        if (manager instanceof ManagerEmployee) {
            System.out.println("Manager effective pay: Rs " + ((ManagerEmployee) manager).effectiveSalary());
        }
        if (intern instanceof InternEmployee) {
            System.out.println("Intern effective pay: Rs " + ((InternEmployee) intern).effectiveSalary());
        }
    }
}
