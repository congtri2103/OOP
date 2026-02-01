package OOP_HK2_2223_FinalExam_De3.mybookmanager;

public class MyLinkedList extends MyAbstractList {
    private MyLinkedListNode head;
    private int size;

    /**
     * Khởi tạo dữ liệu mặc định.
     */
    public MyLinkedList() {
        /* TODO */
        head = null;
        size = 0;
    }

    /**
     * Lấy kích thước của list.
     * @return
     */
    @Override
    public int size() {
        /* TODO */
        return size;
    }

    /**
     * Lấy phần tử ở vị trí index trong list.
     * @param index
     * @return
     */
    @Override
    public Object get(int index) {
        /* TODO */
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(index);
        }
        MyLinkedListNode current = head;
        for (int i = 0; i < index;i++) {
            current = current.getNext();
        }
        return current.getPayload();

    }

    /**
     * Sửa phần tử ở vị trí index là payload.
     * @param payload
     * @param index
     */
    @Override
    public void set(Object payload, int index) {
        /* TODO */
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(index);
        }
        MyLinkedListNode current = head;
        for (int i = 0; i < index;i++) {
            current = current.getNext();
        }
        current.setPayload(payload);

    }

    /**
     * Xóa phần tử của list ở vị trí index.
     * @param index
     */
    @Override
    public void remove(int index) {
        /* TODO */
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(index);
        }
       if (index == 0) {
           head = head.getNext();
       } else {
           MyLinkedListNode current = head;
           for (int i = 0; i < index - 1;i++) {
               current = current.getNext();
           }
           current.setNext(current.getNext().getNext());
       }
       size--;
    }


    /**
     * Thêm vào cuối list phần tử có dữ liệu payload.
     * @param payload
     */
    @Override
    public void append(Object payload) {
        /* TODO */
        MyLinkedListNode newNode = new MyLinkedListNode(payload);
        if (head == null) {
            head = newNode;
        } else {
            MyLinkedListNode current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
        size++;
    }

    /**
     * Thêm vào list phần tử có dữ liệu payload ở vị trí index.
     * @param payload
     * @param index
     */
    @Override
    public void insert(Object payload, int index) {
        /* TODO */
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(index);
        }
        MyLinkedListNode newNode = new MyLinkedListNode(payload);
        if (index == 0) {
            newNode.setNext(head);
            head = newNode;
        } else {
            // Tìm node trước vị trí index
            MyLinkedListNode current = head;
            for (int i = 0; i < index - 1;i++) {
                current = current.getNext();
            }
            newNode.setNext(current.getNext());
            current.setNext(newNode);
        }
        size++;

    }

    /**
     * Tạo iterator để cho phép duyệt qua các phần tử của list.
     * @return
     */
    @Override
    public MyIterator iterator() {
        /* TODO */
        return new MyLinkedListIterator();
    }

    /**
     * Lấy node ở vị trí index.
     * @param index
     * @return
     */
    private MyLinkedListNode getNodeByIndex(int index) {
        /* TODO */
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(index);
        }
        MyLinkedListNode current = head;
        for (int i = 0; i < index;i++) {
            current = current.getNext();
        }
        return current;
    }

    /*
     * Inner class implements the Iterator pattern
     */
    private class MyLinkedListIterator implements MyIterator {
        /*
         * MyLinkedListIterator cần phải biết vị trí hiện tại khi nó đang duyệt qua dữ liệu của MyLinkedList.
         */
        private int currentPosition;

        /**
         * Khởi tạo dữ liệu cho Iterator là vị trí node đầu tiên trong MyLinkedList.
         */
        public MyLinkedListIterator() {
            /* TODO */
            currentPosition = 0;

        }

        /**
         * Kiểm tra trong MyLinkedList có còn phần tử tiếp theo không.
         * Nếu còn thì trả về true, nếu không còn thì trả về false.
         * @return
         */
        @Override
        public boolean hasNext() {
            /* TODO */
            return currentPosition < size;
        }

        /**
         * iterator dịch chuyển sang phần tử kế tiếp của MyLinkedList và trả ra dữ liệu (payload) của phần tử hiện tại của MyLinkedList.
         * @return payload của phần tử hiện tại.
         */
        @Override
        public Object next() {
            /* TODO */
            Object data = getNodeByIndex(currentPosition).getPayload();
            currentPosition++;
            return data;
        }

        /**
         * iterator xóa phần tử hiện tại của MyLinkedList.
         */
        @Override
        public void remove() {
            /* TODO */
            if (currentPosition == 0) {
                throw new IllegalStateException();
            }

            // xóa node ở vị trí currentPosition - 1
            if (currentPosition - 1 == 0) {
                head = head.getNext();
            } else {
                MyLinkedListNode prev = getNodeByIndex(currentPosition - 2);
                prev.setNext(prev.getNext().getNext());
            }

            size--;
            currentPosition--;
        }
    }
}
