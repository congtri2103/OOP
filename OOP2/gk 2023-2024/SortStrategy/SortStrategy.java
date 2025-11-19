package SortStrategy;

public class SortStrategy {
    private static SortStrategy instance; // Sửa thành static để đảm bảo Singleton
    private Sorter sortee;

    private SortStrategy() {
    }

    public static SortStrategy getInstance() {
        if (instance == null) {
            instance = new SortStrategy();
        }
        return instance;
    }

    public SortStrategy setSortee(Sorter sortee) {
        this.sortee = sortee;
        return this;
    }

    public void sort(double[] data, boolean order) {
        if (sortee == null) return;
        sortee.sort(data, order); // Truyền giá trị order cho Sorter
    }
}
