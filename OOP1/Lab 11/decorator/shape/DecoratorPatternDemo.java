package decorator.exercises.shape;

public class DecoratorPatternDemo {
    public static void main(String[] args) {
        Shape circle = new Circle();
        Shape rectangle = new Rectangle();
        circle.draw();
        System.out.println();
        Shape redRectangle = new RedShapeDecorator(rectangle);
        redRectangle.draw();
    }
}
