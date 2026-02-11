package OP_HK2_2324_FinalExam_De2.integration;

public class IntegrationCalculatorTestDrive {
    public static void main(String[] args) {
        /*
         TODO

         - Viết chương trình test các chức năng của đa thức và các phương pháp tính tích phân.

         - Lưu kết quả chạy chương trình vào file text có tên <TenSinhVien_MaSinhVien_Integration>.txt
           (ví dụ, NguyenVanA_123456_Integration.txt)
         - Nộp file kết quả chạy chương trình (file text trên) cùng với các file source code.
         */
        testPolynomial();
        testIntegrationCalculator();
    }

    public static void testPolynomial() {
        /*
         TODO

         - Tạo ra các đá thức kiểu ArrayPolynomial và ListPolynomial.
         - Viết chương trình test các chức năng của đa thức (thêm phần tử vào đa thức, xóa phần tử trong đa thức,
           sửa hệ số tại một phần tử, cộng 2 đa thức, trừ 2 đa thức, nhân 2 đa thức, tính giá trị của đa thức khi biết
           giá trị của x).
         - In kết quả ra terminal mỗi lần thực hiện các chức năng.
         */
        System.out.println("===== Test Polynomial =====");

        // Tạo hai đa thức kiểu ArrayPolynomial
        ArrayPolynomial poly1 = new ArrayPolynomial();
        ArrayPolynomial poly2 = new ArrayPolynomial();

        poly1.insertAtEnd(1).insertAtEnd(2).insertAtEnd(3); // f(x) = 1 + 2x + 3x^2
        poly2.insertAtEnd(3).insertAtEnd(4);               // g(x) = 3 + 4x

        System.out.println("poly1: " + poly1);
        System.out.println("poly2: " + poly2);

        poly1.insertAtStart(5);
        System.out.println("Thêm 5 vào đầu poly1: " + poly1);

        poly1.set(10, 2);
        System.out.println("Sửa hệ số tại index 2 của poly1 thành 10: " + poly1);

        poly1.insertAtPosition(4, 1);
        System.out.println("Thêm hệ số 4 tại vị trí 1 của poly1: " + poly1);

        Polynomial sum = poly1.plus(poly2);
        System.out.println("poly1 + poly2 = " + sum);

        Polynomial difference = poly1.minus(poly2);
        System.out.println("poly1 - poly2 = " + difference);

        Polynomial product = poly1.multiply(poly2);
        System.out.println("poly1 * poly2 = " + product);

        double valueAt2 = poly1.evaluate(2);
        System.out.println("poly1(2) = " + valueAt2);

    }

    public static void testIntegrationCalculator() {
        /*
         TODO

         - Tạo một đa thức.
         - Viết demo chương trình tính tích phân xác định của đa thức theo các phương pháp đã cho (MidpointRule, TrapezoidRule, SimpsonRule) sử dụng
           IntegrationCalculator. Các phương pháp tính tích phân có thể thay đổi ở thời gian chạy chương trình.
         - In ra thông tin phương pháp sử dụng, đa thức, và giá trị tích phân của đa thức.
         */
        Polynomial poly = new ArrayPolynomial();
        poly.insertAtEnd(1); // Hệ số của x^0
        poly.insertAtEnd(2); // Hệ số của x^1
        poly.insertAtEnd(1); // Hệ số của x^2

        double lower = 0.0;
        double upper = 2.0;

        // Độ chính xác và số lần lặp tối đa
        double precision = 0.0001;
        int maxIterations = 1000;

        Integrator midpointRule = new MidpointRule(precision, maxIterations);
        Integrator trapezoidRule = new TrapezoidRule(precision, maxIterations);
        Integrator simpsonRule = new SimpsonRule(precision, maxIterations);

        double midpointResult = midpointRule.integrate(poly, lower, upper);
        double trapezoidResult = trapezoidRule.integrate(poly, lower, upper);
        double simpsonResult = simpsonRule.integrate(poly, lower, upper);


        System.out.println("Tích phân xác định của f(x) = x^2 + 2x + 1 từ " + lower + " đến " + upper + ":");
        System.out.println("Phương pháp Midpoint Rule: " + midpointResult);
        System.out.println("Phương pháp Trapezoid Rule: " + trapezoidResult);
        System.out.println("Phương pháp Simpson Rule: " + simpsonResult);
    }
}
