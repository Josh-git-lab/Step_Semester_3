public class DeliveryAccount {
    private static final SurgeFeeCalculator CALCULATOR;

    static {
        CALCULATOR = new SurgeFeeCalculator(1);
    }

    private final String studentId;
    private final double orderValue;

    public DeliveryAccount(String studentId, double orderValue) {
        this.studentId = studentId;
        this.orderValue = orderValue;
    }

    public DeliveryAccount(String studentId) {
        this(studentId, 0);
    }

    public final double calculateSurgeFee(int delayMinutes) {
        return CALCULATOR.calculateSurgeFee(orderValue, delayMinutes);
    }
}
