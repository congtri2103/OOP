package OOP_HK2_2223_FinalExam_De1.Matrix;
import java.util.ArrayList;
import java.util.List;

public class SquareMatrix {
    private int[][] data;
    /**
     * Hàm dựng, khởi tạo một ma trận có các phần tử được sinh ngẫu nhiên trong khoảng [1, 100]
     * @param size
     */
    public SquareMatrix(int size) {
        initRandom(size);
    }
    /**
     * Phương thức khởi tạo ma trận, các phần tử của ma trận được sinh ngẫu nhiên trong khoảng [1, 100]
     * @param size
     */
    private void initRandom(int size) {
        /* TODO */
        data = new int[size][size];
        java.util.Random random = new java.util.Random();

        for (int i = 0; i < size;i++) {
            for (int j = 0; j < size;j++) {
                data[i][j] = random.nextInt(100) + 1; // [1, 100]
            }
        }
    }
    /**
     * Phương thức lấy ra các phần tử trên đường chéo chính của ma trận.
     * @return đường chéo chính của ma trận.
     */
    public int[] principalDiagonal() {
        int[] array = new int[data.length];
        for (int i = 0; i < data.length;i++) {
            for (int j = 0; j < data[0].length;j++) {
                if (i == j) {
                    array[i] = data[i][j];
                }
            }
        }
        return array;
        /* TODO */
    }

    /**
     * Phương thức lấy ra các phần tử trên đường chéo phụ của ma trận.
     * @return đường chéo phụ của ma trận.
     */
    public int[] secondaryDiagonal() {
        /* TODO */
        int n = data.length;
        int[] array = new int[n];
        for (int i = 0; i < n;i++) {
            array[i] = data[i][n-i-1];
        }
        return array;
    }
    /**
     * Phương thức lấy ra các số là số nguyên tố trong ma trận.
     * @return các số nguyên tố trong ma trận.
     */
    public int[] primes() {
        ArrayList<Integer> primeList = new ArrayList<>();
        for (int i = 0;i < data.length;i++) {
            for (int j = 0; j < data[0].length;j++) {
                if (isPrime(data[i][j])) {
                    primeList.add(data[i][j]);
                }
            }
        }
        int[] primes = new int[primeList.size()];
        for (int i = 0; i < primeList.size();i++) {
            primes[i] = primeList.get(i);
        }
        return primes;
        /* TODO */
    }
    public  boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        for (int i = 2;i*i<number;i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Phương thức sắp xếp các phần tử của ma trận theo thứ tự tăng dần.
     * @return ma trận có các phần tử là phần tử của ma trận ban đầu được sắp xếp theo thứ tự tăng dần.
     * Các phần tử được sắp xếp theo thứ tự từ trái sang phải ở mỗi hàng, và từ trên xuống dưới.
     */
    public SquareMatrix getSortedMatrix() {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < data.length;i++) {
            for (int j = 0; j < data[0].length;j++) {
                result.add(data[i][j]);
            }
        }
        for (int i = 0; i < result.size() - 1;i++) {
            for (int j = 0; j < result.size() - i - 1; i++) {
                if (result.get(j) > result.get(j + 1)) {
                    int temp = result.get(j);
                    result.set(j, result.get(j + 1));
                    result.set(j + 1, temp);
                }
            }
        }
        // Gán lại vào ma trận mới
        SquareMatrix sortedMatrix = new SquareMatrix(data.length);
        int index = 0;
        for (int i = 0; i < data.length;i++) {
            for (int j = 0; j < data[0].length;j++) {
                sortedMatrix.data[i][j] = result.get(index++);
            }
        }
        return sortedMatrix;

        /* TODO */
    }

    /**
     * Lấy giá trị phần tử ở vị trí (row, col).
     * @param row
     * @param col
     * @return
     */
    public int get(int row, int col) {
        /* TODO */
        if (row < 0 || row >= data.length || col < 0 || col >= data[0].length) {
            throw new IndexOutOfBoundsException("Chỉ số hàng hoặc cột không hợp lệ");
        }
        return data[row][col];
    }

    /**
     * Sửa giá trị phần tử ở vị trí (row, col) thành value.
     * @param row
     * @param col
     * @param value
     */
    public void set(int row, int col, int value) {
        /* TODO */
        if (row < 0 || row >= data.length || col < 0 || col >= data[0].length) {
            throw new IndexOutOfBoundsException("Chỉ số hàng hoặc cột không hợp lệ");
        }
        data[row][col] = value;
    }

    /**
     * Phương thức cộng ma trận hiện tại với một ma trận khác.
     * @param that
     * @return ma trận mới là ma trận tổng của 2 ma trận.
     */
    public SquareMatrix add(SquareMatrix that) {
        /* TODO */
        SquareMatrix matrix = new SquareMatrix(data.length);
        for (int i = 0 ; i < data.length;i++) {
            for (int j = 0; j < data[0].length;j++) {
                matrix.data[i][j] = this.data[i][j] + that.data[i][j];
            }
        }
        return matrix;
    }

    /**
     * Phương thức trừ ma trận hiện tại cho một ma trận khác.
     * @param that
     * @return ma trận mới là ma trận hiệu của ma trận hiện tại và ma trận truyền vào.
     */
    public SquareMatrix minus(SquareMatrix that) {
        SquareMatrix result = new SquareMatrix(data.length);
        for (int i = 0; i < data.length;i++) {
            for (int j = 0;j < data[0].length;j++) {
                result.data[i][j] = that.data[i][j] + this.data[i][j];
            }
        }
        return result;
        /* TODO */
    }

    /**
     * Phương thức nhân ma trận hiện tại với một ma trận khác.
     * @param that
     * @return ma trận mới là ma trận nhân của ma trận hiện tại với ma trận truyền vào.
     */
    public SquareMatrix multiply(SquareMatrix that) {
        int n = data.length;
        SquareMatrix result = new SquareMatrix(n);

        for (int i = 0; i < n;i++) {
            for (int j = 0; j < n;j++) {
                result.data[i][j] = 0;
                for (int k = 0 ; k < n;k++) {
                    result.data[i][j] += this.data[i][k]*that.data[k][j];
                }
            }
        }
        return result;
        /* TODO */
    }

    /**
     * Phương thức nhân ma trận với một số vô hướng.
     * @param value
     * @return ma trận mới là ma trận hiện tại được nhân với một số vô hướng.
     */
    public SquareMatrix scaled(int value) {
        /* TODO */
        int n = data.length;
        SquareMatrix result = new SquareMatrix(n);
        for (int i = 0; i < n;i++) {
            for (int j = 0; j < n;j++) {
                result.data[i][j] = this.data[i][j]*value;
            }
        }
        return result;
    }

    /**
     * Phương thức lấy ma trận chuyển vị.
     * @return ma trận mới là ma trận chuyển vị của ma trận hiện tại.
     */
    public SquareMatrix transpose() {

        /* TODO */
        int n = data.length;
        SquareMatrix result = new SquareMatrix(n);
        for (int i = 0; i < n;i++) {
            for (int j = 0; j < n;j++) {
               result.data[i][j] = data[j][i];
            }
        }
        return result;
    }

    /**
     * Mô tả ma trận theo định dạng biểu diễn ma trận, ví dụ
     *   1 2 3
     *   4 5 6
     *   7 8 9
     * @return một chuỗi mô tả ma trận.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < data.length;i++) {
            for (int j = 0; j < data[0].length;j++) {
                sb.append(data[i][j]).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
        /* TODO */
    }
}
