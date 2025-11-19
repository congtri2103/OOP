package strategy.pseudocode;

import java.util.Scanner;

public class ExampleApplication {
    public static void main(String[] args) {
        Context context = new Context();
        Scanner scan = new Scanner(System.in);
        int firstNum = scan.nextInt();
        int lastNum = scan.nextInt();
        String action = scan.next();
        if (action.equals("addition")) {
            context.setStrategy(new ConcreteStrategyAdd());
        }

        if (action.equals("subtract")) {
            context.setStrategy(new ConcreteStrategySubtract());
        }

        if (action.equals("multiply")) {
            context.setStrategy(new ConcreteStrategyMultiply());
        }

        int result = context.executeStrategy(firstNum,lastNum);
        System.out.println(result);
    }
}
