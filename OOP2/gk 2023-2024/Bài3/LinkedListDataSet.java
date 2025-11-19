package Bài3;

public class LinkedListDataSet extends AbstractDataSet {
    private Node head;
    private int size;

    public LinkedListDataSet() {
        head = null;
        size = 0;
    }

    // Lớp Node tùy chỉnh
    private class Node {
        double value;
        Node next;

        public Node(double value) {
            this.value = value;
            this.next = null;
        }
    }

    @Override
    public void append(double value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    @Override
    public double get(int index) {
        if (!checkBoundaries(index, size)) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return getNodeByIndex(index).value;
    }

    // Phương thức để lấy Node theo chỉ số
    private Node getNodeByIndex(int index) {
        if (!checkBoundaries(index, size)) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    @Override
    //chèn một nút mới vào vị trí chỉ định trong danh sách liên kết
    public void insert( int index,double value) {
        if(index <0 || index>size){
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Node newNode = new Node(value);
        if (index == 0) { // Chèn vào đầu danh sách
            newNode.next = head;
            head = newNode;
        }else{
            Node prevNode = getNodeByIndex(index - 1); //// Tìm nút trước vị trí chèn
            newNode.next = prevNode.next;
            prevNode.next = newNode;
        }
        size++;

    }
    @Override
    //xóa nút tại vị trí chỉ định trong danh sách liên kết:
    public void remove(int index) {
        //Kiểm tra chỉ số: Nếu index nằm ngoài phạm vi hợp lệ, ném ra ngoại lệ
        if(index <0 || index>size){
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        if (index == 0) { //Xóa nút đầu tiên
            head = head.next;
        }else {
            Node prevNode = getNodeByIndex(index - 1);
            prevNode.next = prevNode.next.next;
        }
        size--;
    }
    @Override
    public void set( int index,double value) {
        if(index <0 || index>size){
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Node currentNode = getNodeByIndex(index);
        currentNode.value = value;
    }
    public int size() {
        return size;
    }
    public double[] toArray() {
        double[] array = new double[size];//// Tạo mảng kết quả có kích thước bằng size
        Node current = head;
        //// Duyệt qua từng nút trong danh sách và sao chép giá trị vào mảng
        for(int i=0;i<size;i++){
            array[i] = current.value;
            current = current.next; //// Di chuyển đến nút tiếp theo
        }
        return array;
    }
}
