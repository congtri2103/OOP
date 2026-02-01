package OOP_HK2_2223_FinalExam_De3.matrix;


public class SquareMatrix extends Matrix {

    /**
     * Hàm dựng, khởi tạo một ma trận có các phần tử được sinh ngẫu nhiên trong đoạn [1, 10]
     * @param size
     */
    public SquareMatrix(int size) {
        /* TODO */
        super(size,size);

    }

    /**
     * Phương thức lấy ra các phần tử trên đường chéo chính của ma trận.
     * @return đường chéo chính của ma trận.
     */
    public double[] principalDiagonal() {
        /* TODO */
        int n = data.length;

        double[] result = new double[n];
        for (int i = 0; i < data.length;i++) {
            result[i] = data[i][i];
        }
        return result;
    }

    /**
     * Phương thức lấy ra các phần tử trên đường chéo phụ của ma trận.
     * @return đường chéo phụ của ma trận.
     */
    public double[] secondaryDiagonal() {
        /* TODO */
        int n = data.length;
        double[] result = new double[n];

        for (int i = 0; i < n;i++) {
            result[i] = data[i][n-1-i];
        }
        return result;
    }
}
