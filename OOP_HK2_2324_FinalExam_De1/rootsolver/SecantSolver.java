package OOP_HK2_2324_FinalExam_De1.rootsolver;

public class SecantSolver implements RootSolver {
    private double tolerance;  // sai số cho phép
    private int maxIterations;  // tối đa số lần lặp

    /**
     * Khởi tạo giá trị các tham số.
     *
     * @param tolerance
     * @param maxIterations
     */
    public SecantSolver(double tolerance, int maxIterations) {
        /* TODO */
        this.tolerance = tolerance;
        this.maxIterations = maxIterations;
    }

    /**
     * Tìm nghiệm của hàm một biến theo phương pháp Secant
     *
     * @param function
     * @param lower
     * @param upper
     * @return nghiệm của hàm trong đoạn [lower, upper]
     */
    @Override
    public double solve(AbstractFunction function, double lower, double upper) {
        /* TODO */
        double x0 = lower;
        double x1 = upper;
        double f0 = function.evaluate(x0);
        double f1 = function.evaluate(x1);

        for (int i = 0; i < maxIterations; i++) {
            if (Math.abs(f1 - f0) < 1e-12) {
                throw new ArithmeticException("Mẫu số quá nhỏ trong phương pháp Secant");
            }
            double x2 = x1 - f1 * (x1 - x0) / (f1 - f0);
            if (Math.abs(x2 - x1) < tolerance) {
                return x2;
            }
            // Cập nhật cho vòng lặp tiếp theo
            x0 = x1;
            f0 = f1;
            x1 = x2;
            f1 = function.evaluate(x1);
        }
        throw new IllegalArgumentException("Không hội tụ sau " + maxIterations + " lần lặp");
    }
}
