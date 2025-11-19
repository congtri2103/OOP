package Bài2;

import java.util.ArrayList;
import java.util.List;

public class StudentManager {
    private List<Student> studentList;

    public StudentManager() {
        this.studentList = new ArrayList<>();

    }

    public void add(Student student, int order) {
        this.studentList.add(student);
        studentList.sort((s1, s2) -> {
            if (order == 1) {
                return s1.compareTo(s2); // Sắp xếp tăng dần
            } else if (order == -1) {
                return s2.compareTo(s1); // Sắp xếp giảm dần
            }
            return 0; // Không thực hiện sắp xếp nếu order không hợp lệ
        });
    }

    public void append(Student student) {
        this.studentList.add(student); //// Thêm sinh viên vào cuối danh sách
    }

    private boolean checkBoundaries(int a, int b) {
        return a >= 0 && b >= 0 && a < studentList.size() && b < studentList.size();
    }

    public List<Student> filterStudentsHighestGrade(int order) {
        List<Student> filteredList = new ArrayList<>(studentList);

        // Sắp xếp sinh viên theo điểm trung bình
        filteredList.sort((s1, s2) -> {
            if (order == 1) {
                // Sắp xếp tăng dần theo điểm trung bình
                return Double.compare(s1.getAverageGrade(), s2.getAverageGrade());
            } else if (order == -1) {
                // Sắp xếp giảm dần theo điểm trung bình
                return Double.compare(s2.getAverageGrade(), s1.getAverageGrade());
            }
            return 0; // Không thực hiện sắp xếp nếu order không hợp lệ
        });

        return filteredList;
    }

    public List<Student> filterStudentsLowestGrade(int order) {
        List<Student> filteredList = new ArrayList<>(studentList);

        // Sắp xếp sinh viên theo điểm trung bình
        filteredList.sort((s1, s2) -> {
            if (order == 1) {
                // Sắp xếp tăng dần theo điểm trung bình
                return Double.compare(s1.getAverageGrade(), s2.getAverageGrade());
            } else if (order == -1) {
                // Sắp xếp giảm dần theo điểm trung bình
                return Double.compare(s2.getAverageGrade(), s1.getAverageGrade());
            }
            return 0; // Không thực hiện sắp xếp nếu order không hợp lệ
        });

        return filteredList;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public String idOfStudentsToString(List<Student> students) {
        StringBuilder sb = new StringBuilder();
        for (Student student : students) {
            sb.append(student.getId()).append(", ");
        }
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 2);
        }
        return sb.toString();
    }

    public void print(List<Student> students) {
        for (Student student : students) {
            System.out.println(student.toString());
        }
    }

    public void remove(int order) {
        this.studentList.remove(order);
    }

    public List<Student> sortByGradeDecreasing() {
        List<Student> sortedList = new ArrayList<>(studentList);
        //// Sắp xếp giảm dần theo điểm trung bình
        sortedList.sort((s1, s2) -> Double.compare(s2.getAverageGrade(), s1.getAverageGrade()));
        return sortedList;
    }

    public List<Student> sortByGradeIncreasing() {
        List<Student> sortedList = new ArrayList<>(studentList);
        sortedList.sort((s1, s2) -> Double.compare(s1.getAverageGrade(), s2.getAverageGrade()));
        return sortedList;
    }

    public List<Student> sortStudentByName() {
        List<Student> sortedList = new ArrayList<>(studentList);
        sortedList.sort((s1, s2) -> {
            String fullname1 = s1.getLastname() + " " + s1.getFirstname();
            String fullname2 = s2.getLastname() + " " + s2.getFirstname();
            return fullname1.compareToIgnoreCase(fullname2);//// So sánh họ tên của 2 sinh viên
        });
        return sortedList;
    }
    public Student studentAt(int order) {
        if(order>=0&& order <studentList.size()) {
            return studentList.get(order);
        }else {
            throw new IndexOutOfBoundsException();
        }
    }
}