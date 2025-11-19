package SortStrategy;

public class SelectionSort implements Sorter {
    public SelectionSort() {

    }

    public void sort(double[] data, boolean order) {
        int n = data.length;
        for (int i = 0; i < n - 1; i++) {
            int index = i; // Giả sử phần tử đầu tiên là nhỏ nhất hoặc lớn nhất
            // Tìm chỉ số của phần tử nhỏ nhất hoặc lớn nhất trong phạm vi i đến n
            for (int j = i + 1; j < n; j++) {
                if (order) {
                    if (data[j] < data[index]) { // Tìm phần tử nhỏ nhất khi sắp xếp tăng dần
                        index = j;
                    }
                } else {
                    if (data[j] > data[index]) { // Tìm phần tử lớn nhất khi sắp xếp giảm dần
                        index = j;
                    }
                }
            }
            // Hoán đổi phần tử tại index với phần tử tại vị trí i
            if (index != i) { // Nếu phần tử tìm thấy không phải chính nó
                double temp = data[index];
                data[index] = data[i];
                data[i] = temp;
            }
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
