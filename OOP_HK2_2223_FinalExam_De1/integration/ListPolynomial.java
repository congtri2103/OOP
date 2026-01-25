package OOP_HK2_2223_FinalExam_De1.integration;

import java.util.ArrayList;
import java.util.List;

public class ListPolynomial extends AbstractPolynomial {
    private List<Double> coefficients;

    /**
     * Khởi tạo dữ liệu mặc định.
     */
    public ListPolynomial() {
        coefficients = new ArrayList<>();
        /* TODO */
    }

    /**
     * Lấy hệ số của đa thức tại vị trí index.
     * @return
     */
    @Override
    public double coefficient(int index) {
        if (index < 0 || index >= coefficients.size()) {
            throw new IndexOutOfBoundsException(index);
        }
        return coefficients.get(index);
        /* TODO */
    }

    /**
     * Lấy các hệ số của đa thức.
     * @return
     */
    @Override
    public double[] coefficients() {
        double[] result = new double[coefficients.size()];
        for (int i = 0; i < coefficients.size();i++) {
            result[i] = coefficients.get(i);
        }
        return result;
        /* TODO */
    }

    /**
     * Thêm phần tử có hệ số coefficient vào cuối đa thức hiện tại.
     * @param coefficient
     * @return đa thức hiện tại.
     */
    public ListPolynomial append(double coefficient) {
        coefficients.add(coefficient);
        return this;
        /* TODO */
    }

    /**
     * Thêm phần tử có hệ số coefficient vào vị trí index.
     * @param coefficient
     * @param index
     * @return đa thức hiện tại.
     */
    public ListPolynomial insert(double coefficient, int index) {
        if (index < 0 || index >= coefficients.size()) {
            throw new IndexOutOfBoundsException(index);
        }
        coefficients.add(index,coefficient);
        return this;
        /* TODO */
    }

    /**
     * Sửa hệ số của phần tử index là coefficient.
     * @param coefficient
     * @param index
     * @return đa thức hiện tại.
     */
    public ListPolynomial set(double coefficient, int index) {
        if (index < 0 || index >= coefficients.size()) {
            throw new IndexOutOfBoundsException(index);
        }
        coefficients.set(index,coefficient);
        return this;

        /* TODO */
    }

    /**
     * Lấy ra bậc của đa thức.
     * @return
     */
    @Override
    public int degree() {
        /* TODO */
        return coefficients.size();
    }

    /**
     * Tính giá trị của đa thức khi biết giá trị của x.
     * @return
     */
    @Override
    public double evaluate(double x) {
        double result =0;
        for (int i = 0; i < coefficients.size();i++) {
            result += coefficients.get(i)*Math.pow(x,i);
        }
        return result;
        /* TODO */
    }

    /**
     * Lấy đạo hàm của đa thức.
     * @return Đa thức kiểu ListPolynomial là đa thức đạo hàm của đa thức ban đầu.
     */
    @Override
    public Polynomial derivative() {
        ListPolynomial result = new ListPolynomial();
        if (coefficients.size() <= 1) {
            result.append(0);
            return result;
        }
        for (int i = 0; i < coefficients.size();i++) {
            result.append(coefficients.get(i)*i);
        }
        return result;
        /* TODO */
    }

    /**
     * Cộng đa thức hiện tại với đa thức khác.
     * @param another
     * @return đa thức hiện tại.
     */
    public ListPolynomial plus(ListPolynomial another) {
        ListPolynomial result = new ListPolynomial();
        int maxSize = Math.max(this.coefficients.size(),another.coefficients.size());

        for (int i = 0 ; i < maxSize;i++) {
            double a;
            if (i < this.coefficients.size()) {
                a = this.coefficients.get(i);
            } else {
                a = 0;
            }

            double b;
            if (i < another.coefficients.size()) {
                b = another.coefficients.get(i);
            } else {
                b = 0;
            }
            result.append(a+b);
        }
        return result;
        /* TODO */
    }

    /**
     * Trừ đa thức hiện tại với đa thức khác.
     * @param another
     * @return đa thức hiện tại.
     */
    public ListPolynomial minus(ListPolynomial another) {
        ListPolynomial result = new ListPolynomial();
        int maxSize = Math.max(this.coefficients.size(), another.coefficients.size());
        for (int i = 0 ; i < maxSize;i++) {
            double a;
            if (i < this.coefficients.size()) {
                a = this.coefficients.get(i);
            } else {
                a = 0;
            }
            double b;
            if (i < another.coefficients.size()) {
                b = another.coefficients.get(i);
            } else {
                b = 0;
            }
            result.append(a-b);
        }
        return result;
        /* TODO */
    }

    /**
     * Nhân đa thức hiện tại với đa thức khác.
     * @param another
     * @return đa thức hiện tại.
     */
    public ListPolynomial multiply(ListPolynomial another) {
        ListPolynomial result = new ListPolynomial();
        if (this.coefficients.size() == 0 || another.coefficients.size() == 0) {
            result.append(0);
            return result;
        }
        int newSize = this.coefficients.size()+another.coefficients.size() - 1;
        for (int i = 0; i < newSize;i++) {
            result.append(0);
        }

        for (int i = 0; i < this.coefficients.size();i++) {
            for (int j = 0; j < another.coefficients.size();j++) {
                double value =  result.coefficients.get(i+j) + this.coefficients.get(i)*another.coefficients.get(j);
                result.coefficients.set(i+j,value);

            }
        }
        return result;
        /* TODO */
    }
}

