public class Main {
    public static void main(String[] args) {
        Canteen[] canteens = {
            new Canteen("HB3-C", "Spice Junction", 3),
            new Canteen("hb1-c", "Grand Mess", 5),
            new Canteen("HB2-C", "Southern Treats")
        };
        Canteen[] ranked = Canteen.rankCanteens(canteens);
        StringBuilder line = new StringBuilder();
        line.append('[');
        for (int i = 0; i < ranked.length; i++) {
            if (i > 0) {
                line.append(", ");
            }
            line.append('"');
            line.append(ranked[i].getCanteenCode());
            line.append('"');
        }
        line.append(']');
        System.out.println(line);
    }
}
