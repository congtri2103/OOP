package OOP_HK2_2324_FinalExam_De1.mybookmanager;


public class BookManager {
    private static BookManager instance;
    private MyList bookList;

    private BookManager() {
        /* TODO */
        bookList = new MyLinkedList();
    }
    public static BookManager getInstance() {
        /* TODO */
        if (instance == null) {
            instance = new BookManager();
        }
        return instance;
    }
    public MyList getBookList() {
        /* TODO */
        return this.bookList;
    }

    /**
     * Thêm book vào đầu danh sách.
     * @param book
     */
    public void insertAtStart(Book book) {
        /* TODO */
        bookList.insertAtStart(book);
    }

    /**
     * Thêm book vào cuối danh sách.
     * @param book
     */
    public void insertAtEnd(Book book) {
        /* TODO */
        bookList.insertAtEnd(book);
    }

    /**
     * Thêm book vào danh sách ở vị trí index.
     * @param book
     * @param index
     */
    public void insertAPosition(Book book, int index) {
        /* TODO */
        if (index < 0 || index >= bookList.size()) {
            throw new IndexOutOfBoundsException(index);
        }
        bookList.insertAtPosition(book,index);
    }

    /**
     * Xóa book ở vị trí index.
     * @param index
     */
    public void remove(int index) {
        /* TODO */
        if (index < 0 || index >= bookList.size()) {
            throw new IndexOutOfBoundsException(index);
        }
        bookList.remove(index);
    }

    /**
     * Lấy ra book ở vị trí index
     * @param index
     * @return
     */
    public Book bookAt(int index) {
        /* TODO */
        if (index < 0 || index >= bookList.size()) {
            throw new IndexOutOfBoundsException(index);
        }

        MyIterator iterator = bookList.iterator();
        int currentIndex = 0;
        while (iterator.hasNext()) {
            Book book = (Book) iterator.next();
            if (currentIndex == index) {
                return book;
            }
            currentIndex++;
        }
        return null;
    }

    /**
     * Lấy ra sách có giá cao nhất.
     * @return
     */
    public Book highestPriceBook() {
        MyIterator iter = bookList.iterator();
        Book max = (Book) iter.next();
        while (iter.hasNext()) {
            Book book = (Book) iter.next();
            if (book.getPrice() > max.getPrice()) {
                max = book;
            }
        }
        return max;
    }

    /**
     * Lấy ra sách có giá thấp nhất.
     * @return
     */
    public Book lowestPriceBook() {
        MyIterator iter = bookList.iterator();
        Book min = (Book) iter.next();
        while (iter.hasNext()) {
            Book book = (Book) iter.next();
            if (book.getPrice() < min.getPrice()) {
                min = book;
            }
        }
        return min;

    }

    /**
     * Lấy ra sách có số trang cao nhất.
     * @return
     */
    public Book highestNumberOfPagesBook() {
        MyIterator iter = bookList.iterator();
        Book max = (Book) iter.next();
        while (iter.hasNext()) {
            Book book = (Book) iter.next();
            if (book.getPages() > max.getPages()) {
                max = book;
            }
        }
        return max;
    }

    /**
     * Lấy ra sách có số trang thấp nhất.
     * @return
     */
    public Book lowestNumberOfPagesBook() {
        MyIterator iter = bookList.iterator();
        Book min = (Book) iter.next();
        while (iter.hasNext()) {
            Book book = (Book) iter.next();
            if (book.getPages() < min.getPages()) {
                min = book;
            }
        }
        return min;
    }

    /**
     * Lọc ra những book theo nhà xuất bản.
     * @param publisher
     * @return
     */
    public MyList filterBooksOfPublisher(String publisher) {
        /* TODO */
        MyList result = new MyLinkedList();
        MyIterator iter = bookList.iterator();
        while (iter.hasNext()) {
            Book book = (Book) iter.next();
            if (book.getPublisher().equalsIgnoreCase(publisher.trim())) {
                result.insertAtEnd(book);
            }
        }
        return result;
    }

    /**
     * Lọc ra những book theo thể loại.
     * @param genre
     * @return
     */
    public MyList filterBooksOfGenre(String genre) {
        /* TODO */
        MyList result = new MyLinkedList();
        MyIterator iter = bookList.iterator();
        while (iter.hasNext()) {
            Book book = (Book) iter.next();
            if (book.getGenre().equalsIgnoreCase(genre)) {
                result.insertAtEnd(book);
            }
        }
        return result;
    }

    /**
     * Lọc ra những book theo tác giả.
     * @param author
     * @return
     */
    public MyList filterBooksOfAuthor(String author) {
        /* TODO */
        MyList result = new MyLinkedList();
        MyIterator iter = bookList.iterator();
        while (iter.hasNext()) {
            Book book = (Book) iter.next();
            if (book.getAuthor().trim().equalsIgnoreCase(author.trim())) {
                result.insertAtEnd(book);
            }
        }
        return result;
    }
}
