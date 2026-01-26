package OOP_HK2_2223_FinalExam_De2.rootsolver;

public class RootFindingTestDrive {
    public static void main(String[] args) {
        /*
        TODO

        Chạy các hàm test để test chương trình.
        Lưu kết quả chạy chương trình vào file text có tên <TenSinhVien_MaSinhVien_RootFinding>.txt
        (ví dụ, NguyenVanA_123456_RootFinding.txt).
        Nén tất cả các file source code và file kết quả chạy chương trình vào file zip có tên
        <TenSinhVien_MaSinhVien_RootFinding>.zip (ví dụ, NguyenVanA_123456_RootFinding.txt), và nộp bài
        lên classroom.
        */
        testRootSolver();


    }

    public static void testRootSolver() {
        /*
         TODO
         - Viết chương trình tìm nghiệm của hàm (sin(x).x - 3) theo các phương pháp đã cho (Bisection, Newton-Raphson, Secant) sử dụng
           UnivariateRealRootFinding. Các phương pháp tìm nghiệm của thể thay đổi ở thời gian chạy chương trình.
         - In ra phương pháp sử dụng, hàm và nghiệm của hàm tìm được.
         */

        System.out.println("TEST ROOT SOLVER");
        // Hàm f(x) = sin(x)*x - 3
        AbstractFunction function = new UnivariateRealFunction();
        UnivariateRealRootFinding solver = new UnivariateRealRootFinding(function);
        double lower = 5.0;
        double upper = 7.0;

        RootSolver bisection = new BisectionSolver(1e-6, 100);
        solver.setRootSolver(bisection);
        double root = solver.solve(lower, upper);
        System.out.println();
        System.out.println("Phương pháp: Bisection");
        System.out.println("Hàm: f(x) = sin(x)*x - 3");
        System.out.println("Nghiệm: " + root);


        RootSolver newton = new NewtonRaphsonSolver(1e-6, 100);
        solver.setRootSolver(newton);
        root = solver.solve(lower, upper);
        System.out.println();
        System.out.println("Phương pháp: Newton-Raphson");
        System.out.println("Hàm: f(x) = sin(x)*x - 3");
        System.out.println("Nghiệm: " + root);



        RootSolver secant = new SecantSolver(1e-6, 100);
        solver.setRootSolver(secant);
        root = solver.solve(lower, upper);
        System.out.println();
        System.out.println("Phương pháp: Secant");
        System.out.println("Hàm: f(x) = sin(x)*x - 3");
        System.out.println("Nghiệm: " + root);



    }
}
