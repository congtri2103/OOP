package OOP_HK2_2223_FinalExam_De1.integration;

public class IntegrationCalculatorTestDrive {
    public static void main(String[] args) {
        /*
         TODO

         - Chạy demo các hàm test.
         - Lưu kết quả chạy chương trình vào file text có tên <TenSinhVien_MaSinhVien_Integration>.txt
           (ví dụ, NguyenVanA_123456_Integration.txt)
         - Nộp file kết quả chạy chương trình (file text trên) cùng với các file source code.
         */
        testArrayPolynomial();
        testListPolynomial();
        testIntegrationCalculator();
    }


    public static void testArrayPolynomial() {
        /*
         TODO

         - Viết chương trình test các chức năng của ArrayPolynomial (thêm phần tử vào đa thức, xóa phần tử trong đa thức,
           sửa hệ số tại một phần tử, cộng 2 đa thức, trừ 2 đa thức, nhân 2 đa thức, tính giá trị của đa thức khi biết
           giá trị của x).
         */
        System.out.println("testArrayPolynomial");
        ArrayPolynomial polynomial1 = new ArrayPolynomial();
        polynomial1.append(2);  // 2x^0 = 2
        polynomial1.append(3);   // 3x^1 = 3x


        ArrayPolynomial polynomial2 = new ArrayPolynomial();
        polynomial2.append(1); // 1x^0 = 1
        polynomial2.append(4); // 4x^1 = 4x


        System.out.println("Đa thức 1: " + polynomial1.toString());
        System.out.println("Đa thức 2: " + polynomial2.toString());

        // thêm một phần tử vào một đa thức
        polynomial1.append(5); // 5x^2 = 5x^2
        System.out.println("Đa thức 1 sau khi thêm phần tử: " + polynomial1.toString());

        // Kiểm tra việc chèn một phần tử vào một vị trí số cụ thể trong đa thức
        polynomial1.insert(6,1);
        System.out.println("Đa thức 1 sau khi chèn: " + polynomial1.toString());


        // Kiểm tra việc đặt hệ số tại một chỉ số cụ thể trong đa thức
        polynomial1.set(4, 0); // Đặt hệ số tại chỉ số 0 thành 4: 4x^0 + 6x^1 + 2 + 3x = 4 + 6x + 2 + 3x
        System.out.println("Đa thức 1 sau khi đặt: " + polynomial1.toString());

        // cộng hai đa thức
        ArrayPolynomial cong = polynomial1.plus(polynomial2);
        System.out.println("Tổng hai đa thức: " + cong.toString());

        // trừ hai đa thức
        ArrayPolynomial tru = polynomial1.minus(polynomial2);
        System.out.println("Hiệu hai đa thức: " + tru.toString());

        // Kiểm tra việc tính giá trị của đa thức tại một giá trị x cụ thể
        double x = 2.0;
        double result = polynomial1.evaluate(x);
        System.out.println("Đa thức 1 được tính tại x = " + x + ": " + result);



    }

