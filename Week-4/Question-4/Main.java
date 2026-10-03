public class Main {
    public static void main(String[] args) {
        SurgeFeeCalculator calculator = new SurgeFeeCalculator(1);
        System.out.println("Rs " + calculator.calculateSurgeFee(500, 0));
        System.out.println("Rs " + calculator.calculateSurgeFee(500, 1));
        System.out.println("Rs " + calculator.calculateSurgeFee(500, 16));
    }
}
