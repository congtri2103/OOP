package OOP_HK2_2223_FinalExam_De1.integration;

public abstract class AbstractPolynomial implements Polynomial {
    /**
     * Mô tả đa thức theo định dạng [a0 + a1x + a2x^2 + ... + anx^n]
     * @return String mô tả về đa thức.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        double[] coeff = this.coefficients();
        for (int i = coeff.length - 1; i >= 0;i--) {
            if (coeff[i] == 0 ) continue;

            if (sb.length() > 0) {
                if (coeff[i] > 0) sb.append("+");
            }

            double a = coeff[i];
            if (i == 0) {
                sb.append(a);
            } else if (i == 1) {
                if (a == 1) {
                    sb.append("x");
                }
                else if (a == -1) {
                    sb.append("-x");
                } else {
                    sb.append(a + "x");
                }
            } else {
                if (a == 1) {
                    sb.append("x^" + i);
                } else if (a == -1) {
                    sb.append("-x^" + i);
                } else {
                    sb.append(a + "x^" + i);
                }
            }
        }
        if (sb.length() == 0) {
            return "0";
        }
        return sb.toString();
        /* TODO */
    }

    /**
     * Lấy đạo hàm đa thức.
     * @return mảng các phần tử là hệ số của đa thức đạo hàm.
     */
    public double[] differentiate() {
        double[] coeff = this.coefficients();
        if (coeff.length <= 1 ) {
            return new double[]{0};
        }

        double[] daoham = new double[coeff.length - 1];

        for (int i = 0; i < coeff.length;i++) {
            daoham[i-1] = coeff[i]*i;
        }
        return daoham;
        /* TODO */
    }
}
