public abstract class Shape {
    private static int nextNumber = 0;
    private final String shapeId;
    private double xScale = 1;
    private double yScale = 1;

    public Shape() {
        nextNumber++;
        shapeId = "SHP-" + nextNumber;
    }

    public abstract double calculateArea();

    public void scale(double factor) {
        xScale *= factor;
        yScale *= factor;
    }

    public void scale(double xFactor, double yFactor) {
        xScale *= xFactor;
        yScale *= yFactor;
    }

    public String getShapeId() {
        return shapeId;
    }

    protected double getXScale() {
        return xScale;
    }

    protected double getYScale() {
        return yScale;
    }

    public static void printArea(Shape shape) {
        System.out.println(shape.calculateArea());
    }
}
