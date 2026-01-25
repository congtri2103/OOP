package OOP_HK2_2223_FinalExam_De1.integration;


public class ArrayPolynomial extends AbstractPolynomial {
    private static final int DEFAULT_CAPACITY = 2;
    private double[] coefficents;
    private int size;

    /**
     * Khởi tạo dữ liệu mặc định.
     */
    public ArrayPolynomial() {
        coefficents = new double[DEFAULT_CAPACITY];
        size = 0;

        /* TODO */
    }

    /**
     * Lấy hệ số của đa thức tại phần tử index
     * @return hệ số tại phần tử index.
     */
    @Override
    public double coefficient(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(index);
        }
        return coefficents[index];
        /* TODO */
    }

    /**
     * Lấy mảng các hệ số của đa thức.
     * @return mảng các hệ số của đa thức.
     */
    @Override
    public double[] coefficients() {
        double[] coeff = new double[size];
        for (int i = 0; i < size;i++) {
            coeff[i] = coefficents[i];
        }
        return coeff;
        /* TODO */
    }

    /**
     * Thêm một phần tử có hệ số coefficient vào cuối đa thức.
     * @param coefficient
     * @return đa thức hiện tại.
     */
    public ArrayPolynomial append(double coefficient) {
        if (size == coefficents.length) {
            double[] newCoeff = new double[coefficents.length*2];
            System.arraycopy(coefficents,0,newCoeff,0,size);
            coefficents = newCoeff;
        }
        coefficents[size] = coefficient;
        size++;
        return this;
        /* TODO */
    }

    /**
     * Thêm một phần tử có hệ số coefficient vào vị trí index.
     * @param coefficient
     * @param index
     * @return đa thức hiện tại.
     */
    public ArrayPolynomial insert(double coefficient, int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(index);
        }
        if (size == coefficents.length) {
            double[] newcoeff = new double[coefficents.length*2];
            System.arraycopy(coefficents,0,newcoeff,0,size);
            coefficents = newcoeff;
        }

        // dịch các phần tử sang phải
        for (int i = size; i > index; i--) {
            coefficents[i] = coefficents[i-1];

        }

        coefficents[index] = coefficient;
        size++;
        return this;

        /* TODO */
    }

    /**
     * Thay đổi hệ số của đa thức tại phần tử index.
     * @param coefficient
     * @param index
     * @return đa thức hiện tại.
     */
    public ArrayPolynomial set(double coefficient, int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(index);
        }
        coefficents[index] = coefficient;
        return this;


        /* TODO */
    }

    /**
     * Lấy bậc của đa thức.
     * @return bậc của đa thức.
     */
    @Override
    public int degree() {
        for (int i = size - 1;i >= 0;i--) {
            if (coefficents[i] != 0) {
                return i;
            }
        }
        return 0;
        /* TODO */
    }

    /**
     * Tính giá trị của đa thức khi biết giá trị của x.
     * @return giá trị của đa thức.
     */
    @Override
    public double evaluate(double x) {
        int result = 0;
        for (int i = 0; i < size;i++) {
            result += coefficents[i]*Math.pow(x,i);
        }
        return result;
        /* TODO */
    }

    /**
     * Lấy đạo hàm của đa thức.
     * @return Đa thức kiểu ArrayPolynomial là đa thức đạo hàm của đa thức hiện tại.
     */
    @Override
    public Polynomial derivative() {
        ArrayPolynomial result = new ArrayPolynomial();
        if (size <= 1) {
            result.append(0);
            return result;
        }
        for (int i = 1; i < size;i++) {
            result.append(coefficents[i]*i);
        }
        return result;
        /* TODO */
    }

    /**
     * Cộng một đa thức khác vào đa thức hiện tại.
     * @param another
     * @return đa thức hiện tại.
     */
    public ArrayPolynomial plus(ArrayPolynomial another) {
        ArrayPolynomial result = new ArrayPolynomial();
        // copy hệ số của this
        for (int i = 0; i < this.size;i++) {
            result.append(this.coefficents[i]);
        }

        // cộng thêm another
        for (int i = 0 ; i < another.size;i++) {
            if ( i < result.size) {
                result.coefficents[i] += another.coefficents[i];
            } else {
                result.append(another.coefficents[i]);
            }
        }
        return result;
        /* TODO */
    }

    /**
     * Trừ đa thức hiện tại với đa thức khác.
     * @param another
     * @return đa thức hiện tại.
     */
    public ArrayPolynomial minus(ArrayPolynomial another) {
        /* TODO */
        ArrayPolynomial result = new ArrayPolynomial();

        for (int i = 0; i < this.size;i++) {
            result.append(this.coefficents[i]);
        }

        for (int i = 0 ; i < another.size;i++){
            if (i < result.size) {
                result.coefficents[i] -= another.coefficents[i];
            } else {
                result.append(another.coefficents[i]);
            }
        }
        return result;
    }

    /**
     * Nhân đa thức hiện tại với đa thức khác.
     * @param another
     * @return đa thức hiện tại.
     */
    public ArrayPolynomial multiply(ArrayPolynomial another) {
        ArrayPolynomial result = new ArrayPolynomial();
        if (this.size == 0 || another.size == 0) {
            result.append(0);
            return result;
        }
        int newsize = this.size + another.size - 1;
        for (int i = 0; i < newsize;i++) {
            result.append(0);
        }

        for (int i = 0; i < this.size;i++) {
            for (int j = 0; j < another.size;j++) {
                result.coefficents[i+j] += this.coefficents[i]*another.coefficents[j];
            }
        }
        return result;
        /* TODO */
    }

    /**
     * Thêm kích thước để lưu đa thức khi cần thiết.
     */
    private void enlarge() {
        if (size == coefficents.length) {
            double[] newcoeff = new double[coefficents.length*2];
            System.arraycopy(this.coefficents,0,newcoeff,0,this.size);
            coefficents = newcoeff;
        }
        /* TODO */
    }
}
