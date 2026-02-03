package OOP_HK2_2324_FinalExam_De1.search;

public class SelectionSort implements Sorter {
    /**
     * Phương thức sắp xếp dữ liệu sử dụng thuật toán Selection sort.
     * @param data
     * @param order: true sắp xếp theo thứ tự tăng dần, false sắp xếp theo thứ tự giảm dần.
     */
    @Override
    public void sort(double[] data, boolean order) {
        /* TODO */
        if (order == true) {
            sortAscending(data);
        } else {
            sortDescending(data);
        }
    }

    /**
     * Phương thức sắp xếp mảng dữ liệu theo thứ tự tăng dần,
     * sử dụng thuật toán Selection sort.
     * @param data
     */
    private void sortAscending(double[] data) {
        /* TODO */
        if (data == null || data.length <= 1) {
            return;
        }
        int n = data.length;
        for (int i = 0; i < n - 1;i++) {
            int minIndex = i;

            for (int j = i + 1; j < n;j++) {
                if (data[j] < data[minIndex]) {
                    minIndex = j;
                }
            }
            double temp = data[i];
            data[i] = data[minIndex];
            data[minIndex] = temp;
        }
    }
    /**
     * Phương thức sắp xếp mảng dữ liệu theo thứ tự giảm dần,
     * sử dụng thuật toán Selection sort.
     * @param data
     */
    private void sortDescending(double[] data) {
        /* TODO */
        if (data == null || data.length <= 1) {
            return;
        }
        int n = data.length;
        for (int i = 0 ; i < n - 1;i++) {
            int maxIndex = i;

            // Tìm phần tử lớn nhất trong đoạn chưa sắp xếp
            for (int j = i + 1; j < n; j++) {
                if (data[j] > data[maxIndex]) {
                    maxIndex = j;
                }
            }
            double temp = data[i];
            data[i] = data[maxIndex];
            data[maxIndex] = temp;
        }
    }
}
