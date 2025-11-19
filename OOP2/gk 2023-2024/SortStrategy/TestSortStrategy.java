package SortStrategy;

import java.util.Arrays;

public class TestSortStrategy {

    public static void main(String[] args) {
        // Tạo đối tượng SortStrategy duy nhất bằng Singleton
        SortStrategy strategy = SortStrategy.getInstance();

        // Tạo mảng để kiểm tra
        double[] arr1 = {5.2, 3.1, 4.4, 2.8};
        System.out.println("Mảng ban đầu: " + Arrays.toString(arr1));

        // Sử dụng InsertionSort để sắp xếp
        Sorter insertionSort = new InsertionSort();
        strategy.setSortee(insertionSort); // Thiết lập chiến lược sắp xếp là InsertionSort
        System.out.println("\nSử dụng InsertionSort:");

        // Kiểm tra sắp xếp tăng dần
        strategy.sort(arr1, true);
        System.out.println("Sắp xếp tăng dần: " + Arrays.toString(arr1));

        // Kiểm tra sắp xếp giảm dần
        strategy.sort(arr1, false);
        System.out.println("Sắp xếp giảm dần: " + Arrays.toString(arr1));

        // Tạo mảng mới để kiểm tra SelectionSort
        double[] arr2 = {7.3, 1.5, 8.6, 2.4};
        System.out.println("\nMảng ban đầu: " + Arrays.toString(arr2));

        Sorter selectionSort = new SelectionSort();
        strategy.setSortee(selectionSort); // Thiết lập chiến lược sắp xếp là SelectionSort
        System.out.println("\nSử dụng SelectionSort:");

        // Kiểm tra sắp xếp tăng dần
        strategy.sort(arr2, true);
        System.out.println("Sắp xếp tăng dần: " + Arrays.toString(arr2));

        // Kiểm tra sắp xếp giảm dần
        strategy.sort(arr2, false);
        System.out.println("Sắp xếp giảm dần: " + Arrays.toString(arr2));

        // Tạo mảng mới để kiểm tra BubbleSort
        double[] arr3 = {12.4, 9.7, 4.1, 6.3};
        System.out.println("\nMảng ban đầu: " + Arrays.toString(arr3));

        Sorter bubbleSort = new BubbleSort();
        strategy.setSortee(bubbleSort); // Thiết lập chiến lược sắp xếp là BubbleSort
        System.out.println("\nSử dụng BubbleSort:");

        // Kiểm tra sắp xếp tăng dần
        strategy.sort(arr3, true);
        System.out.println("Sắp xếp tăng dần: " + Arrays.toString(arr3));

        // Kiểm tra sắp xếp giảm dần
        strategy.sort(arr3, false);
        System.out.println("Sắp xếp giảm dần: " + Arrays.toString(arr3));
    }
}
