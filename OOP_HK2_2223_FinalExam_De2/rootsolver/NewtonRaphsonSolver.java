package OOP_HK2_2223_FinalExam_De2.rootsolver;

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
        double x0 = (lower + upper) / 2;
        double x1 = x0;
        double h = 1e-6;

        for (int i = 0; i < maxIterations; i++) {
            double fx = function.evaluate(x0);
            double dfx = (function.evaluate(x0 + h) - fx) / h;
            if (Math.abs(dfx) < 1e-10) {
                throw new ArithmeticException("Đạo hàm gần bằng 0");
            }
            x1 = x0 - fx / dfx;
            if (Math.abs(x1 - x0) < tolerance) {
                return x1;
            }
            x0 = x1;
        }
        return x1;
    }
}

