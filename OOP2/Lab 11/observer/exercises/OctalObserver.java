package observer.exercises;

public class OctalObserver extends Observer{
    public Subject subject;

    @Override
    public void update() {
        System.out.println("Octal");
    }
}
