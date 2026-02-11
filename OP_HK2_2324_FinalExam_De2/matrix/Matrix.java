package OP_HK2_2324_FinalExam_De2.matrix;

import java.util.Arrays;
import java.util.Random;

public class Matrix {
    private double[][] data;



    /**
     * Hàm dựng, khởi tạo một ma trận có các phần tử được sinh ngẫu nhiên trong đoạn [1, 10]
     * @param rows số hàng, columns số cột
     */
    public Matrix(int rows, int columns) {
        /* TODO */
        data = new double[rows][columns];
        Random random = new Random();

        for (int i = 0; i < rows;i++) {
            for (int j = 0; j < columns;j++) {
                data[i][j] = 1 + random.nextDouble()*9;
            }
        }
    }

    /**
     * Phương thức khởi tạo ma trận, các phần tử của ma trận được sinh ngẫu nhiên trong đoạn [1, 10]
     * @param rows số hàng, columns số cột
     */
    private void initRandom(int rows, int columns) {
        /* TODO */
        data = new double[rows][columns];
        Random rand = new Random();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                // Sinh số thực trong [1, 10)
                data[i][j] = 1 + rand.nextDouble() * 9;
            }
        }
    }

    /**
     * Lấy giá trị phần tử ở vị trí (row, col).
     * @param row
     * @param col
     * @return
     */
    public double get(int row, int col) {
        /* TODO */
        if (row < 0 || col < 0 || row > data.length || col > data[0].length) {
            throw new IndexOutOfBoundsException("Chỉ số (" + row + ", " + col + ") không hợp lệ");
        }
        return data[row][col];
    }

    /**
     * Sửa giá trị phần tử ở vị trí (row, col) thành value.
     * @param row
     * @param col
     * @param value
     */
    public void set(int row, int col, double value) {
        /* TODO */
        if (row < 0 || col < 0 || row > data.length || col > data[0].length) {
            throw new IndexOutOfBoundsException("Chỉ số (" + row + ", " + col + ") không hợp lệ");
        }
        data[row][col] = value;
    }

    /**
     * Phương thức sắp xếp các phần tử của ma trận theo thứ tự tăng dần.
     * @return ma trận có các phần tử là phần tử của ma trận ban đầu được sắp xếp theo thứ tự tăng dần.
     * Các phần tử được sắp xếp theo thứ tự từ trái sang phải ở mỗi hàng, và từ trên xuống dưới.
     */
    public Matrix getSortedMatrix() {
        /* TODO */
        // gom tất cả phần tử vào mảng 1 chiều
        int row = data.length;
        int col = data[0].length;
        double[] temp = new double[row * col];
        int index = 0;
        for (int i = 0 ;i < row; i++) {
            for (int j = 0; j < col;j++) {
                temp[index++] = data[i][j];
            }
        }
        Arrays.sort(temp);
        // tạo ma trận mới
        Matrix sortMatrix = new Matrix(row,col);
        index = 0;
        for (int i = 0 ; i < row;i++) {
            for (int j = 0; j < col;j++) {
                sortMatrix.data[i][j] = temp[index++];
            }

        }
        return sortMatrix;
    }

    /**
     * Phương thức cộng ma trận hiện tại với một ma trận khác.
     * @param that
     * @return ma trận mới là ma trận tổng của 2 ma trận.
     */
    public Matrix add(Matrix that) {
        /* TODO */
        Matrix matrix = new Matrix(data.length, data[0].length);
        for (int i = 0; i < data.length;i++) {
            for (int j = 0; j < data[0].length; j ++) {
                matrix.data[i][j] = that.data[i][j] + this.data[i][j];
            }
        }
        return matrix;
    }

    /**
     * Phương thức trừ ma trận hiện tại cho một ma trận khác.
     * @param that
     * @return ma trận mới là ma trận hiệu của ma trận hiện tại và ma trận truyền vào.
     */
    public Matrix minus(Matrix that) {
        /* TODO */
        Matrix matrix = new Matrix(data.length, data[0].length);
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length;j++) {
                matrix.data[i][j] = that.data[i][j] - this.data[i][j];
            }
        }
        return matrix;
    }

    /**
     * Phương thức nhân ma trận hiện tại với một ma trận khác.
     * @param that
     * @return ma trận mới là ma trận nhân của hai ma trận.
     */
    public Matrix multiply(Matrix that) {
        /* TODO */
        int n = data.length;
        Matrix matrix = new Matrix(n,n);
        for (int i = 0; i < n;i++) {
            for (int j = 0; j < n;j++) {
                matrix.data[i][j] = 0;
                for (int k = 0 ; k < n;k++) {
                    matrix.data[i][j] += this.data[i][k]*that.data[k][j];
                }
            }
        }
        return matrix;
    }

    /**
     * Phương thức nhân ma trận với một số vô hướng.
     * @param value
     * @return ma trận mới là ma trận hiện tại được nhân với một số vô hướng.
     */
    public Matrix scaled(int value) {
        /* TODO */
        Matrix matrix = new Matrix(data.length, data[0].length);
        for (int i = 0; i < data.length;i++) {
            for (int j = 0; j < data[0].length;j++) {
                matrix.data[i][j] = this.data[i][j]*value;
            }
        }
        return matrix;
    }

    /**
     * Phương thức nhân hàng thứ rowIndex của ma trận với một số vô hướng.
     * @param value
     * @return ma trận mới là ma trận có hàng rowIndex bằng hàng rowIndex của ma trận hiện tại nhân với một số vô hướng.
     */
    public Matrix scaledRow(int value, int rowIndex) {
        /* TODO */
        Matrix matrix = new Matrix(data.length, data[0].length);
        for (int i = 0; i < data.length;i++) {
            for (int j = 0; j < data[0].length;j++) {
                matrix.data[i][j] = this.data[i][j];
            }
        }
        for (int j = 0 ; j < data[0].length;j++) {
            matrix.data[rowIndex][j] *= value;
        }
        return matrix;
    }

    /**
     * Phương thức nhân cột thứ columnIndex của ma trận với một số vô hướng.
     * @param value
     * @return ma trận mới là ma trận có cột columnIndex bằng cột columnIndex của ma trận hiện tại nhân với một số vô hướng.
     */
    public Matrix scaledColumn(int value, int columnIndex) {
        /* TODO */
        Matrix matrix = new Matrix(data.length,data[0].length);
        for (int i = 0; i < data.length;i++) {
            for (int j = 0; j < data[0].length;j++) {
                matrix.data[i][j] = data[i][j];
            }
        }
        for (int i = 0; i < data.length;i++) {
            matrix.data[i][columnIndex] *= value;
        }
        return matrix;
    }

    /**
     * Phương thức hoán đổi hai hàng của ma trận.
     * @param firstIndex
     * @param secondIndex
     */
    public void swapRows(int firstIndex, int secondIndex) {
        /* TODO */
        if (firstIndex == secondIndex) {
            return;
        }
        for (int j = 0; j < data[0].length;j++) {
            double temp = data[firstIndex][j];
            data[firstIndex][j] = data[secondIndex][j];
            data[secondIndex][j] = temp;
        }
    }

    /**
     * Phương thức hoán đổi hai cột của ma trận.
     * @param firstIndex
     * @param secondIndex
     */
    public void swapColumns(int firstIndex, int secondIndex) {
        /* TODO */
        if (firstIndex == secondIndex) {
            return;
        }
        for (int i = 0; i < data.length;i++) {
            double temp = data[i][firstIndex];
            data[i][firstIndex] = data[i][secondIndex];
            data[i][secondIndex] = temp;
        }
    }

    /**
     * Phương thức cộng hàng destIndex của ma trận với hàng sourceIndex của ma trận được nhân với một số value.
     * @param value
     * @param sourceIndex
     * @param destIndex
     */
    public void addRow(double value, int sourceIndex, int destIndex) {
        /* TODO */
        for (int j = 0; j < data[0].length;j++) {
            data[destIndex][j] += value*data[sourceIndex][j];
        }
    }

    /**
     * Phương thức cộng cột destIndex của ma trận với cột sourceIndex của ma trận được nhân với một số value.
     * @param value
     * @param sourceIndex
     * @param destIndex
     */
    public void addColumn(double value, int sourceIndex, int destIndex) {
        /* TODO */
        for (int i = 0; i < data[0].length;i++) {
            data[i][destIndex] += value*data[i][sourceIndex];
        }
    }

    /**
     * Phương thức lấy ma trận chuyển vị.
     * @return ma trận mới là ma trận chuyển vị của ma trận hiện tại.
     */
    public Matrix transpose() {
        /* TODO */
        Matrix matrix = new Matrix(data[0].length,data.length);
        for (int i = 0; i < data.length;i++) {
            for (int j = 0; j <data[0].length;j++) {
                matrix.data[j][i] = data[i][j];
            }
        }
        return matrix;
    }

    /**
     * Phương thức lấy ra ma trận dạng hình thang theo hàng (row echelon form)
     * sau khi thực hiện phép khử Gauss.
     * @return ma trận dạng hình thang theo hàng.
     */
    public Matrix gaussianElimination() {
        /* TODO */
        int rows = data.length;
        int cols = data[0].length;

        // Tạo bản sao để không làm thay đổi ma trận gốc
        Matrix result = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result.data[i][j] = data[i][j];
            }
        }

        int pivotRow = 0;

        for (int pivotCol = 0; pivotCol < cols && pivotRow < rows; pivotCol++) {

            //  Tìm hàng có phần tử khác 0 tại cột pivotCol
            int maxRow = pivotRow;
            while (maxRow < rows && Math.abs(result.data[maxRow][pivotCol]) < 1e-9) {
                maxRow++;
            }
            if (maxRow == rows) {
                continue;
            }
            result.swapRows(pivotRow, maxRow);

            // Chuẩn hoá pivot về 1
            double pivotValue = result.data[pivotRow][pivotCol];
            for (int j = pivotCol; j < cols; j++) {
                result.data[pivotRow][j] /= pivotValue;
            }

            // Khử các phần tử phía dưới pivot
            for (int i = pivotRow + 1; i < rows; i++) {
                double factor = result.data[i][pivotCol];
                if (Math.abs(factor) > 1e-9) {
                    for (int j = pivotCol; j < cols; j++) {
                        result.data[i][j] -= factor * result.data[pivotRow][j];
                    }
                }
            }
            pivotRow++;
        }
        return result;
    }

    /**
     * Biểu diễn ma trận theo định dạng
     * a11 a12 ... a1n
     * a21 a22 ... a2n
     * ...
     * am1 am2 ... amn
     * @return một chuỗi biểu diễn ma trận.
     */
    @Override
    public String toString() {
        /* TODO */
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < data.length;i++) {
            for (int j = 0; j < data[0].length;j++) {
                sb.append(data[i][j]);
                if (j < data[0].length-1) {
                    sb.append(" ");
                }
            }
            if (i < data.length - 1) {
                sb.append("\n");
            }
        }
        return sb.toString();
    }
    public int getRowCount() {
        return data.length;
    }

    public int getColumnCount() {
        return data[0].length;
    }
}

