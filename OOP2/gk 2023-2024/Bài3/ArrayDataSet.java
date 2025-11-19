package Bài3;

import java.util.Arrays;

public class ArrayDataSet extends AbstractDataSet {
    private int DEFAULT_CAPACITY = 10;
    private double[] data;
    private int size;

    public ArrayDataSet() {
        this.data = new double[DEFAULT_CAPACITY];
        this.size = 0;

    }

    // Phương thức riêng để mở rộng mảng khi hết chỗ
    private void allocateMore() {
        int newCapacity = data.length * 2;
        data = Arrays.copyOf(data, newCapacity);
    }

    public void append(double x) {
        if (size >= data.length) {
            allocateMore();
        }
        data[size++] = x;
    }

    public double get(int index) {
        if (checkBoundaries(index, size)) {
            return data[index];
        } else {
            throw new ArrayIndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }
    public void insert(int index, double x) {
        if(!checkBoundaries(index, size+1)) {
            throw new ArrayIndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        if (size >= data.length) {
            allocateMore();
        }
        //// Di chuyển các phần tử sang phải để chừa chỗ cho phần tử mới
        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        // Chèn phần tử mới vào vị trí index
        data[index] = x;
        size++;
    }
    public void remove(int index) {
        if(!checkBoundaries(index, size)) {// kiểm tra xem có hợp lệ ko
            throw new ArrayIndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        //// Di chuyển các phần tử từ index + 1 sang trái để ghi đè phần tử tại index
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        //giamr kích thước mảng
        size--;
        //// Tùy chọn: Đặt phần tử cuối thành 0.0 (giá trị mặc định) nếu cần thiết
        data[size] = 0;
    }

    @Override
    //thay thế phần tử tại vị trí index bằng giá trị x
    public void set(int index,double x) {
        if(!checkBoundaries(index, size)) {
            throw new ArrayIndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        data[index] = x;
    }
   public int size() {
    return size;
   }
   public double[] toArray() {
        double[] result = new double[size]; //// Tạo một mảng mới có kích thước bằng số phần tử hiện tại
        System.arraycopy(data, 0, result, 0, size); // // Sao chép các phần tử từ mảng `data` vào `result`
        return result;
   }
}

