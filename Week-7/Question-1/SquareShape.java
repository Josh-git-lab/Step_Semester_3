public class SquareShape extends Shape {
    private final double side;

    public SquareShape(double side) {
        this.side = side;
    }

    @Override
    public double calculateArea() {
        return (side * getXScale()) * (side * getYScale());
    }
}
