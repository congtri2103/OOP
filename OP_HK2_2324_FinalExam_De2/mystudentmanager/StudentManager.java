package OP_HK2_2324_FinalExam_De2.mystudentmanager;


public class StudentManager {
    // Singleton pattern
    private static StudentManager instance;

    private MyList studentList;

    private StudentManager() {
        /* TODO */
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
        /* TODO */
        return this.studentList;
    }

    /**
     * Thêm sinh viên vào cuối danh sách.
     * @param student
     */
    public void append(Student student) {
        /* TODO */
        studentList.insertAtEnd(student);
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
        studentList.insertAtPosition(student,index);
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
     * Bỏ sinh viên như tham số truyền vào.
     * @param student
     */
    public void remove(Student student) {
        /* TODO */
        for (int i = 0; i < studentList.size(); i++) {
            Student current = (Student) studentList.get(i);
            if (current.equals(student)) {
                studentList.remove(i);
                return;
            }
        }
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
     * Lọc ra những sinh viên có điểm trung bình trên 15 điểm.
     * @return
     */
    public MyList filterStudentsByAverageGrade() {
        /* TODO */
        MyList result = new MyLinkedList();

        for (int i = 0; i < studentList.size(); i++) {
            Student student = (Student) studentList.get(i);

            double total =
                    student.getMathsGrade()
                            + student.getPhysicsGrade()
                            + student.getChemistryGrade();

            if (total > 15) {
                result.insertAtEnd(student);
            }
        }
        return result;
    }

    /**
     * Lọc ra những sinh viên có điểm toán trên 5 điểm.
     * @return
     */
    public MyList filterStudentsByMathGrade() {
        /* TODO */
        MyList result = new MyLinkedList();

        for (int i = 0; i < studentList.size(); i++) {
            Student s = (Student) studentList.get(i);
            if (s.getMathsGrade() > 5) {
                result.insertAtEnd(s);
            }
        }
        return result;
    }
    public static String idOfStudentsToString(MyList studentList) {
        StringBuilder idOfStudents = new StringBuilder();
        idOfStudents.append("[");

        for (int i = 0; i < studentList.size(); i++) {
            Student student = (Student) studentList.get(i);
            idOfStudents.append(student.getId()).append(" ");
        }

        return idOfStudents.toString().trim() + "]";
    }
}

