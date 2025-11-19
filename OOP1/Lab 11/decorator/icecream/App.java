package decorator.exercises.icecream;

public class App {
    public static void main(String[] args) {
        IceCream chocolate = new ChocolateIceCream();
        IceCream sweet = new HoneyToppingDecorator(chocolate);
        System.out.println(sweet.getDescription());
    }
}
