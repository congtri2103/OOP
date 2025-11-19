package observer.exercises;

public class BinaryObserver extends Observer{
    public Subject subject;

    @Override
    public void update() {
        System.out.println("Binary");
    }
}
