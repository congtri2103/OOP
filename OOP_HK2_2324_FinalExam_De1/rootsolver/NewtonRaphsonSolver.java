package OOP_HK2_2324_FinalExam_De1.rootsolver;

public class NewtonRaphsonSolver implements RootSolver {
    private double tolerance;
    private int maxIterations;

    /**
     * Khởi tạo giá trị các tham số.
     * @param tolerance
     * @param maxIterations
     */
    public NewtonRaphsonSolver(double tolerance, int maxIterations) {
        /* TODO */
        this.tolerance = tolerance;
        this.maxIterations = maxIterations;
    }

    /**
     * Tìm nghiệm của hàm một biến sử dụng phương pháp Newton-Raphson.
     * @param function
     * @param lower
     * @param upper
     * @return nghiệm của hàm.
     */
    @Override
    public double solve(AbstractFunction function, double lower, double upper) {
        /* TODO */
        double x = lower;
        for (int i = 0; i < maxIterations; i++) {
            double f = function.evaluate(x);
            double df = (function.evaluate(x + tolerance) - f) / tolerance;
            if (Math.abs(f) < tolerance) {
                return x;
            }
            x = x - f / df;
            if (Math.abs(f / df) < tolerance) {
                return x;
            }
        }
        return x;
    }
}
