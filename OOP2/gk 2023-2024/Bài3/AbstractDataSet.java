package Bài3;

import java.util.Arrays;

public abstract class AbstractDataSet implements DataSet {
    public AbstractDataSet() {

    }
    //kiểm tra chỉ số có nằm trong phạm vi hay không
    public boolean checkBoundaries(int index, int size) {
        return index >= 0 && index < size;
    }
    public String toString(){
        return Arrays.toString(toArray());
    }
}
