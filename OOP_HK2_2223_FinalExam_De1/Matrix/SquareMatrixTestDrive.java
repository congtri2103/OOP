package OOP_HK2_2223_FinalExam_De1.Matrix;

import java.util.Random;

public class SquareMatrixTestDrive {
    public static void main(String[] args) {
        /* TODO
        Tạo ra 2 ma trận có cùng kích thước là một số ngẫu nhiên nằm trong đoạn [5, 10].
        Viết code thực hiện test các chức năng sau của các ma trận:
          - In ra 2 ma trận và 2 ma trận chuyển vị tương ứng.
          - In ra các đường chéo chính và đường chéo phụ của 2 ma trận.
          - In ra ma trận là ma trận tổng của 2 ma trận.
          - In ra ma trận là ma trận là hiệu của ma trận thứ nhất cho ma trận thứ 2.
          - In ra ma trận là ma trận tích của 2 ma trận.
          - In ra các số nguyên tố có trong 2 ma trận.

         Lưu kết quả chạy chương trình trên terminal vào file text và nộp cùng source code chương trình.
         File text kết quả được đặt tên như sau: <TenSinhVien_MaSinhVien_Matrix.txt> (Ví dụ, NguyenVanA_123456_Matrix.txt).
         */
        Random random = new Random();
        int size = random.nextInt(6) + 5;
        SquareMatrix matrix1 = new SquareMatrix(size);
        SquareMatrix matrix2 = new SquareMatrix(size);


        //In ra 2 ma trận và 2 ma trận chuyển vị tương ứng
        System.out.println("Matrix1: ");
        System.out.println(matrix1);
        System.out.println("Matrix1 chuyển vị: ");
        System.out.println(matrix1.transpose());
        System.out.println("Matrix2: ");
        System.out.println(matrix2);
        System.out.println("Matrix2 chuyển vị:");
        System.out.println(matrix2.transpose());


        //In ra các đường chéo chính và đường chéo phụ của 2 ma trận.
        System.out.println("Đường chéo chính matrix1 :");
        System.out.println(java.util.Arrays.toString(matrix1.principalDiagonal()));
        System.out.println("Đường chéo chính matrix2 :");
        System.out.println(java.util.Arrays.toString(matrix2.principalDiagonal()));
        System.out.println("Đường chéo phụ matrix1: ");
        System.out.println(java.util.Arrays.toString(matrix1.secondaryDiagonal()));
        System.out.println("Đường chéo phụ matrix2:");
        System.out.println(java.util.Arrays.toString(matrix2.secondaryDiagonal()));
        //In ra ma trận là ma trận tổng của 2 ma trận.
        System.out.println("Tổng hai ma trận: ");
        System.out.println(matrix1.add(matrix2));
        // In ra ma trận là ma trận là hiệu của ma trận thứ nhất cho ma trận thứ 2.
        System.out.println("Hiệu matrix1 cho matrix2: ");
        System.out.println(matrix1.minus(matrix2));
        //In ra ma trận là ma trận tích của 2 ma trận
        System.out.println("Tích hai ma trận: ");
        System.out.println(matrix1.multiply(matrix2));
        // // In ra các số nguyên tố có trong 2 ma trận
        System.out.println("Các số nguyên tố matrix1: ");
        System.out.println(java.util.Arrays.toString(matrix1.primes()));
        System.out.println("Các số nguyên tố matrix2: ");
        System.out.println(java.util.Arrays.toString(matrix2.primes()));
    }
}

