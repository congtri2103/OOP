package OP_HK2_2324_FinalExam_De2.integration;

import java.util.ArrayList;
import java.util.List;

public class ListPolynomial extends AbstractPolynomial {
    private List<Double> coefficients;

    /**
     * Khởi tạo dữ liệu mặc định.
     */
    public ListPolynomial() {
        /* TODO */
        coefficients = new ArrayList<Double>();
    }

    /**
     * Lấy hệ số của đa thức tại vị trí index.
     * @return
     */
    @Override
    public double coefficient(int index) {
        /* TODO */
        if (index < 0 || index >= coefficients.size()) {
            throw new IndexOutOfBoundsException(index);
        }
        return coefficients.get(index);
    }

    /**
     * Lấy các hệ số của đa thức.
     * @return
     */
    @Override
    public double[] coefficients() {
        /* TODO */
        double[] array = new double[coefficients.size()];
        for (int i = 0; i < coefficients.size();i++) {
            array[i] = coefficients.get(i);
        }
        return array;
    }

    /**
     * Thêm phần tử có hệ số coefficient vào đầu đa thức.
     * @param coefficient
     * @return đa thức hiện tại.
     */
    public ListPolynomial insertAtStart(double coefficient) {
        /* TODO */
        coefficients.add(0,coefficient);
        return this;

    }

    /**
     * Thêm phần tử có hệ số coefficient vào cuối đa thức.
     * @param coefficient
     * @return đa thức hiện tại.
     */
    public ListPolynomial insertAtEnd(double coefficient) {
        /* TODO */
        coefficients.add(coefficient);
        return this;
    }

    /**
     * Thêm phần tử có hệ số coefficient vào vị trí index.
     * @param coefficient
     * @param index
     * @return đa thức hiện tại.
     */
    public ListPolynomial insertAtPosition(double coefficient, int index) {
        /* TODO */
        if (index < 0 || index >= coefficients.size()) {
            throw new IndexOutOfBoundsException();
        }
        coefficients.add(index, coefficient);
        return this;
    }

    /**
     * Sửa hệ số của phần tử index là coefficient.
     * @param coefficient
     * @param index
     * @return đa thức hiện tại.
     */
    public ListPolynomial set(double coefficient, int index) {
        /* TODO */
        if (index < 0 || index >= coefficients.size()) {
            throw new IndexOutOfBoundsException();
        }
        coefficients.set(index,coefficient);
        return this;
    }