    public static void testListPolynomial() {
        /*
         TODO

         - Viết chương trình test các chức năng của ListPolynomial (thêm phần tử vào đa thức, xóa phần tử trong đa thức,
           sửa hệ số tại một phần tử, cộng 2 đa thức, trừ 2 đa thức, nhân 2 đa thức, tính giá trị của đa thức khi biết
           giá trị của x).
         */

        System.out.println();
        System.out.println("testListPolynomial");
        // Tạo các đa thức
        ListPolynomial polynomial1 = new ListPolynomial();
        polynomial1.append(2); // 2x^0 = 2
        polynomial1.append(3); // 3x^1 = 3x

        ListPolynomial polynomial2 = new ListPolynomial();
        polynomial2.append(1); // 1x^0 = 1
        polynomial2.append(4); // 4x^1 = 4x

        System.out.println("Đa thức 1: " + polynomial1.toString());
        System.out.println("Đa thức 2: " + polynomial2.toString());

    // Kiểm tra việc thêm một phần tử vào một đa thức
        polynomial1.append(5); // 5x^2 = 5x^2
        System.out.println("Đa thức 1 sau khi thêm phần tử: " + polynomial1.toString());

    // Kiểm tra việc chèn một phần tử vào một chỉ số cụ thể trong đa thức
        polynomial1.insert(6, 1); // Chèn 6x^1 tại chỉ số 1: 2 + 6x + 3x = 6x^1 + 2 + 3x
        System.out.println("Đa thức 1 sau khi chèn: " + polynomial1.toString());

    // Kiểm tra việc đặt hệ số tại một chỉ số cụ thể trong đa thức
        polynomial1.set(4, 0); // Đặt hệ số tại chỉ số 0 thành 4: 4x^0 + 6x^1 + 2 + 3x = 4 + 6x + 2 + 3x
        System.out.println("Đa thức 1 sau khi đặt: " + polynomial1.toString());

        // Kiểm tra việc cộng hai đa thức
        ListPolynomial cong = polynomial1.plus(polynomial2);
        System.out.println("Tổng hai đa thức: " + cong.toString());

        // Kiểm tra việc trừ hai đa thức
        ListPolynomial difference = polynomial1.minus(polynomial2);
        System.out.println("Hiệu hai đa thức: " + difference.toString());

        // Kiểm tra việc nhân hai đa thức
        ListPolynomial product = polynomial1.multiply(polynomial2);
        System.out.println("Tích hai đa thức: " + product.toString());

        // Kiểm tra việc tính giá trị của đa thức tại một giá trị x cụ thể
        double x = 2.0;
        double result = polynomial1.evaluate(x);
        System.out.println("Đa thức 1 được tính tại x = " + x + ": " + result);



    }

    public static void testIntegrationCalculator() {
        /*
         TODO

         - Tạo một đa thức.
         - Viết demo chương trình tính tích phân xác định của đa thức theo các phương pháp đã cho (MidpointRule, TrapezoidRule, SimpsonRule) sử dụng
           IntegrationCalculator. Các phương pháp tính tích phân có thể thay đổi ở thời gian chạy chương trình.
         - In ra thông tin phương pháp sử dụng, đa thức, và giá trị tích phân của đa thức.
         */

        System.out.println();
        System.out.println("testIntegrationCalculator");
        ArrayPolynomial polynomial = new ArrayPolynomial();
        polynomial.append(2.0);  // 2x^0 = 2
        polynomial.append(3.0);  // 3x^1 = 3x
        polynomial.append(5.0);  // 5x^2 = 5x^2

        System.out.println("Polynomial: " + polynomial.toString());

        // Create an integration calculator
        IntegrationCalculator calculator = new IntegrationCalculator(polynomial);

        // Chọn phương pháp tích phân (có thể thay đổi ở thời gian chạy)
        // Sử dụng TrapezoidRule
        Integrator method = new TrapezoidRule(0.0001, 50);  // Độ chính xác là 0.0001, số vòng tối đa là 50
        calculator.setIntegrator(method);

        // Cài đặt các giá trị biên dưới và trên của tích phân
        double lowerBound = 0.0;
        double upperBound = 2.0;

        // Tính giá trị tích phân
        double result = calculator.integrate(lowerBound, upperBound);

        // In kết quả cho phương pháp TrapezoidRule
        System.out.println();
        System.out.println("Phương pháp sử dụng: " + method.getClass().getSimpleName());
        System.out.println("Đa thức: " + polynomial.toString());
        System.out.println("Tích phân của đa thức trong khoảng [" + lowerBound + ", " + upperBound + "] là: " + result);

        // Sử dụng MidpointRule
        method = new MidpointRule(0.0001, 50);
        calculator.setIntegrator(method);
        result = calculator.integrate(lowerBound, upperBound);
        System.out.println();
        System.out.println("Phương pháp sử dụng: " + method.getClass().getSimpleName());
        System.out.println("Đa thức: " + polynomial.toString());
        System.out.println("Tích phân của đa thức trong khoảng [" + lowerBound + ", " + upperBound + "] là: " + result);

        // Sử dụng SimpsonRule
        method = new SimpsonRule(0.0001, 50);
        calculator.setIntegrator(method);
        result = calculator.integrate(lowerBound, upperBound);
        System.out.println();
        System.out.println("Phương pháp sử dụng: " + method.getClass().getSimpleName());
        System.out.println("Đa thức: " + polynomial.toString());
        System.out.println("Tích phân của đa thức trong khoảng [" + lowerBound + ", " + upperBound + "] là: " + result);




    }
}

