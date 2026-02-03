package OOP_HK2_2324_FinalExam_De1.search;

public class BinarySearch implements Search {
    private static BinarySearch instance;
    private Sorter sorter;

    public BinarySearch() {
        /* TODO */
        sorter = new BubbleSort();
    }

    /**
     * Tạo đối tượng BinarySearch.
     * @return
     */
    public static BinarySearch getInstance() {
        /* TODO */
        if (instance == null) {
            instance = new BinarySearch();
        }
        return instance;
    }

    public void setSorter(Sorter sorter) {
        /* TODO */
        this.sorter = sorter;
    }

    @Override
    public int search(double[] data, double value) {
        sort(data);
        return binarySearch(data, value);
    }

    private int binarySearch(double[] data, double value) {
        /* TODO */
        int left = 0;
        int right = data.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (data[mid] == value) {
                return mid;
            } else if (data[mid] < value) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    private void sort(double[] data) {
        /* TODO */
        sorter.sort(data,true);
    }
}
