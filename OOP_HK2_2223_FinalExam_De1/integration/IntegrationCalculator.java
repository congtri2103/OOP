package OOP_HK2_2223_FinalExam_De1.integration;

public class IntegrationCalculator {
    private Integrator integrator;   // Phương pháp tích phân
    private Polynomial poly;    // Đa thức cần tính tích phân

    /**
     * Hàm dựng, khởi tạo đa thức cần tính tích phân.
     * @param poly
     */
    public IntegrationCalculator(Polynomial poly) {
        this.poly = poly;
        /* TODO */
    }

    /**
     * Hàm dựng, khởi tạo phương pháp tính tích phân và đa thức cần tính tích phân.
     * @param integrator
     * @param poly
     */
    public IntegrationCalculator(Integrator integrator, Polynomial poly) {
        this.integrator = integrator;
        this.poly = poly;
        /* TODO */
    }

    public void setPoly(Polynomial poly) {
        this.poly = poly;
        /* TODO */
    }

    public void setIntegrator(Integrator integrator) {
        this.integrator = integrator;
        /* TODO */
    }

    public double integrate(double lower, double upper) {
        if (integrator == null || poly == null) {
            throw new IllegalStateException("Bộ tích phân hoặc Đa thức chưa được đặt.");
        }
        return integrator.integrate(poly,lower,upper); // Sử dụng phương pháp tích phân đã chọn
        /* TODO */
    }
}
