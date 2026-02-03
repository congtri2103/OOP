package OOP_HK2_2324_FinalExam_De1.rootsolver;

public interface RootSolver {
    /**
     * Tìm nghiệm của hàm một biến trong đoạn [lower, upper]
     * @param function
     * @param lower
     * @param upper
     * @return nghiệm của hàm.
     */
    double solve(AbstractFunction function, double lower, double upper);
}