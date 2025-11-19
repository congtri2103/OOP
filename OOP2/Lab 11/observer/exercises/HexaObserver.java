package observer.exercises;

public class HexaObserver extends Observer{
    public Subject subject;

    @Override
    public void update() {
        System.out.println("Hexadecimal");
    }
}
