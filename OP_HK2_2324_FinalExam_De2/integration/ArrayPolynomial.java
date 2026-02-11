package OP_HK2_2324_FinalExam_De2.integration;


public class ArrayPolynomial extends AbstractPolynomial {
    private static final int DEFAULT_CAPACITY = 8;
    private double[] coefficents;
    private int size;

    /**
     * Khởi tạo dữ liệu mặc định.
     */
    public ArrayPolynomial() {
        /* TODO */
        this.coefficents = new double[DEFAULT_CAPACITY];
        this.size = 0;
    }

    /**
     * Lấy hệ số của đa thức tại phần tử index
     * @return hệ số tại phần tử index.
     */
    @Override
    public double coefficient(int index) {
        /* TODO */
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException(index);
        }
        return this.coefficents[index];
    }

    /**
     * Lấy mảng các hệ số của đa thức.
     * @return mảng các hệ số của đa thức.
     */
    @Override
    public double[] coefficients() {
        /* TODO */
        double[] result = new double[size];
        System.arraycopy(this.coefficents, 0 ,result,0,size);
        return result;
    }

    /**
     * Thêm một phần tử có hệ số coefficient vào đầu đa thức.
     * @param coefficient
     * @return đa thức hiện tại.
     */
    public ArrayPolynomial insertAtStart(double coefficient) {
        /* TODO */
        enlarge();
        this.coefficents[0] = coefficient;
        size++;
        return this;
    }

    /**
     * Thêm một phần tử có hệ số coefficient vào cuối đa thức.
     * @param coefficient
     * @return đa thức hiện tại.
     */
    public ArrayPolynomial insertAtEnd(double coefficient) {
        /* TODO */
        enlarge();
        this.coefficents[size] = coefficient;
        size++;
        return this;
    }

    /**
     * Thêm một phần tử có hệ số coefficient vào vị trí index.
     * @param coefficient
     * @param index
     * @return đa thức hiện tại.
     */
    public ArrayPolynomial insertAtPosition(double coefficient, int index) {
        /* TODO */
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException(index);
        }
        this.coefficents[index] = coefficient;
        size++;
        return this;
    }

    /**
     * Thay đổi hệ số của đa thức tại phần tử index.
     * @param coefficient
     * @param index
     * @return đa thức hiện tại.
     */
    public ArrayPolynomial set(double coefficient, int index) {
        /* TODO */
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException(index);
        }
        this.coefficents[index] = coefficient;
        return this;
    }

    /**
     * Lấy bậc của đa thức.
     * @return bậc của đa thức.
     */
    @Override
    public int degree() {
        /* TODO */
        if (size == 0) {
            return 0;
        }
        for (int i = this.size-1;i >= 0;i--) {
            if (this.coefficents[i] != 0) {
                return i;
            }
        }
        // đa thức = 0
        return 0;
    }

    /**
     * Tính giá trị của đa thức khi biết giá trị của x.
     * @return giá trị của đa thức.
     */
    @Override
    public double evaluate(double x) {
        /* TODO */
        double result = 0;
        for (int i = 0; i < this.size;i++) {
            result += this.coefficents[i]*Math.pow(x,i);
        }
        return result;
    }

    /**
     * Lấy đạo hàm của đa thức.
     * @return Đa thức kiểu ArrayPolynomial là đa thức đạo hàm của đa thức hiện tại.
     */
    @Override
    public ArrayPolynomial derivative() {
        /* TODO */
        ArrayPolynomial result = new ArrayPolynomial();
        if (this.size <= 1) {
            result.insertAtEnd(0);
            return result;
        }
        for (int i = 1; i < this.size;i++) {
            result.insertAtEnd(i*this.coefficents[i]);
        }
        return result;
    }

    /**
     * Cộng một đa thức khác vào đa thức hiện tại.
     * @param another
     * @return đa thức mới là tổng hai đa thức.
     */
    public ArrayPolynomial plus(Polynomial another) {
        /* TODO */
        ArrayPolynomial result = new ArrayPolynomial();
        int minDegree = Math.min(this.size - 1, another.degree());
        for (int i = 0; i <= minDegree; i++) {
            result.insertAtEnd(this.coefficents[i] + another.coefficient(i));
        }
        for (int i = minDegree + 1; i <= this.degree(); i++) {
            result.insertAtEnd(this.coefficents[i]);
        }
        for (int i = minDegree + 1; i <= another.degree(); i++) {
            result.insertAtEnd(another.coefficient(i));
        }
        return result;
    }

    /**
     * Cộng một đa thức khác vào đa thức hiện tại.
     * @param another
     * @return đa thức hiện tại.
     */
    public ArrayPolynomial plusTo(Polynomial another) {
        /* TODO */
        int minDegree = Math.min(this.size - 1, another.degree());
        for (int i = 0; i <= minDegree; i++) {
            this.coefficents[i] += another.coefficient(i);
        }
        for (int i = minDegree + 1; i <= another.degree(); i++) {
            this.insertAtEnd(another.coefficient(i));
        }
        return this;
    }

    /**
     * Trừ đa thức hiện tại với đa thức khác.
     * @param another
     * @return đa thức mới là hiệu hai đa thức.
     */
    public ArrayPolynomial minus(Polynomial another) {
        /* TODO */
        ArrayPolynomial result = new ArrayPolynomial();
        int minDegree = Math.min(this.size - 1, another.degree());
        for (int i = 0; i <= minDegree; i++) {
            result.insertAtEnd(this.coefficents[i] - another.coefficient(i));
        }
        for (int i = minDegree + 1; i <= this.degree(); i++) {
            result.insertAtEnd(this.coefficents[i]);
        }
        for (int i = minDegree + 1; i <= another.degree(); i++) {
            result.insertAtEnd(-another.coefficient(i));
        }
        return result;
    }

    /**
     * Trừ đa thức hiện tại cho đa thức khác.
     * @param another
     * @return đa thức hiện tại.
     */
    public ArrayPolynomial minusFrom(Polynomial another) {
        /* TODO */
        int minDegree = Math.min(this.size - 1, another.degree());
        for (int i = 0; i <= minDegree; i++) {
            this.coefficents[i] -= another.coefficient(i);
        }
        for (int i = minDegree + 1; i <= another.degree(); i++) {
            this.insertAtEnd(-another.coefficient(i));
        }
        return this;
    }

    /**
     * Nhân đa thức hiện tại với đa thức khác.
     * @param another
     * @return đa thức mới là đa thức nhân của hai đa thức.
     */
    public ArrayPolynomial multiply(Polynomial another) {
        /* TODO */
        ArrayPolynomial result = new ArrayPolynomial();
        if (this.degree() < 0 || another.degree() < 0) {
            return result;
        }
        int resultDegree = this.degree() + another.degree();
        for (int i = 0; i <= resultDegree;i++) {
            result.insertAtEnd(0);
        }
        for (int i = 0; i <= this.degree();i++) {
            for (int j = 0; j <= another.degree();j++) {
                result.coefficents[i+j] += this.coefficents[i]*another.coefficient(j);
            }
        }
        return result;

    }

    /**
     * Nhân đa thức hiện tại với đa thức khác.
     * @param another
     * @return đa thức hiện tại.
     */
    public ArrayPolynomial multiplyBy(Polynomial another) {
        /* TODO */
        ArrayPolynomial result = this.multiply(another);
        this.coefficents = result.coefficents;
        this.size = result.size;
        return this;
    }

    /**
     * Thêm kích thước để lưu đa thức khi cần thiết.
     */
    private void enlarge() {
        /* TODO */
        if (this.size == coefficents.length) {
            double[] newCoeff = new double[this.coefficents.length*2];
            System.arraycopy(this.coefficents,0,newCoeff,0,size);
            this.coefficents = newCoeff;
        }
    }
}

