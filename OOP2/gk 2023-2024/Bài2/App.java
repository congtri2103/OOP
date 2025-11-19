package Bài2;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class App {
    private static final String COMMA_DELIMITER = ",";
    private StudentManager studentManager;

    public App() {
        studentManager = new StudentManager();
    }

    public static void main(String[] args) {
        App app = new App();
        app.init();
        app.testOriginalData();
        app.testFilterStudentsHighestGrade();
        app.testFilterStudentsLowestGrade();
        app.testSortStudentByGradeDecreasing();
        app.testSortStudentByGradeIncreasing();
        app.testSortStudentByName();
    }

    public void init() {
        // Khởi tạo dữ liệu hoặc đọc dữ liệu từ file
        readListData("/Users/nguyencongtri/Documents/OOP/Lab 8/students.csv");
    }

    public String[] parseDataLineToArray(String line) {
        return line.split(COMMA_DELIMITER);
    }

    public List<String> parseDataLineToList(String line) {
        String[] dataArray = parseDataLineToArray(line);
        List<String> dataList = new ArrayList<>();
        for (String data : dataArray) {
            dataList.add(data.trim());
        }
        return dataList;
    }

    public void readListData(String filename) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(filename));
            for (int i = 0; i < lines.size(); i++) {
                // Bỏ qua dòng đầu tiên (tiêu đề)
                if (i == 0) {
                    continue;
                }

                List<String> data = parseDataLineToList(lines.get(i));
                if (data.size() == 7) {  // Kiểm tra xem dữ liệu có đủ 7 trường không
                    String id = data.get(0);
                    String lastname = data.get(1);
                    String firstname = data.get(2);
                    try {
                        int yearOfBirth = Integer.parseInt(data.get(3)); // Parse the year of birth
                        double mathsGrade = Double.parseDouble(data.get(4)); // Parse maths grade
                        double physicsGrade = Double.parseDouble(data.get(5)); // Parse physics grade
                        double chemistryGrade = Double.parseDouble(data.get(6)); // Parse chemistry grade

                        Student student = new Student(id, lastname, firstname, yearOfBirth, mathsGrade, physicsGrade, chemistryGrade);
                        studentManager.append(student);
                    } catch (NumberFormatException e) {
                        System.err.println("Invalid data at line " + (i + 1) + ": " + lines.get(i));
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    // Kiểm tra dữ liệu gốc
    public void testOriginalData() {
        System.out.println("Original student data:");
        List<Student> students = studentManager.getStudentList();
        for (Student student : students) {
            System.out.println(student);
        }
    }

    // Kiểm tra lọc sinh viên có điểm cao nhất
    public void testFilterStudentsHighestGrade() {
        System.out.println("Students with highest grade:");
        List<Student> students = studentManager.getStudentList();
        for (Student student : students) {
            System.out.println(student);
        }
    }

    // Kiểm tra lọc sinh viên có điểm thấp nhất
    public void testFilterStudentsLowestGrade() {
        System.out.println("Students with lowest grade:");
        List<Student> students = studentManager.getStudentList();
        for (Student student : students) {
            System.out.println(student);
        }
    }

    // Kiểm tra sắp xếp sinh viên theo điểm giảm dần
    public void testSortStudentByGradeDecreasing() {
        System.out.println("Students sorted by grade (decreasing):");
        List<Student> students = studentManager.sortByGradeDecreasing();
        for (Student student : students) {
            System.out.println(student);
        }
    }

    // Kiểm tra sắp xếp sinh viên theo điểm tăng dần
    public void testSortStudentByGradeIncreasing() {
        System.out.println("Students sorted by grade (increasing):");
        List<Student> students = studentManager.sortByGradeIncreasing();
        for (Student student : students) {
            System.out.println(student);
        }
    }

    // Kiểm tra sắp xếp sinh viên theo tên
    public void testSortStudentByName() {
        System.out.println("Students sorted by name:");
        List<Student> students = studentManager.sortStudentByName();
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
