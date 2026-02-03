package OOP_HK2_2324_FinalExam_De1.rootsolver;

public class BisectionSolver implements RootSolver {
    private double tolerance;
    private int maxIterations;

    /**
     * Khởi tạo giá trị các tham số.
     * @param tolerance
     * @param maxIterations
     */
    public BisectionSolver(double tolerance, int maxIterations) {
        /* TODO */
        this.tolerance = tolerance;
        this.maxIterations = maxIterations;
    }

    /**
     * Tìm nghiệm của hàm một biến theo phương pháp chia đôi (Bisection)
     * @param function
     * @param lower
     * @param upper
     * @return nghiệm của hàm.
     */
    @Override
    public double solve(AbstractFunction function, double lower, double upper) {
        /* TODO */
        double mid = 0;
        for (int i = 0; i < maxIterations; i++) {
            mid = (lower + upper) / 2;
            if (Math.abs(function.evaluate(mid)) <= tolerance || (upper - lower) / 2 < tolerance) {
                return mid;
            }
            if (function.evaluate(mid) * function.evaluate(lower) < 0) {
                upper = mid;
            } else {
                lower = mid;
            }
        }
        return mid;
    }
}
