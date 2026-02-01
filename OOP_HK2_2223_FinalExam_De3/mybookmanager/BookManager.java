package OOP_HK2_2223_FinalExam_De3.mybookmanager;



public class BookManager {
    // Singleton pattern
    private static BookManager instance;

    private MyList bookList;

    private BookManager() {
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
     * Thêm book vào cuối danh sách.
     * @param book
     */
    public void append(Book book) {
        /* TODO */
        bookList.append(book);
    }

    /**
     * Thêm book vào danh sách ở vị trí index.
     * @param book
     * @param index
     */
    public void add(Book book, int index) {
        /* TODO */
        if (index < 0 || index >= bookList.size()) {
            throw new IndexOutOfBoundsException(index);
        }
        bookList.insert(book,index);
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
        return (Book) bookList.get(index);
    }

    /**
     * Sắp xếp danh sách book theo thứ tự số trang tăng dần.
     * @return
     */
    public MyList sortPagesIncreasing() {
        /* TODO */
        MyList newList = new MyLinkedList();
        for (int i = 0; i < bookList.size(); i++) {
            newList.append(bookList.get(i));
        }

        for (int i = 0; i < newList.size() - 1; i++) {
            for (int j = 0; j < newList.size() - i - 1; j++) {
                Book b1 = (Book) newList.get(j);
                Book b2 = (Book) newList.get(j + 1);
                if (b1.getPages() > b2.getPages()) {
                    Book temp = b1;
                    newList.set(b2, j);
                    newList.set(temp, j + 1);

                }
            }
        }
        return newList;
    }

    /**
     * Sắp xếp book theo thứ tự số trang giảm dần.
     * @return
     */
    public MyList sortPagesDecreasing() {
        /* TODO */
        MyList newList = new MyLinkedList();
        for (int i = 0; i < bookList.size(); i++) {
            newList.append(bookList.get(i));
        }

        for (int i = 0; i < newList.size() - 1; i++) {
            for (int j = 0; j < newList.size() - i - 1; i++) {
                Book b1 = (Book) newList.get(j);
                Book b2 = (Book) newList.get(j + 1);
                if (b1.getPages() < b2.getPages()) {
                    Book temp = b1;
                    newList.set(b2, j);
                    newList.set(temp, j + 1);
                }
            }
        }
        return newList;
    }

    /**
     * Sắp xếp sách theo thứ tự giá tăng dần.
     * @return
     */
    public MyList sortPriceIncreasing() {
        /* TODO */
        MyList newList = new MyLinkedList();
        for (int i = 0; i < bookList.size(); i++) {
            newList.append(bookList.get(i));
        }

        for (int i = 0; i < newList.size() - 1; i++) {
            for (int j = 0; j < newList.size() - i - 1; j++) {
                Book b1 = (Book) newList.get(j);
                Book b2 = (Book) newList.get(j + 1);
                if (b1.getPrice() > b2.getPrice()) {
                    Book temp = b1;
                    newList.set(b2, j);
                    newList.set(temp, j + 1);

                }
            }
        }
        return newList;

    }

    /**
     * Sắp xếp sách theo thứ tự giá giảm dần.
     * @return
     */
    public MyList sortPriceDecreasing() {
        /* TODO */
        MyList newList = new MyLinkedList();
        for (int i = 0; i < bookList.size(); i++) {
            newList.append(bookList.get(i));
        }

        for (int i = 0; i < newList.size() - 1; i++) {
            for (int j = 0; j < newList.size() - i - 1; j++) {
                Book b1 = (Book) newList.get(j);
                Book b2 = (Book) newList.get(j + 1);
                if (b1.getPrice() < b2.getPrice()) {
                    Book temp = b1;
                    newList.set(b2, j);
                    newList.set(temp, j + 1);

                }
            }
        }
        return newList;
    }

    /**
     * Lọc ra những sách theo nhà xuất bản.
     * @param publisher
     * @return
     */
    public MyList filterBooksOfPublisher(String publisher) {
        /* TODO */
        MyList result = new MyLinkedList();
        for (int i = 0; i < bookList.size();i++) {
            Book book = (Book) bookList.get(i);
            if (book.getPublisher().equals(publisher)) {
                result.append(book);
            }
        }
        return result;
    }

    /**
     * Lọc ra những sách theo thể loại.
     * @param genre
     * @return
     */
    public MyList filterBooksOfGenre(String genre) {
        /* TODO */
        MyList result = new MyLinkedList();
        for (int i = 0; i < bookList.size(); i++) {
            Book book = (Book) bookList.get(i);
            if (book.getGenre().equals(genre)) {
                result.append(book);
            }
        }
        return result;
    }

    /**
     * Lọc ra những sách theo tác giả.
     * @param author
     * @return
     */
    public MyList filterBooksOfAuthor(String author) {
        /* TODO */
        MyList result = new MyLinkedList();
        for (int i = 0; i < bookList.size(); i++) {
            Book book = (Book) bookList.get(i);
            if (book.getAuthor().equals(author)) {
                result.append(book);
            }
        }
        return result;
    }

    public static String titleOfBooksToString(MyList bookList) {
        StringBuilder titleOfBooks = new StringBuilder();
        titleOfBooks.append("[\n");
        MyIterator it = bookList.iterator();
        while (it.hasNext()) {
            Book book = (Book) it.next();
            titleOfBooks.append(book.getTitle()).append("\n");
        }
        return titleOfBooks.toString().trim() + "\n]";
    }

    public static void print(MyList bookList) {
        StringBuilder booksString = new StringBuilder();
        booksString.append("[\n");
        MyIterator it = bookList.iterator();
        while (it.hasNext()) {
            Book book = (Book) it.next();
            booksString.append(book.toString()).append("\n");
        }
        System.out.print(booksString.toString().trim() + "\n]");
    }
}

