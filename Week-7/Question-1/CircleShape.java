public class CircleShape extends Shape {
    private final double radius;

    public CircleShape(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        double scaledRadius = radius * Math.sqrt(getXScale() * getYScale());
        return Math.PI * scaledRadius * scaledRadius;
    }
}
