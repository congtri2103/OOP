package OOP_HK2_2223_FinalExam_De2.rootsolver;

public class MyMath {
    public static double sin(double x) {
        /* TODO */
        double term = x;
        double sum = x;

        for (int n = 1; n <= 10; n++) {
            term *= -x * x / ((2 * n) * (2 * n + 1));
            sum += term;
        }
        return sum;

    }

    public static double cos(double x) {
        /* TODO */
        double term = 1.0;
        double sum = 1.0;

        for (int n = 1; n <= 10; n++) {
            term *= -x * x / ((2 * n - 1) * (2 * n));
            sum += term;
        }
        return sum;
    }

    public double exp(double x) {
        /* TODO */
        double term = 1.0;
        double sum = 1.0;

        for (int n = 1; n <= 20; n++) {
            term *= x / n;
            sum += term;
        }
        return sum;
    }

    public double ln(double x) {
        /* TODO */
        if (x <= 0) {
            throw new IllegalArgumentException("ln(x) chỉ xác định với x > 0");
        }

        double t = (x - 1) / (x + 1);
        double term = t;
        double sum = 0.0;

        for (int n = 1; n <= 20; n += 2) {
            sum += term / n;
            term *= t * t;
        }
        return 2 * sum;
    }
}