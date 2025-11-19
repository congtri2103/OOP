package Bài3;

public class TestStatistics {

    public TestStatistics() {
    }

    public static void main(String[] args) {
        TestStatistics test = new TestStatistics();
        test.testStatisticsUsingArrayDataSet();
        test.testStatisticsUsingArray();
    }

    // Kiểm thử các phương thức thống kê với ArrayDataSet
    public void testStatisticsUsingArrayDataSet() {
        // Khởi tạo dữ liệu và đối tượng BasicStatistics
        ArrayDataSet dataSet = new ArrayDataSet();
        dataSet.append(3);
        dataSet.append(2);
        dataSet.append(4);
        dataSet.append(2);
        dataSet.append(5);

        BasicStatistics stats = new BasicStatistics() {}; // Cần một lớp con để implement Statistics

        stats.setDataSet(dataSet);

        // Kiểm tra các phương thức thống kê
        System.out.println("Using ArrayDataSet:");
        System.out.println("Mean: " + stats.mean()); // Trung bình
        System.out.println("Median: " + stats.median()); // Trung vị
        System.out.println("Min: " + stats.min()); // Giá trị nhỏ nhất
        System.out.println("Max: " + stats.max()); // Giá trị lớn nhất
        System.out.println("Variance: " + stats.variance()); // Phương sai
        System.out.println("Rank: ");
        AbstractDataSet rankedDataSet = stats.rank(); // Xếp hạng
        for (int i = 0; i < rankedDataSet.size(); i++) {
            System.out.print(rankedDataSet.get(i) + " ");
        }
        System.out.println();
    }

    // Kiểm thử các phương thức thống kê với Array (Mảng đơn giản)
    public void testStatisticsUsingArray() {
        // Khởi tạo mảng dữ liệu
        double[] data = {3, 2, 4, 2, 5};

        ArrayDataSet dataSet = new ArrayDataSet();
        for (double value : data) {
            dataSet.append(value);
        }

        BasicStatistics stats = new BasicStatistics() {}; // Cần một lớp con để implement Statistics

        stats.setDataSet(dataSet);

        // Kiểm tra các phương thức thống kê
        System.out.println("Using Array:");
        System.out.println("Mean: " + stats.mean()); // Trung bình
        System.out.println("Median: " + stats.median()); // Trung vị
        System.out.println("Min: " + stats.min()); // Giá trị nhỏ nhất
        System.out.println("Max: " + stats.max()); // Giá trị lớn nhất
        System.out.println("Variance: " + stats.variance()); // Phương sai
        System.out.println("Rank: ");
        AbstractDataSet rankedDataSet = stats.rank(); // Xếp hạng
        for (int i = 0; i < rankedDataSet.size(); i++) {
            System.out.print(rankedDataSet.get(i) + " ");
        }
        System.out.println();
    }
}
