package OOP_HK2_2324_FinalExam_De1.search;

import java.util.Random;

public class TestBinarySearch {
    public static void main(String[] args) {
        /* Yêu cầu:
        - Sinh ra ngẫu nhiên một số tự nhiên có giá trị nằm trong khoảng [20 - 30].
        - Sinh ra ngẫu nhiên một mảng các số kiểu double, có kích thước bằng số tự nhiên đã sinh ngẫu nhiên ở trên.
        - Tạo đối tượng có kiểu dữ liệu BinarySearch. Dùng đối tượng này test thuật toán tìm kiếm nhị phân với
          mảng dữ liệu đã sinh ra, và sử dụng 3 thuật toán sắp xếp khác nhau như đã cho.

          Các kết quả test được in ra terminal theo định dạng: ví dụ
          Using Bubble Sort Algorithm:
          Before sorting: [5.0 4.0 3.0 2.0 1.0]
          After sorting: [1.0 2.0 3.0 4.0 5.0]
          Binary search giá trị 3.0: 2

          Using Insertion Sort Algorithm:
          Before sorting: [5.0 4.0 3.0 2.0 1.0]
          After sorting: [1.0 2.0 3.0 4.0 5.0]
          Binary search giá trị 6.0:-1

        - Kết quả chạy chương trình lưu vào file text được đặt tên <TenSinhVien_MaSinhVien_BinarySearch.txt.
        - Nén các file source code và file text kết quả chạy chương trình vào file zip có tên
          <TenSinhVien_MaSinhVien_BinarySearch>.zip (Ví dụ, NguyenVanA_123456_BinarySearch.zip),
          nộp lên classroom
         */
        Random random = new Random();
        BinarySearch binarySearch = BinarySearch.getInstance();

        int n = random.nextInt(11) + 20;

        double[] data = new double[n];
        for (int i = 0; i < n; i++) {
            data[i] = Math.round(random.nextDouble() * 100) / 10.0;
        }

        double searchValueExist = data[random.nextInt(n)];
        double searchValueNotExist = 9999.0;

        /*Bubble Sort */
        binarySearch.setSorter(new BubbleSort());
        test(binarySearch, data, searchValueExist, "Bubble Sort Algorithm");

        /*Insertion Sort*/
        binarySearch.setSorter(new InsertionSort());
        test(binarySearch, data, searchValueNotExist, "Insertion Sort Algorithm");

        /*Selection Sort */
        binarySearch.setSorter(new SelectionSort());
        test(binarySearch, data, searchValueExist, "Selection Sort Algorithm");
    }
    private static void test(BinarySearch bs,
                             double[] original,
                             double value,
                             String algorithmName) {

        double[] copy = original.clone();
        System.out.println("Using " + algorithmName + ":");
        System.out.println("Before sorting: " + arrayToString(copy));
        int index = bs.search(copy, value);
        System.out.println("After sorting: " + arrayToString(copy));
        System.out.println("Binary search giá trị " + value + ": " + index);
        System.out.println();
    }
    private static String arrayToString(double[] data) {
        StringBuilder sb = new StringBuilder("[");
        for (double v : data) {
            sb.append(v).append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
        return sb.toString();



    }
}
