package Bài3;

import java.util.Arrays;

public abstract class BasicStatistics implements Statistics {
    private DataSet dataSet;

    public BasicStatistics() {
        this.dataSet = dataSet;
    }

    @Override
    public double mean() {
        double sum = 0;
        for (int i = 0; i < dataSet.size(); i++) {
            sum += dataSet.get(i);
        }
        return sum / dataSet.size(); // Tính kỳ vọng mẫu
    }

    @Override
    public double median() {
        double[] data = dataSet.toArray();
        Arrays.sort(data);
        int size = data.length;
        if (size % 2 == 1) {
            return data[size / 2]; // Trung vị khi số lượng phần tử là lẻ
        } else {
            return (data[size / 2 - 1] + data[size / 2]) / 2.0; // Trung vị khi số lượng phần tử là chẵn
        }
    }

    @Override
    public double min() {
        double min = dataSet.get(0);
        for (int i = 1; i < dataSet.size(); i++) {
            double temp = dataSet.get(i);
            if (temp < min) {
                min = temp;
            }
        }
        return min;
    }

    @Override
    public double max() {
        double max = dataSet.get(0);
        for (int i = 1; i < dataSet.size(); i++) {
            double temp = dataSet.get(i);
            if (temp > max) {
                max = temp;
            }
        }
        return max;
    }

    @Override
    public AbstractDataSet rank() {
        double[] data = dataSet.toArray();
        int n = data.length;

        // Tạo một mảng lưu trữ các chỉ số của phần tử trong mảng dữ liệu ban đầu
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }

        // Sắp xếp các chỉ số theo giá trị trong data, để có thể tính rank dễ dàng
        Arrays.sort(indices, (i1, i2) -> Double.compare(data[i1], data[i2]));

        // Tạo mảng rank để lưu rank của các phần tử
        double[] ranks = new double[n];

        // Duyệt qua các phần tử và tính rank
        for (int i = 0; i < n; i++) {
            if (i == 0 || data[indices[i]] != data[indices[i - 1]]) {
                ranks[indices[i]] = i + 1; // Nếu phần tử không trùng, rank là chỉ số hiện tại (bắt đầu từ 1)
            } else {
                int start = i;
                // Tìm tất cả các phần tử trùng giá trị
                while (i < n && data[indices[i]] == data[indices[start]]) {
                    i++;
                }
                // Tính rank trung bình cho các phần tử trùng nhau
                double averageRank = (start + 1 + i) / 2.0;
                for (int j = start; j < i; j++) {
                    ranks[indices[j]] = averageRank;
                }
                i--; // Quay lại một bước để tiếp tục với phần tử tiếp theo
            }
        }

        // Tạo DataSet mới chứa các rank
        DataSet rankedDataSet = new ArrayDataSet();
        for (double rank : ranks) {
            rankedDataSet.append(rank);
        }

        return (AbstractDataSet) rankedDataSet;
    }

    public void setDataSet(DataSet dataSet) {
        this.dataSet = dataSet;
    }

    public int size() {
        return dataSet.size();
    }

    @Override
    public double variance() {
        double mean = mean();
        double sumSquares = 0;
        for (int i = 0; i < dataSet.size(); i++) {
            sumSquares += Math.pow(dataSet.get(i) - mean, 2);
        }
        return sumSquares / (dataSet.size() - 1); // Phương sai mẫu
    }
}
