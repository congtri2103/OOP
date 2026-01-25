package OOP_HK2_2223_FinalExam_De1.studentmanager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class App {
    private static final String COMMA_DELIMITER = ",";

    public static void readListData(String filePath) {
        BufferedReader dataReader = null;
        try {
            String line;
            dataReader = new BufferedReader(new FileReader(filePath));

            // Read file line by line?
            while ((line = dataReader.readLine()) != null) {
                List<String> dataList = parseDataLineToList(line);
                if (dataList.size() < 7) {
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

    public static void main(String[] args) {
        init();
    //    testOriginalData();
   //   testSortYearOfBirthIncreasing();
      // testSortYearOfBirthDecreasing();
//        testSortMathsGradeIncreasing();
//       testSortMathsGradeDecreasing();
//       testSortPhysicsGradeIncreasing();
//        testSortPhysicsGradeDecreasing();
//        testSortChemistryGradeIncreasing();
//        testSortChemistryGradeDecreasing();
   //     testFilterStudentsHighestMathsGrade();
     //   testFilterStudentsLowestMathsGrade();
 //     testFilterStudentsHighestPhysicsGrade();
  //     testFilterStudentsLowestPhysicsGrade();
  //     testFilterStudentsHighestChemistryGrade();
  //      testFilterStudentsLowestChemistryGrade();
    //    testFilterStudentsHighestAverageGrade();
       testFilterStudentsLowestAverageGrade();

    }

    public static void init() {
        String filePath = "/Users/nguyencongtri/IdeaProjects/OOP/src/OOP_HK2_2223_FinalExam_De1/data/students.csv";
        readListData(filePath);
    }

    public static void testOriginalData() {
        init();
        String studentIds = StudentManager.getInstance().idOfStudentsToString(StudentManager.getInstance().getStudentList());
        System.out.print(studentIds);
    }

    public static void testSortYearOfBirthIncreasing() {
        init();
        System.out.println();
        System.out.println("Sắp xếp Năm sinh Tăng dần");
        List<Student> students = StudentManager.getInstance().sortYearOfBirthIncreasing();
        // Dùng stream để in thông tin từng sinh viên
        students.stream()
                .map(Student::toString)  // Chuyển từng sinh viên thành chuỗi bằng toString()
                .forEach(System.out::println);
    }

    public static void testSortYearOfBirthDecreasing() {
        init();
        System.out.println();
        System.out.println("Sắp xếp Năm sinh Giam dần");
        List<Student> students = StudentManager.getInstance().sortYearOfBirthDecreasing();
        students.stream()
                .map(Student::toString)
                .forEach(System.out::println);
    }

    public static void testSortMathsGradeIncreasing() {
        /* TODO */
        init();
        System.out.println();
        System.out.println("Sắp xếp điểm toán tăng dần");
        List<Student> students = StudentManager.getInstance().sortMathsGradeIncreasing();
        students.stream()
                .map(Student::toString)
                .forEach(System.out::println);
    }

    public static void testSortMathsGradeDecreasing() {
        /* TODO */
        init();
        System.out.println();
        System.out.println("Sắp xếp điểm toán giảm dần");
        List<Student> students = StudentManager.getInstance().sortMathsGradeDecreasing();
        students.stream()
                .map(Student::toString)
                .forEach(System.out::println);;
    }

    public static void testSortPhysicsGradeIncreasing() {
        /* TODO */
        init();
        System.out.println();
        System.out.println("Sắp xếp điểm vật lý tăng dần");
        List<Student> students = StudentManager.getInstance().sortPhysicsGradeIncreasing();
        students.stream()
                .map(Student::toString)
                .forEach(System.out::println);

    }

    public static void testSortPhysicsGradeDecreasing() {
        /* TODO */
        init();
        System.out.println();
        System.out.println("Sắp xếp điểm vật lý giảm dần");
        List<Student> students = StudentManager.getInstance().sortPhysicsGradeDecreasing();
        students.stream()
                .map(Student::toString)  // Chuyển từng sinh viên thành chuỗi bằng toString()
                .forEach(System.out::println);
    }

    public static void testSortChemistryGradeIncreasing() {
        /* TODO */
        init();
        System.out.println();
        System.out.println("Sắp xếp điểm hoá tăng dần");
        List<Student> students = StudentManager.getInstance().sortChemistryGradeIncreasing();
        students.stream()
                .map(Student::toString)
                .forEach(System.out::println);
    }

    public static void testSortChemistryGradeDecreasing() {
        /* TODO */
        init();
        System.out.println();
        System.out.println("Sắp xếp điểm hoá giảm dần");
        List<Student> students = StudentManager.getInstance().sortChemistryGradeDecreasing();
        students.stream()
                .map(Student::toString)
                .forEach(System.out::println);
    }

    public static void testFilterStudentsHighestMathsGrade() {
        init();
        System.out.println();
        System.out.println("Kiểm tra lọc học sinh có điểm Toán cao nhất");
        List<Student> students = StudentManager.getInstance().sortMathsGradeDecreasing();
        List<Student> nHighestMathsGradeStudents = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            nHighestMathsGradeStudents.add(students.get(i));
        }
        for(Student student : nHighestMathsGradeStudents) {
            System.out.println(student.toString());
        }
    }

    public static void testFilterStudentsLowestMathsGrade() {
        init();
        System.out.println();
        System.out.println("kiểm tra Lọc Học sinh Điểm Toán Thấp nhất");
        List<Student> students = StudentManager.getInstance().sortMathsGradeIncreasing();
        List<Student> nLowestMathsGradeStudents = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            nLowestMathsGradeStudents.add(students.get(i));
        }

        for (Student student : nLowestMathsGradeStudents) {
            System.out.println(student.toString());
        }
    }

    public static void testFilterStudentsHighestPhysicsGrade() {
        /* TODO */
        init();
        System.out.println();
        System.out.println("kiểm tra Lọc Học sinh Điểm vật lý cao nhất");
        List<Student> students = StudentManager.getInstance().sortPhysicsGradeDecreasing();
        List<Student> nHighestPhysicsGradeStudents = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            nHighestPhysicsGradeStudents.add(students.get(i));
        }

        for (Student student : nHighestPhysicsGradeStudents) {
            System.out.println(student.toString());
        }
    }

    public static void testFilterStudentsLowestPhysicsGrade() {
        /* TODO */
        init();
        System.out.println();
        System.out.println("kiểm tra Lọc Học sinh Điểm vật lý thấp nhất");
        List<Student> students = StudentManager.getInstance().sortPhysicsGradeIncreasing();
        List<Student> nLowestPhysicsGradeStudents = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            nLowestPhysicsGradeStudents.add(students.get(i));
        }
        for (Student student : nLowestPhysicsGradeStudents) {
            System.out.println(student.toString());
        }
    }

    public static void testFilterStudentsHighestChemistryGrade() {
        /* TODO */
        init();
        System.out.println();
        System.out.println("kiểm tra Lọc Học sinh Điểm Hoá cao nhất");
        List<Student> students = StudentManager.getInstance().sortChemistryGradeDecreasing();
        List<Student> nHighesChemistryGradeStudents = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            nHighesChemistryGradeStudents.add(students.get(i));
        }

        for (Student student : nHighesChemistryGradeStudents) {
            System.out.println(student.toString());
        }
    }

    public static void testFilterStudentsLowestChemistryGrade() {
        /* TODO */
        init();
        System.out.println();
        System.out.println("kiểm tra Lọc Học sinh Điểm Hoá thấp nhất");
        List<Student> students = StudentManager.getInstance().sortChemistryGradeIncreasing();
        List<Student> nLowestChemistryGradeStudents = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            nLowestChemistryGradeStudents.add(students.get(i));
        }
        for (Student student : nLowestChemistryGradeStudents) {
            System.out.println(student.toString());
        }
    }

    public static void testFilterStudentsHighestAverageGrade() {
        /* TODO */
        init();
        System.out.println();
        System.out.println("kiểm tra Lọc Học sinh Điểm trung bình cao nhất");
        List<Student> students = StudentManager.getInstance().sortAverageGradeDecreasing();
        List<Student> nHighesAverageGradeStudents = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            nHighesAverageGradeStudents.add(students.get(i));
        }
        for (Student student : nHighesAverageGradeStudents) {
            System.out.println(student.toString());
        }


    }

    public static void testFilterStudentsLowestAverageGrade() {
        /* TODO */
        init();
        System.out.println();
        System.out.println("kiểm tra Lọc Học sinh Điểm trung bình thấp nhất");
        List<Student> students = StudentManager.getInstance().sortAverageGradeIncreasing();
        List<Student> nLowestAverageGradeStudents = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            nLowestAverageGradeStudents.add(students.get(i));
        }
        for (Student student : nLowestAverageGradeStudents) {
            System.out.println(student.toString());
        }
    }
}

