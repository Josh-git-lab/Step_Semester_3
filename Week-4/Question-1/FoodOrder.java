public class FoodOrder {
    private final String studentName;
    private final String dishName;
    private boolean delivered;

    public FoodOrder(String studentName, String dishName) {
        if (!isPresent(studentName) || !isPresent(dishName)) {
            throw new IllegalArgumentException("Invalid order");
        }
        this.studentName = studentName.trim();
        this.dishName = dishName.trim();
    }

    private static boolean isPresent(String value) {
        return value != null && !value.trim().isEmpty();
    }

    public void markDelivered() {
        if (delivered) {
            System.out.println("Already delivered: " + studentName + " - " + dishName);
            return;
        }
        delivered = true;
        System.out.println("Delivered: " + studentName + " - " + dishName);
    }

    public static void processBatch(String[][] rawOrders) {
        int valid = 0;
        int rejected = 0;
        for (int i = 0; i < rawOrders.length; i++) {
            try {
                new FoodOrder(rawOrders[i][0], rawOrders[i][1]);
                valid++;
            } catch (IllegalArgumentException ex) {
                rejected++;
            }
        }
        System.out.println("Valid: " + valid + " | Rejected: " + rejected);
    }
}
