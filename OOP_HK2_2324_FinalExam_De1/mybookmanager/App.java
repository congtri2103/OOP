package OOP_HK2_2324_FinalExam_De1.mybookmanager;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App {
    private static final String COMMA_DELIMITER = ",";

    public static void main(String[] args) {
        init();
        testOriginalData();
        testFilterBooksOfAuthor();
        testFilterBooksOfPublisher();
        testFilterBooksOfGenre();
        testGetHighestPriceBook();
        testGetLowestPriceBook();
        testGetHighestNumberOfPagesBook();
        testGetLowestNumberOfPagesBook();

        /* Yêu cầu:
        - Hoàn thiện code chương trình theo mẫu đã cho.
        - Viết code để test cho tất cả các hàm test bên dưới.

        - Thực hiện chạy từng hàm test, lưu kết quả chạy chương trình và file text được đặt tên
          là <TenSinhVien_MaSinhVien_MyBookManager>.txt (Ví dụ, NguyenVanA_123456_MyBookManager.txt).
        - Nén các file source code và file text kết quả chạy chương trình vào file zip có tên
          <TenSinhVien_MaSinhVien_BookMyManager>.zip (Ví dụ, NguyenVanA_123456_BookMyManager.zip),
          nộp lên classroom.
         */
    }

    public static void init() {
        String filePath = "/Users/nguyencongtri/IdeaProjects/OOP/src/OOP_HK2_2324_FinalExam_De1/data/books.csv";
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

                Gợi ý:
                Các đội tượng Book không thể được tạo trực tiếp ở đây do hàm dựng là private,
                các đối tượng này được tạo ra bằng cách sử dụng Builder Pattern, ví dụ theo cách sau:
                Book newBook = new Book.BookBuilder(title).
                    .withAuthor(author)
                    .withGenre(genre)
                    ...
                    .build();
                */
                try {
                    Book book = new Book.BookBuilder(dataList.get(0)) // title
                            .withAuthor(dataList.get(1))
                            .withGenre(dataList.get(2))
                            .withPages(Integer.parseInt(dataList.get(3)))
                            .withPrice(Double.parseDouble(dataList.get(4)))
                            .withPublisher(dataList.get(5))
                            .build();

                    BookManager.getInstance().insertAtEnd(book);
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

        System.out.println("ORIGINAL DATA ");
        MyList list = BookManager.getInstance().getBookList();
        MyIterator it = list.iterator();

        int index = 0;
        while (it.hasNext()) {
            Book b = (Book) it.next();
            System.out.println(b);
            index++;
        }

    }

    /**
     * Test lọc ra những book theo tác giả.
     */
    public static void testFilterBooksOfAuthor() {
        /* TODO */
        System.out.println("FILTER BY AUTHOR");
        String author = "Steinbeck John";

        MyList result = BookManager.getInstance().filterBooksOfAuthor(author);
        MyIterator it = result.iterator();
        while (it.hasNext()) {
            Book b = (Book) it.next();
            System.out.println(b);
        }
    }

    /**
     * Test lọc ra những book theo nhà xuất bản.
     */
    public static void testFilterBooksOfPublisher() {
        /* TODO */
        System.out.println(" FILTER BY PUBLISHER ");
        String publisher = "Penguin";

        MyList result = BookManager.getInstance().filterBooksOfPublisher(publisher);
        MyIterator it = result.iterator();

        while (it.hasNext()) {
            Book b = (Book) it.next();
            System.out.println(b);
        }

    }

    /**
     * Test lọc ra những book theo thể loại.
     */
    public static void testFilterBooksOfGenre() {
        /* TODO */
        System.out.println(" FILTER BY GENRE ");
        String genre = "fiction";

        MyList result = BookManager.getInstance().filterBooksOfGenre(genre);
        MyIterator it = result.iterator();

        while (it.hasNext()) {
            Book b = (Book) it.next();
            System.out.println(b);
        }
    }

    /**
     * Test lấy ra sách có giá cao nhất.
     */
    public static void testGetHighestPriceBook() {
        System.out.println(" HIGHEST PRICE BOOK ");
        Book book = BookManager.getInstance().highestPriceBook();
        System.out.println(book);
    }

    /**
     * Test lấy ra sách có giá thấp nhất.
     */
    public static void testGetLowestPriceBook() {
        System.out.println("LOWEST PRICE BOOK ");
        Book book = BookManager.getInstance().lowestPriceBook();
        System.out.println(book);
    }

    /**
     * Test lấy ra sách có số trang cao nhất.
     */
    public static void testGetHighestNumberOfPagesBook() {
        System.out.println(" MOST PAGES BOOK ");
        Book book = BookManager.getInstance().highestNumberOfPagesBook();
        System.out.println(book);

    }

    /**
     * Test lấy ra sách có số trang thấp nhất.
     */
    public static void testGetLowestNumberOfPagesBook() {
        System.out.println(" LEAST PAGES BOOK ");
        Book book = BookManager.getInstance().lowestNumberOfPagesBook();
        System.out.println(book);
    }
}
