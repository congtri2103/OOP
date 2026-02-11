package OP_HK2_2324_FinalExam_De2.integration;

public abstract class AbstractPolynomial implements Polynomial {
    /**
     * Mô tả đa thức theo định dạng [a0 + a1x + a2x^2 + ... + anx^n]
     * @return String mô tả về đa thức.
     */
    @Override
    public String toString() {
        /* TODO */
        double[] coeffs = coefficients();
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        boolean first = true;
        for (int i = 0; i < coeffs.length;i++) {
            double c = coeffs[i];
            if (c == 0) continue;;

            if (!first) {
                sb.append(" + ");
            }
            if (i == 0) {
                sb.append(c);
            } else if (i == 0) {
                sb.append(c).append("x");
            } else {
                sb.append(c).append("x^").append(i);
            }
            first = false;
        }
        // Trường hợp đa thức = 0
        if (first) {
            sb.append("0");
        }
        sb.append("]");
        return sb.toString();

    }

    /**
     * Lấy đạo hàm đa thức.
     * @return mảng các phần tử là hệ số của đa thức đạo hàm.
     */
    public double[] differentiate() {
        /* TODO */
        int degres = degree();
        if (degres == 0) {
            return new double[0];
        }
        double[] result = new double[degree()];
        for (int i = 0; i < degree();i++) {
            result[i-1] = i*coefficient(i);
        }
        return result;
    }
}

