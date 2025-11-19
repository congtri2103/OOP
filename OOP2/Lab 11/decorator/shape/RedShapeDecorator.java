package decorator.exercises.shape;

public class RedShapeDecorator extends ShapeDecorator {

    public RedShapeDecorator(Shape decoratedShape) {
        super(decoratedShape);
    }

    @Override
    public void draw() {
        setRedBorder(decoratedShape);
    }

    private void setRedBorder(Shape decoratedShape){
        decoratedShape.draw();
        System.out.println("With Red Border Color");
    }
}
