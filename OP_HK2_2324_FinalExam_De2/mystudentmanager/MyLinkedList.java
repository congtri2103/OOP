package OP_HK2_2324_FinalExam_De2.mystudentmanager;


public class MyLinkedList extends AbstractMyList {
    private Node head;
    private int size;

    private class MyLinkedListIterator implements MyIterator {
        private int currentPosition;

        public MyLinkedListIterator(int start) {
            /* TODO */
            currentPosition = start;

        }

        @Override
        public boolean hasNext() {
            /* TODO */
            return currentPosition < size;
        }

        @Override
        public Object next() {
            /* TODO */
            if (!hasNext()) {
                return null;
            }
            Node current = head;
            for (int i = 0; i < currentPosition;i++) {
                current = current.next;
            }
            Object data = current.data;
            currentPosition++;
            return data;
        }
    }

    /**
     * Hàm dựng khởi tạo list để chứa dữ liệu.
     */
    public MyLinkedList() {
        /* TODO */
        head = null;
        size = 0;
    }

    @Override
    public int size() {
        /* TODO */
        return size;
    }

    /**
     * Sửa dữ liệu ở vị trí index thành data.
     * @param data
     * @param index
     */
    @Override
    public void set(Object data, int index) {
        /* TODO */
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(index);
        }
        Node current = head;
        for (int i = 0; i < index;i++) {
            current = current.next;
        }
        current.data = data;
    }

    /**
     * Thêm phần tử dữ liệu vào đầu tập dữ liệu.
     * @param value giá trị của phần tử dữ liệu được thêm vào.
     */
    @Override
    public void insertAtStart(Object value) {
        /* TODO */
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
    }

    /**
     * Thêm phần tử dữ liệu vào cuối tập dữ liệu.
     * @param value giá trị của phần tử dữ liệu được thêm vào.
     */
    @Override
    public void insertAtEnd(Object value) {
        /* TODO */
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
            size++;
        }
    }

    /**
     * Thêm phần tử dữ liệu vào vị trí index của tập dữ liệu.
     * Chỉ thêm được nếu index nằm trong đoạn [0 - size()].
     * @param value
     * @param index
     */
    @Override
    public void insertAtPosition(Object value, int index) {
        /* TODO */
        if (index < 0 || index > size) {
            return;
        }
        if (index == 0) {
            insertAtStart(value);
            return;
        }
        if (index == size) {
            insertAtEnd(value);
            return;
        }

        // chèn giữa
        Node newNode = new Node(value);
        Node current = head;

        // đi tới node ở vị trí index - 1
        for (int i = 0; i < index - 1;i++) {
            current = current.next;
        }
        newNode.next = current.next;
        current.next = current;
        size++;
    }

    /**
     * Xóa phần tử dữ liệu tại vị trí index.
     * Chỉ xóa được nếu index nằm trong đoạn [0 - (size() - 1)]
     * @param index
     */
    @Override
    public void remove(int index) {
        /* TODO */
        if (index < 0 || index >= size) {
            return; // index không hợp lệ
        }

        // xóa phần tử đầu
        if (index == 0) {
            head = head.next;
            size--;
            return;
        }

        // xóa phần tử ở giữa hoặc cuối
        Node current = head;
        // đi tới node ở vị trí index - 1
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        // bỏ qua node cần xóa
        current.next = current.next.next;
        size--;
    }

    /**
     * Phương thức lấy Node ở vị trí index.
     * @param index
     * @return
     */
    private Node getNodeByIndex(int index) {
        /* TODO */
        if (index < 0 || index >= size) {
            return null;
        }

        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    @Override
    public MyIterator iterator() {
        /* TODO */
        return new MyLinkedListIterator(0);
    }
    @Override
    public Object get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(index);
        }

        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current.data;
    }
}

