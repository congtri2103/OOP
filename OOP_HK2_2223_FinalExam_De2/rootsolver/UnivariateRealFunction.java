package OOP_HK2_2223_FinalExam_De2.rootsolver;

public class UnivariateRealFunction implements AbstractFunction {
    @Override
    public double evaluate(double x) {
        /* TODO */
        return Math.sin(x) * x - 3;
    }
}