package SortStrategy;

public class InsertionSort implements Sorter {
    public InsertionSort() {

    }

    public void sort(double[] data, boolean order) {
        int n = data.length;
        for (int i = 1; i < n; i++) {
            double key = data[i];
            int j = i - 1;

            // Điều kiện sắp xếp tăng dần hoặc giảm dần
            if (order) {
                // Tăng dần
                while (j >= 0 && data[j] > key) {
                    data[j + 1] = data[j];
                    j = j - 1;
                }
            } else {
                // Giảm dần
                while (j >= 0 && data[j] < key) {
                    data[j + 1] = data[j];
                    j = j - 1;
                }
            }
            data[j + 1] = key;
        }
    }

    // Phương thức sắp xếp tăng dần
    public void sortAscending(double[] data) {
        sort(data, true); // Gọi phương thức sort với order = true
    }

    // Phương thức sắp xếp giảm dần
    public void sortDescending(double[] data) {
        sort(data, false); // Gọi phương thức sort với order = false
    }
}
