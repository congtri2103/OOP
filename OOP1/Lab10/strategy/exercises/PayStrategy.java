package strategy.exercises;

public interface PayStrategy {
    boolean pay(int paymentAmount);
    void collectDetails();
}
