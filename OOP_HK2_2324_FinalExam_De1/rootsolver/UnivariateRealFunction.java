package OOP_HK2_2324_FinalExam_De1.rootsolver;

public class UnivariateRealFunction implements AbstractFunction {
    @Override
    public double evaluate(double x) {
        /* TODO */
        return MyMath.sin(x)*x-3;
    }

    @Override
    public double derivative(double x) {
        /* TODO */
        return MyMath.sin(x) + x * MyMath.cos(x);
    }
}

