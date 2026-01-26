package OOP_HK2_2223_FinalExam_De2.rootsolver;

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
        double fLower = function.evaluate(lower);
        double fUpper = function.evaluate(upper);

        // Kiểm tra điều kiện đổi dấu
        if (fLower * fUpper > 0) {
            throw new IllegalArgumentException(
                    "Hàm không đổi dấu trong đoạn [" + lower + ", " + upper + "]"
            );
        }
        double mid = lower;
        for (int i = 0; i < maxIterations; i++) {
            mid = (lower + upper) / 2;
            double fMid = function.evaluate(mid);

            // Điều kiện dừng
            if (Math.abs(fMid) < tolerance || (upper - lower) / 2 < tolerance) {
                return mid;
            }

            // Chọn nửa đoạn chứa nghiệm
            if (fLower * fMid < 0) {
                upper = mid;
                fUpper = fMid;
            } else {
                lower = mid;
                fLower = fMid;
            }
        }
        return mid;
    }
}