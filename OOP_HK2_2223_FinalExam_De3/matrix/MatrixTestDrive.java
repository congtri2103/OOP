package OOP_HK2_2223_FinalExam_De3.matrix;

import java.util.Random;

public class MatrixTestDrive {
    public static void main(String[] args) {
        /* TODO
        Tạo ra 2 ma trận vuông có cùng kích thước là một số ngẫu nhiên nằm trong đoạn [5, 10].
        Các phần tử của ma trận được khởi tạo ngẫu nhiên có giá trị nằm trong đoạn [1, 10].

        Viết code thực hiện test các chức năng sau của các ma trận:
          - In ra 2 ma trận và 2 ma trận chuyển vị tương ứng.
          - In ra các đường chéo chính và đường chéo phụ của 2 ma trận.
          - In ra ma trận là ma trận tổng của 2 ma trận.
          - In ra ma trận là ma trận là hiệu của ma trận thứ nhất cho ma trận thứ 2.
          - In ra ma trận là ma trận tích của 2 ma trận.
          - Tìm và in ra một ma trận dạng hình thang theo hàng (row echelon form) dùng phép khử Gauss của 2 ma trận.
          - Tìm và in ra ma trận dạng hình thang theo hàng rút gọn (reduced row echelon form) dùng phép khử Gauss-Jordan.

         Lưu kết quả chạy chương trình trên terminal vào file text và nộp cùng source code chương trình.
         File text kết quả được đặt tên như sau: <TenSinhVien_MaSinhVien_Matrix.txt> (Ví dụ, NguyenVanA_123456_Matrix.txt).
         */
        Random random = new Random();
        int size = random.nextInt(6) + 5;
        SquareMatrix matrix1 = new SquareMatrix(size);
        SquareMatrix matrix2 = new SquareMatrix(size);

        for(int i = 0; i < size;i++) {
            for (int j = 0; j < size;j++) {
                matrix1.data[i][j] = 1 + random.nextDouble()*9;
                matrix2.data[i][j] = 1 + random.nextDouble()*9;
            }
        }

        System.out.println("Matrix 1: ");
        System.out.println(matrix1);
        System.out.println("Matrix 2:");
        System.out.println(matrix2);

        System.out.println("Matrix 1 chuyển vị: ");
        System.out.println(matrix1.transpose());
        System.out.println("Matrix 2 chuyển vị: ");
        System.out.println(matrix2.transpose());

        System.out.println("Matrix 1 đường chéo chính: ");
        System.out.println(java.util.Arrays.toString(matrix1.principalDiagonal()));
        System.out.println("Matrix 2 đường chéo chính: ");
        System.out.println(java.util.Arrays.toString(matrix2.principalDiagonal()));

        System.out.println("Matrix 1 đường chéo phụ: ");
        System.out.println(java.util.Arrays.toString(matrix1.secondaryDiagonal()));
        System.out.println("Matrix 2 đường chéo phụ: ");
        System.out.println(java.util.Arrays.toString(matrix2.secondaryDiagonal()));

        System.out.println("Tổng của 2 ma trận: ");
        System.out.println(matrix1.add(matrix2));
        System.out.println("Hiệu của 2 ma trận: ");
        System.out.println(matrix1.minus(matrix2));

        System.out.println("Tích 2 ma trận");
        System.out.println(matrix1.multiply(matrix2));

        System.out.println("Gauss - Matrix 1:");
        System.out.println(matrix1.gaussianElimination());
        System.out.println("Gauss - Matrix 2:");
        System.out.println(matrix2.gaussianElimination());

        System.out.println("Gauss-Jordan - Matrix 1:");
        System.out.println(matrix1.gaussJordanElimination());
        System.out.println("Gauss-Jordan - Matrix 2:");
        System.out.println(matrix2.gaussJordanElimination());

    }
}

