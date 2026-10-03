public class Main {
    static void findLongestStreak(String signalLog) {
        char bestColor = signalLog.charAt(0);
        int bestLength = 1;
        char current = signalLog.charAt(0);
        int length = 1;
        for (int i = 1; i < signalLog.length(); i++) {
            if (signalLog.charAt(i) == current) {
                length++;
            } else {
                if (length > bestLength) {
                    bestLength = length;
                    bestColor = current;
                }
                current = signalLog.charAt(i);
                length = 1;
            }
        }
        if (length > bestLength) {
            bestLength = length;
            bestColor = current;
        }
        System.out.println("Longest Streak: '" + bestColor + "' repeated " + bestLength + " times");
    }

    public static void main(String[] args) {
        findLongestStreak("RRGGGYRR");
        findLongestStreak("RRRRYYGG");
    }
}
