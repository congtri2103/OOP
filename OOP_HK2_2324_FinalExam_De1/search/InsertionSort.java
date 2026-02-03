package OOP_HK2_2324_FinalExam_De1.search;

public class InsertionSort implements Sorter {
    /**
     * Phương thức sắp xếp dữ liệu sử dụng thuật toán Insertion sort.
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
     * sử dụng thuật toán Insertion sort.
     * @param data
     */
    private void sortAscending(double[] data) {
        /* TODO */
        if (data == null || data.length <= 1) {
            return;
        }
        for (int i = 1; i < data.length;i++) {
            double key = data[i];
            int j = i -1;
            // Dịch các phần tử lớn hơn key sang phải
            while (j >= 0 && data[j] > key) {
                data[j+1] = data[j];
                j--;
            }
            data[j+1] = key;
        }
    }

    /**
     * Phương thức sắp xếp mảng dữ liệu theo thứ tự giảm dần,
     * sử dụng thuật toán Insertion sort.
     * @param data
     */
    private void sortDescending(double[] data) {
        /* TODO */
        if (data == null || data.length <= 1) {
            return;
        }
        for (int i = 1; i < data.length;i++) {
            double key = data[i];
            int j = i -1;

            while (j >= 0 && data[j] < key) {
                data[j+1] = data[j];
                j--;
            }
            data[j+1] = key;
        }
    }
}

