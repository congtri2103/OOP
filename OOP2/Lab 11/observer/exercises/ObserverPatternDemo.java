package observer.exercises;

import java.util.ArrayList;
import java.util.List;

public class ObserverPatternDemo {
    public static void main(String[] args) {
        Observer hexa = new HexaObserver();
        hexa.update();
        Observer binary = new BinaryObserver();
        Observer octal = new OctalObserver();
        List<Observer> observers = new ArrayList<>();
        observers.add(binary);
        observers.add(hexa);
        observers.add(octal);
        Observer none = new BinaryObserver();
        Subject subject = new Subject(observers);
        subject.attach(none);
        subject.notifyAllObserver();
    }
}
