package OOP_HK2_2223_FinalExam_De3.bookmanager;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class App {
    private static final String COMMA_DELIMITER = ",";

    public static void main(String[] args) {
        init();
        testOriginalData();
        testSortPagesOfBookIncreasing();
        testSortPagesOfBookDecreasing();
         testPriceOfBooksIncreasing();
        testPriceOfBooksDecreasing();
        testFilterBooksLowestPrice();
        testFilterBooksHighestPrice();
        testFilterBooksOfAuthor();
        testFilterBooksOfPublisher();
        testFilterBooksOfGenre();

        /*
        TODO

        Viết code để test cho tất cả các hàm bên dưới.
        Thực hiện chạy từng hàm test, lưu kết quả chạy chương trình và file text được đặt tên
        là <TenSinhVien_MaSinhVien_StudentManager>.txt (Ví dụ, NguyenVanA_123456_StudentManager.txt).
        Nén các file source code và file text kết quả chạy chương trình vào file zip có tên
        <TenSinhVien_MaSinhVien_StudentManager>.zip (Ví dụ, NguyenVanA_123456_StudentManager.zip),
        nộp lên classroom.
         */
    }

    public static void init() {
        String filePath = "/Users/nguyencongtri/IdeaProjects/OOP/src/OOP_HK2_2223_FinalExam_De3/data/books.csv";
        readListData(filePath);
    }

    public static void readListData(String filePath) {
        BufferedReader dataReader = null;
        try {
            String line;
            dataReader = new BufferedReader(new FileReader(filePath));

            // Read file line by line?
            while ((line = dataReader.readLine()) != null) {
                List<String> dataList = parseDataLineToList(line);
                if (dataList.size() != 6) {
                    continue;
                }

                if (dataList.get(0).equals("title")) {
                    continue;
                }

                /*
                TODO

                Đọc được dữ liệu, tạo ra các đối tượng Book ở đây, và cho vào BookManager để quản lý.
                */
                try {
                    Book book = new Book.BookBuilder(dataList.get(0)) // title
                            .withAuthor(dataList.get(1))
                            .withGenre(dataList.get(2))
                            .withPages(Integer.parseInt(dataList.get(3)))
                            .withPrice(Double.parseDouble(dataList.get(4)))
                            .withPublisher(dataList.get(5))
                            .build();

                    BookManager.getInstance().append(book);
                    System.out.println(book);
                } catch (NumberFormatException | IndexOutOfBoundsException e) {
                    System.err.println("Lỗi định dạng dòng dữ liệu: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (dataReader != null)
                    dataReader.close();
            } catch (IOException crunchifyException) {
                crunchifyException.printStackTrace();
            }
        }
    }

    public static List<String> parseDataLineToList(String dataLine) {
        List<String> result = new ArrayList<>();
        if (dataLine != null) {
            String[] splitData = dataLine.split(COMMA_DELIMITER);
            for (int i = 0; i < splitData.length; i++) {
                result.add(splitData[i]);
            }
        }
        return result;
    }

    public static String[] parseDataLineToArray(String dataLine) {
        if (dataLine == null) {
            return null;
        }
        return dataLine.split(COMMA_DELIMITER);
    }

    public static void testOriginalData() {
        init();
        String studentIds = BookManager.getInstance().titleOfBooksToString(BookManager.getInstance().getBookList());
        System.out.print(studentIds);
    }

    public static void testSortPagesOfBookIncreasing() {
        init();
        System.out.println();
        System.out.println("Sắp xếp số trang tăng dần: ");
        List<Book> books = BookManager.getInstance().sortPagesIncreasing();
        books.stream()
                .map(Book::toString)
                .forEach(System.out::println);
    }

    public static void testSortPagesOfBookDecreasing() {
        /* TODO */
        init();
        System.out.println();
        System.out.println("Sắp xếp số trang giảm dần:");
        List<Book> books = BookManager.getInstance().sortPagesDecreasing();
        books.stream()
                .map(Book::toString)
                .forEach(System.out::println);
    }

    public static void testPriceOfBooksIncreasing() {
        /* TODO */
        init();
        System.out.println();
        System.out.println("Sắp xếp số giá tiền tăng dần:");
        List<Book> books = BookManager.getInstance().sortPriceIncreasing();
        books.stream()
                .map(Book::toString)
                .forEach(System.out::println);

    }

    public static void testPriceOfBooksDecreasing() {
        /* TODO */
        init();
        System.out.println();
        System.out.println("Sắp xếp số giá tiền giảm dần:");
        List<Book> books = BookManager.getInstance().sortPriceDecreasing();
        books.stream()
                .map(Book::toString)
                .forEach(System.out::println);

    }

    public static void testFilterBooksLowestPrice() {
        init();
        System.out.println();
        System.out.println("Lọc những quyển sách có giá thấp nhất");
        List<Book> books = BookManager.getInstance().sortPriceIncreasing();
        List<Book> nLowestPriceBooks = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            nLowestPriceBooks.add(books.get(i));
        }
        for (Book book : nLowestPriceBooks) {
            System.out.println(book.toString());
        }
    }

    public static void testFilterBooksHighestPrice() {
        /* TODO */
        init();
        System.out.println();
        System.out.println("Lọc những quyển sách có giá cao nhất");
        List<Book> books = BookManager.getInstance().sortPriceDecreasing();
        List<Book> nhightPriceBooks = new LinkedList<>();
        for (int i = 0; i < 5;i++) {
            nhightPriceBooks.add(books.get(i));
        }
        for (Book book : nhightPriceBooks) {
            System.out.println(book.toString());
        }
    }

    public static void testFilterBooksOfAuthor() {
        /* TODO */
        init();
        System.out.println();
        System.out.println("Lọc sách theo tác giả:");
        String author = "Lapierre Dominique";
        List<Book> books = BookManager.getInstance().filterBooksOfAuthor(author);
        books.stream()
                .map(Book::toString)
                .forEach(System.out::println);

    }

    public static void testFilterBooksOfPublisher() {
        /* TODO */
        init();
        System.out.println();
        System.out.println("Lọc sách theo nhà xuất bản:");
        String publisher = "Penguin";
        List<Book> books = BookManager.getInstance().filterBooksOfPublisher(publisher);
        books.stream()
                .map(Book::toString)
                .forEach(System.out::println);
    }

    public static void testFilterBooksOfGenre() {
        /* TODO */
        init();
        System.out.println();
        System.out.println("Lọc sách theo thể loại:");
        String genre = "history";
        List<Book> books = BookManager.getInstance().filterBooksOfGenre(genre);
        books.stream()
                .map(Book::toString)
                .forEach(System.out::println);

    }
}

