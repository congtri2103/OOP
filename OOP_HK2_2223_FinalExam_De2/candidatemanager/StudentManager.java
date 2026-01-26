package OOP_HK2_2223_FinalExam_De2.candidatemanager;


import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class StudentManager {
    // Singleton pattern
    private static StudentManager instance;

    private MyList studentList;

    private StudentManager() {
        studentList = new MyLinkedList();
    }

    public static StudentManager getInstance() {
        /* TODO */
        if (instance == null) {
            instance = new StudentManager();
        }
        return instance;
    }

    public MyList getStudentList() {
        return this.studentList;
    }

    /**
     * Thêm sinh viên vào cuối danh sách.
     * @param student
     */
    public void append(Student student) {
        /* TODO */
        studentList.append(student);
    }

    /**
     * Thêm sinh viên vào danh sách ở vị trí index.
     * @param student
     * @param index
     */
    public void add(Student student, int index) {
        /* TODO */
        if (index < 0 || index >= studentList.size()) {
            throw new IndexOutOfBoundsException(index);
        }
        studentList.insert(student,index);
    }

    /**
     * Bỏ sinh viên ở vị trí index.
     * @param index
     */
    public void remove(int index) {
        /* TODO */
        if (index < 0 || index >= studentList.size()) {
            throw new IndexOutOfBoundsException(index);
        }
        studentList.remove(index);
    }

    /**
     * Lấy ra sinh viên ở vị trí index
     * @param index
     * @return
     */
    public Student studentAt(int index) {
        /* TODO */
        if (index < 0 || index >= studentList.size()) {
            throw new IndexOutOfBoundsException(index);
        }
        // studentList.get(index) → trả về Object
        // → ép kiểu vì ta chỉ lưu Student trong list
        return (Student) studentList.get(index);
    }

    /**
     * Sắp xếp danh sách sinh viên theo thứ tự điểm toán tăng dần.
     * @return
     */
    public MyList sortMathsGradeIncreasing() {
        /* TODO */
        MyList list = studentList;
        for (int i = 0; i < list.size() - 1;i++) {
            for (int j = 0; j < list.size() - i - 1;j++) {
                Student a = (Student) list.get(j);
                Student b = (Student) list.get(j+1);
                if (a.getMathsGrade() > b.getMathsGrade()) {
                    list.set(b,j);
                    list.set(a,j+1);
                }
            }
        }
        return list;
    }

    /**
     * Sắp xếp danh sách sinh viên theo thứ tự điểm toán giảm dần.
     * @return
     */
    public MyList sortMathsGradeDecreasing() {
        /* TODO */
        MyList list = studentList;
        for (int i = 0; i < list.size() - 1;i++) {
            for (int j = 0; j < list.size() - i - 1;j++) {
                Student a = (Student) list.get(j);
                Student b = (Student) list.get(j+1);
                if (a.getMathsGrade() < b.getMathsGrade()) {
                    list.set(b,j);
                    list.set(a,j+1);
                }
            }
        }
        return list;

    }

    /**
     * Sắp xếp danh sách sinh viên theo thứ tự điểm trung bình tăng dần.
     * @return
     */
    public MyList sortAverageGradeIncreasing() {
        /* TODO */
        MyList list = studentList;
        for (int i = 0; i < list.size() - 1;i++) {
            for (int j = 0; j < list.size() - i - 1;j++) {
                Student a = (Student) list.get(j);
                Student b = (Student) list.get(j+1);
                if (a.getAverageGrade() > b.getAverageGrade()) {
                    list.set(b,j);
                    list.set(a,j+1);
                }
            }
        }
        return list;
    }

    /**
     * Sắp xếp danh sách sinh viên theo thứ tự điểm trung bình giảm dần.
     * @return
     */
    public MyList sortAverageGradeDecreasing() {
        /* TODO */
        MyList list = studentList;
        for (int i = 0; i < list.size() - 1;i++) {
            for (int j = 0; j < list.size() - i - 1;j++) {
                Student a = (Student) list.get(j);
                Student b = (Student) list.get(j+1);
                if (a.getAverageGrade() < b.getAverageGrade()) {
                    list.set(b,j);
                    list.set(a,j+1);
                }
            }
        }
        return list;
    }

    /**
     * Lọc ra howMany sinh viên có điểm toán cao nhất.
     * @param howMany
     * @return
     */
    public MyList filterStudentsHighestMathsGrade(int howMany) {
        /* TODO */
        MyList sortedList = sortMathsGradeDecreasing();
        MyList result = new MyLinkedList();

        for (int i = 0; i < howMany && i < sortedList.size();i++) {
            result.append(sortedList.get(i));
        }
        return result;

    }

    /**
     * Lọc ra howMany sinh viên có điểm toán thấp nhất.
     * @param howMany
     * @return
     */
    public MyList filterStudentsLowestMathsGrade(int howMany) {
        /* TODO */
        MyList sortedList = sortMathsGradeIncreasing();
        MyList result = new MyLinkedList();

        for (int i = 0; i < howMany && i < sortedList.size();i++) {
            result.append(sortedList.get(i));
        }
        return result;
    }

    /**
     * Lọc ra howMany sinh viên có điểm trung bình cao nhất.
     * @param howMany
     * @return
     */
    public MyList filterStudentsHighestAverageGrade(int howMany) {
        /* TODO */
        MyList sortedList = sortAverageGradeDecreasing();
        MyList result = new MyLinkedList();

        for (int i = 0; i < howMany && i < sortedList.size();i++) {
            result.append(sortedList.get(i));
        }
        return result;
    }

    /**
     * Lọc ra howMany sinh viên có điểm trung bình thấp nhất.
     * @param howMany
     * @return
     */
    public MyList filterStudentsLowestAverageGrade(int howMany) {
        /* TODO */
        MyList sortedList = sortAverageGradeIncreasing();
        MyList result = new MyLinkedList();

        for (int i = 0; i < howMany && i < sortedList.size();i++) {
            result.append(sortedList.get(i));
        }
        return result;
    }

    public static String idOfStudentsToString(MyList studentList) {
        StringBuilder idOfStudents = new StringBuilder();
        idOfStudents.append("[");
        MyIterator it = studentList.iterator();
        while (it.hasNext()) {
            Student student = (Student) it.next();
            idOfStudents.append(student.getId()).append(" ");
        }
        return idOfStudents.toString().trim() + "]";
    }

    public static void print(MyList studentList) {
        StringBuilder studentsString = new StringBuilder();
        studentsString.append("[\n");
        MyIterator it = studentList.iterator();
        while (it.hasNext()) {
            Student student = (Student) it.next();
            studentsString.append(student.toString()).append("\n");
        }
        System.out.print(studentsString.toString().trim() + "\n]");
    }
}

