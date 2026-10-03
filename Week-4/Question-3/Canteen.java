public class Canteen {
    private final String canteenCode;
    private final String canteenName;
    private final int trustScore;

    public Canteen(String canteenCode, String canteenName, int trustScore) {
        this.canteenCode = canteenCode;
        this.canteenName = canteenName;
        this.trustScore = trustScore;
    }

    public Canteen(String canteenCode, String canteenName) {
        this(canteenCode, canteenName, 3);
    }

    public String getCanteenCode() {
        return canteenCode;
    }

    public int compareTo(Canteen other) {
        if (this.trustScore != other.trustScore) {
            return other.trustScore - this.trustScore;
        }
        int byCode = this.canteenCode.compareToIgnoreCase(other.canteenCode);
        if (byCode != 0) {
            return byCode;
        }
        return this.canteenName.length() - other.canteenName.length();
    }

    public static Canteen[] rankCanteens(Canteen[] canteens) {
        Canteen[] ranked = new Canteen[canteens.length];
        for (int i = 0; i < canteens.length; i++) {
            ranked[i] = canteens[i];
        }
        for (int i = 0; i < ranked.length - 1; i++) {
            for (int j = 0; j < ranked.length - 1 - i; j++) {
                if (ranked[j].compareTo(ranked[j + 1]) > 0) {
                    Canteen swap = ranked[j];
                    ranked[j] = ranked[j + 1];
                    ranked[j + 1] = swap;
                }
            }
        }
        return ranked;
    }
}
