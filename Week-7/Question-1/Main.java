public class Main {
    public static void main(String[] args) {
        CircleShape circle = new CircleShape(5.0);
        System.out.printf("%.2f%n", circle.calculateArea());
        SquareShape square = new SquareShape(4.0);
        System.out.println(square.calculateArea());
        square.scale(2.0);
        System.out.println(square.calculateArea());
        Shape.printArea(circle);
        System.out.println(circle.getShapeId());
        System.out.println(square.getShapeId());
    }
}
