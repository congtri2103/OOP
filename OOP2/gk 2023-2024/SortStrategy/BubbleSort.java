package SortStrategy;

public class BubbleSort implements Sorter{
    public BubbleSort() {
    }
    //Để triển khai phương thức sort trong lớp BubbleSort, ta sẽ thêm logic để sắp xếp mảng double[] theo thứ tự tăng dần hoặc giảm dần tùy thuộc vào giá trị của tham số order. Nếu order là true, mảng sẽ được sắp xếp theo thứ tự tăng dần, còn nếu order là false, mảng sẽ được sắp xếp theo thứ tự giảm dần.
    public void sort(double[] data, boolean order) {
        int n = data.length;
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-i-1;j++){
                if((order && data[j]>data[j+1]) || (!order && data[j]<data[j+1])){
                    double temp = data[j];
                    data[j] = data[j+1];
                    data[j+1] = temp;
                }
            }
        }
    }
    //sắp xếp khoảng trống công khai Tăng dần(double[] data){
    public void sortAscending(double[] data){
        sort(data,true);
    }
    //sắp xếp khoảng trống công khai Giảm dần
    public void sortDescending(double[] data){
        sort(data,false);
    }
}
