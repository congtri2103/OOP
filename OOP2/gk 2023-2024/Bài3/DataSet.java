package Bài3;

public interface DataSet {
    public void  append(double x);
    public double get(int index);
    public void insert(int index, double x);
    public void remove(int index);
    public void set(int index, double x);
    public int size();
    public double[] toArray();
}
