package OOP_HK2_2324_FinalExam_De1.rootsolver;

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
        AbstractFunction function = new UnivariateRealFunction();

        RootSolver bisectionSolver = new BisectionSolver(1e-6, 1000);
        RootSolver secantSolver = new SecantSolver(1e-6, 1000);
        RootSolver newtonRaphsonSolver = new NewtonRaphsonSolver(1e-6, 1000);

        UnivariateRealRootFinding rootFinding = new UnivariateRealRootFinding(function, bisectionSolver);
        System.out.println("Bisection Solver: root = " + rootFinding.solve(12, 14));

        rootFinding.setRootSolver(secantSolver);
        System.out.println("Secant Solver: root = " + rootFinding.solve(12, 14));

        rootFinding.setRootSolver(newtonRaphsonSolver);
        System.out.println("Newton-Raphson Solver: root = " + rootFinding.solve(12, 14));

    }
}
