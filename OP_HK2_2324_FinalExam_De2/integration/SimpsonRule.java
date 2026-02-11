package OP_HK2_2324_FinalExam_De2.integration;


public class SimpsonRule implements Integrator {
    private double precision;
    private int maxIterations;

    public SimpsonRule(double precision, int maxIterations) {
        /* TODO */
        this.precision = precision;
        this.maxIterations = maxIterations;
    }

    /**
     * Phương thức tính xấp xỉ giá trị tích phân. Giá trị xấp xỉ được chấp nhận nếu phép tính đạt độ chính xác đã cho,
     * hoặc có số vòng vượt quá ngưỡng quy định.
     * Độ chính xác được xác định như sau, chọn n0 tùy ý, sau đó tính I_n với n = n0, 2n0, 4n0, ...
     * Việc tính toán dừng lại khi |I_2n - In|/3 < eps (precision), hoặc số lần chia đôi vượt quá ngưỡng quy định (maxIterations).
     * @param poly
     * @param lower
     * @param upper
     * @return
     */
    @Override
    public double integrate(Polynomial poly, double lower, double upper) {
        /* TODO */
        int n = 2;   // n0, phải là số chẵn
        double I_n = integrate(poly,lower,upper,n);
        int iterations = 0;
        while (iterations < maxIterations) {
            n *= 2; // 2n, 4n, 8n, ...
            double I_2n = integrate(poly, lower, upper, n);
            if (Math.abs(I_2n-I_n)/3 < precision) {
                return I_2n;
            }
            I_n = I_2n;
            iterations++;

        }
        return I_n;
    }

    /**
     * Phương thức tính xấp xỉ giá trị tích phân với numOfSubIntervals (số chẵn) khoảng phân hoạch đều.
     * @param poly
     * @param lower
     * @param upper
     * @param numOfSubIntervals
     * @return giá trị xấp xỉ giá trị tích phân.
     */
    private double integrate(Polynomial poly, double lower, double upper, int numOfSubIntervals) {
        /* TODO */
        if (numOfSubIntervals %2 != 0) {
            throw new IllegalArgumentException("Simpson yêu cầu số khoảng chẵn");
        }
        double h = (upper-lower)/numOfSubIntervals;
        double sum = poly.evaluate(lower) + poly.evaluate(upper);

        for (int i = 1;i < numOfSubIntervals;i++) {
            double x = lower + i*h;

            if (i % 2 == 0) {
                sum += 2 * poly.evaluate(x);
            } else {
                sum += 4 * poly.evaluate(x);
            }
        }
        return sum * h / 3;
    }
}

