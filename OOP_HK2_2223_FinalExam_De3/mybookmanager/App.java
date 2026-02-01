package OOP_HK2_2223_FinalExam_De3.mybookmanager;


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
        String studentIds = BookManager.getInstance().titleOfBooksToString(BookManager.getInstance().getBookList());
        System.out.print(studentIds);
    }

    public static void testSortPagesOfBookIncreasing() {
        /* TODO */
        System.out.println();
        System.out.println("Sắp xếp số trang tăng dần: ");
        MyList book = BookManager.getInstance().sortPagesIncreasing();
        for (int i = 0; i < book.size(); i++) {
            System.out.println(book.get(i));
        }
    }

    public static void testSortPagesOfBookDecreasing() {
        /* TODO */
        System.out.println();
        System.out.println("Sắp xếp số trang giảm dần: ");
        MyList book = BookManager.getInstance().sortPagesDecreasing();
        for (int i = 0; i < book.size(); i++) {
            System.out.println(book.get(i));
        }
    }

    public static void testPriceOfBooksIncreasing() {
        /* TODO */
        System.out.println();
        System.out.println("Sắp xếp số giá sách tăng dần: ");
        MyList book = BookManager.getInstance().sortPriceIncreasing();
        for (int i = 0; i < book.size(); i++) {
            System.out.println(book.get(i));
        }
    }

    public static void testPriceOfBooksDecreasing() {
        /* TODO */
        System.out.println();
        System.out.println("Sắp xếp số giá sách giảm dần: ");
        MyList book = BookManager.getInstance().sortPriceDecreasing();
        for (int i = 0; i < book.size(); i++) {
            System.out.println(book.get(i));
        }
    }

    public static void testFilterBooksOfAuthor() {
        /* TODO */
        System.out.println();
        System.out.println("Lọc theo tác giả: ");
        MyList book = BookManager.getInstance().filterBooksOfAuthor("Smith Adam");
        for (int i = 0; i < book.size(); i++) {
            System.out.println(book.get(i));
        }

    }

    public static void testFilterBooksOfPublisher() {
        /* TODO */
        System.out.println();
        System.out.println("Lọc theo nhà xuất bản: ");
        MyList book = BookManager.getInstance().filterBooksOfPublisher("Penguin");
        for (int i = 0; i < book.size(); i++) {
            System.out.println(book.get(i));
        }
    }

    public static void testFilterBooksOfGenre() {
        /* TODO */
        System.out.println();
        System.out.println("Lọc theo thể loại: ");
        MyList book = BookManager.getInstance().filterBooksOfGenre("fiction");
        for (int i = 0; i < book.size(); i++) {
            System.out.println(book.get(i));
        }
    }
}

