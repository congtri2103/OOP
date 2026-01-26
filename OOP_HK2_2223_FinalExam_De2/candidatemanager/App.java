package OOP_HK2_2223_FinalExam_De2.candidatemanager;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class App {
    private static final String COMMA_DELIMITER = ",";

    public static void main(String[] args) {
                testOriginalData();
                 testSortMathsGradeIncreasing();
                testSortMathsGradeDecreasing();
                 testSortAverageGradeIncreasing();
                testSortAverageGradeDecreasing();
                testFilterStudentsHighestMathsGrade();
                testFilterStudentsLowestMathsGrade();
                 testFilterStudentsHighestAverageGrade();
                testFilterStudentsLowestAverageGrade();
        /*
        TODO

        - Viết code để test cho tất cả các hàm bên dưới.
        - Thực hiện chạy từng hàm test, lưu kết quả chạy chương trình và file text được đặt tên
        là <TenSinhVien_MaSinhVien_CandidateManager>.txt (Ví dụ, NguyenVanA_123456_CandidateManager.txt).
        - Nén các file source code và file text kết quả chạy chương trình vào file zip có tên
        <TenSinhVien_MaSinhVien_CandidateManager>.zip (Ví dụ, NguyenVanA_123456_CandidateManager.zip),
        nộp lên classroom.
         */
    }

    public static void init() {
        String filePath = "/Users/nguyencongtri/IdeaProjects/OOP/src/OOP_HK2_2223_FinalExam_De2/data/students.csv";
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
                if (dataList.size() != 7) {
                    continue;
                }

                if (dataList.get(0).equals("id")) {
                    continue;
                }

                /*
                TODO

                Đọc được dữ liệu, tạo ra các đối tượng sinh viên ở đây, và cho vào StudentManager để quản lý.
                */
                try {
                    Student student = new Student.StudentBuilder(dataList.get(0))
                            .withLastname(dataList.get(1))
                            .withFirstname(dataList.get(2))
                            .withYearOfBirth(Integer.parseInt(dataList.get(3)))
                            .withMathsGrade(Double.parseDouble(dataList.get(4)))
                            .withPhysicsGrade(Double.parseDouble(dataList.get(5)))
                            .withChemistryGrade(Double.parseDouble(dataList.get(6)))
                            .withAverageGrade()
                            .build();

                    StudentManager.getInstance().append(student);
                    System.out.println(student);
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
        String studentIds = StudentManager.getInstance().idOfStudentsToString(StudentManager.getInstance().getStudentList());
        System.out.print(studentIds);
    }

    public static void testSortMathsGradeIncreasing() {
        /* TODO */
        init();
        System.out.println();
        System.out.println("Sắp xếp điểm toán tăng dần");
        MyList myList = StudentManager.getInstance().sortMathsGradeIncreasing();
        for (int i = 0; i < myList.size();i++) {
            System.out.println(myList.get(i));
        }
    }

    public static void testSortMathsGradeDecreasing() {
        /* TODO */
        init();
        System.out.println();
        System.out.println("Sắp xếp điểm toán giảm dần");
        MyList myList = StudentManager.getInstance().sortMathsGradeDecreasing();
        for (int i = 0; i < myList.size();i++) {
            System.out.println(myList.get(i));
        }
    }

    public static void testSortAverageGradeIncreasing() {
        /* TODO */
        init();
        System.out.println();
        System.out.println("Sắp xếp điểm trung bình tăng dần");
        MyList myList = StudentManager.getInstance().sortAverageGradeIncreasing();
        for (int i = 0; i < myList.size();i++) {
            System.out.println(myList.get(i));
        }
    }

    public static void testSortAverageGradeDecreasing() {
        /* TODO */
        init();
        System.out.println();
        System.out.println("Sắp xếp điểm trung bình giảm dần");
        MyList myList = StudentManager.getInstance().sortAverageGradeDecreasing();
        for (int i = 0; i < myList.size();i++) {
            System.out.println(myList.get(i));
        }
    }

    public static void testFilterStudentsHighestMathsGrade() {
        /* TODO */
        init();
        System.out.println();
        System.out.println("Kiểm tra lọc học sinh có điểm Toán cao nhất");
        MyList myList = StudentManager.getInstance().sortMathsGradeDecreasing();
        MyList nHighestMathsGradeStudents = new MyLinkedList();
        for (int i = 0; i < 5; i++) {
            nHighestMathsGradeStudents.append(myList.get(i));
        }
        for (int i = 0; i < nHighestMathsGradeStudents.size();i++) {
            System.out.println(nHighestMathsGradeStudents.get(i));
        }
    }

    public static void testFilterStudentsLowestMathsGrade() {
        /* TODO */
        init();
        System.out.println();
        System.out.println("Kiểm tra lọc học sinh có điểm Toán thấp nhất");
        MyList myList = StudentManager.getInstance().sortMathsGradeIncreasing();
        MyList nHighestMathsGradeStudents = new MyLinkedList();
        for (int i = 0; i < 5; i++) {
            nHighestMathsGradeStudents.append(myList.get(i));
        }
        for (int i = 0; i < nHighestMathsGradeStudents.size();i++) {
            System.out.println(nHighestMathsGradeStudents.get(i));
        }
    }

    public static void testFilterStudentsHighestAverageGrade() {
        /* TODO */
        init();
        System.out.println();
        System.out.println("Kiểm tra lọc học sinh có điểm trung bình cao nhất");
        MyList myList = StudentManager.getInstance().sortAverageGradeDecreasing();
        MyList nHighestMathsGradeStudents = new MyLinkedList();
        for (int i = 0; i < 5; i++) {
            nHighestMathsGradeStudents.append(myList.get(i));
        }
        for (int i = 0; i < nHighestMathsGradeStudents.size();i++) {
            System.out.println(nHighestMathsGradeStudents.get(i));
        }
    }

    public static void testFilterStudentsLowestAverageGrade() {
        /* TODO */
        init();
        System.out.println();
        System.out.println("Kiểm tra lọc học sinh có điểm trung bình thấp nhất");
        MyList myList = StudentManager.getInstance().sortAverageGradeIncreasing();
        MyList nHighestMathsGradeStudents = new MyLinkedList();
        for (int i = 0; i < 5; i++) {
            nHighestMathsGradeStudents.append(myList.get(i));
        }
        for (int i = 0; i < nHighestMathsGradeStudents.size();i++) {
            System.out.println(nHighestMathsGradeStudents.get(i));
        }
    }
}