    /**
     * Lấy ra bậc của đa thức.
     * @return
     */
    @Override
    public int degree() {
        /* TODO */
        for (int i = coefficients.size() - 1; i >= 0; i--) {
            if (coefficients.get(i) != 0) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Tính giá trị của đa thức khi biết giá trị của x.
     * @return
     */
    @Override
    public double evaluate(double x) {
        /* TODO */
        double result = 0;
        for (int i = 0; i < coefficients.size();i++) {
            result += coefficients.get(i)*Math.pow(x,i);
        }
        return result;
    }

    /**
     * Lấy đạo hàm của đa thức.
     * @return Đa thức kiểu ListPolynomial là đa thức đạo hàm của đa thức ban đầu.
     */
    @Override
    public ListPolynomial derivative() {
        /* TODO */
        ListPolynomial result = new ListPolynomial();
        for (int i = 1; i < coefficients.size();i++) {
            double coefficient = coefficients.get(i)*i;
            result.insertAtEnd(coefficient);
        }
        return result;
    }

    /**
     * Cộng đa thức hiện tại với đa thức khác.
     * @param another
     * @return đa thức mới là tổng hai đa thức.
     */
    public ListPolynomial plus(Polynomial another) {
        /* TODO */
        ListPolynomial result = new ListPolynomial();
        int thisDegree = this.degree();
        int anotherDegree = another.degree();
        int minDegree = Math.min(thisDegree, anotherDegree);
        for (int i = 0; i <= minDegree; i++) {
            result.insertAtEnd(this.coefficients.get(i) + another.coefficient(i));
        }
        for (int i = minDegree + 1; i <= thisDegree; i++) {
            result.insertAtEnd(this.coefficients.get(i));
        }
        for (int i = minDegree + 1; i <= anotherDegree; i++) {
            result.insertAtEnd(another.coefficient(i));
        }
        return result;
    }

    /**
     * Cộng đa thức hiện tại với đa thức khác.
     * @param another
     * @return đa thức hiện tại.
     */
    public ListPolynomial plusTo(Polynomial another) {
        /* TODO */
        int thisDegree = this.degree();
        int anotherDegree = another.degree();
        int minDegree = Math.min(thisDegree, anotherDegree);
        // Cộng các hệ số cùng bậc
        for (int i = 0; i <= minDegree; i++) {
            double newCoeff = this.coefficients.get(i) + another.coefficient(i);
            this.coefficients.set(i, newCoeff);
        }
        for (int i = minDegree + 1; i <= anotherDegree; i++) {
            this.coefficients.add(another.coefficient(i));
        }

        return this;
    }

    /**
     * Trừ đa thức hiện tại với đa thức khác.
     * @param another
     * @return đa thức mới là hiệu hai đa thức.
     */
    public ListPolynomial minus(Polynomial another) {
        /* TODO */
        ListPolynomial result = new ListPolynomial();
        int thisDegree = this.degree();
        int anotherDegree = another.degree();
        int minDegree = Math.min(thisDegree, anotherDegree);
        for (int i = 0; i <= minDegree; i++) {
            result.insertAtEnd(this.coefficients.get(i) - another.coefficient(i));
        }
        for (int i = minDegree + 1; i <= thisDegree; i++) {
            result.insertAtEnd(this.coefficients.get(i));
        }
        for (int i = minDegree + 1; i <= anotherDegree; i++) {
            result.insertAtEnd(-another.coefficient(i));
        }
        return result;
    }

    /**
     * Trừ đa thức hiện tại cho đa thức khác.
     * @param another
     * @return đa thức hiện tại.
     */
    public ListPolynomial minusFrom(Polynomial another) {
        /* TODO */
        int thisDegree = this.degree();
        int anotherDegree = another.degree();
        int minDegree = Math.min(thisDegree, anotherDegree);
        // Cộng các hệ số cùng bậc
        for (int i = 0; i <= minDegree; i++) {
            double newCoeff = this.coefficients.get(i) - another.coefficient(i);
            this.coefficients.set(i, newCoeff);
        }
        for (int i = minDegree + 1; i <= anotherDegree; i++) {
            this.coefficients.add(- another.coefficient(i));
        }

        return this;
    }

    /**
     * Nhân đa thức hiện tại với đa thức khác.
     * @param another
     * @return đa thức mới là đa thức nhân của hai đa thức.
     */
    public ListPolynomial multiply(Polynomial another) {
        /* TODO */
        ListPolynomial result = new ListPolynomial();

        int degree1 = this.degree();
        int degree2 = another.degree();

        // Khởi tạo result với toàn hệ số 0
        for (int i = 0; i <= degree1 + degree2; i++) {
            result.insertAtEnd(0.0);
        }

        // Nhân từng cặp hệ số
        for (int i = 0; i <= degree1; i++) {
            for (int j = 0; j <= degree2; j++) {
                double value = result.coefficient(i + j) + this.coefficients.get(i) * another.coefficient(j);

                result.set(value, i + j);
            }
        }
        return result;
    }

    /**
     * Nhân đa thức hiện tại với đa thức khác.
     * @param another
     * @return đa thức hiện tại.
     */
    public ListPolynomial multiplyBy(Polynomial another) {
        /* TODO */
        ListPolynomial result = this.multiply(another);
        this.coefficients.clear();
        for (int i = 0; i < result.coefficients.size(); i++) {
            this.coefficients.add(result.coefficients.get(i));
        }
        return this;
    }
}
