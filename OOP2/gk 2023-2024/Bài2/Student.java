package Bài2;

public class Student implements MyStudentComparable {
    private String id;
    private String lastname;
    private String firstname;
    private int yearOfBirth;
    private double mathsGrade;
    private double physicsGrade;
    private double chemistryGrade;

    public Student(String id, String lastname, String firstname, int yearOfBirth,
                   double mathsGrade, double physicsGrade, double chemistryGrade) {
        this.id=id;
        this.lastname=lastname;
        this.firstname=firstname;
        this.yearOfBirth=yearOfBirth;
        this.mathsGrade=mathsGrade;
        this.physicsGrade=physicsGrade;
        this.chemistryGrade=chemistryGrade;

    }

    public int compareTo(Student other) {
        double avgGradeThis = this.getAverageGrade();
        double avgGradeOther = other.getAverageGrade();
        if (avgGradeThis > avgGradeOther) {
            return 1; // sinh viên này có điểm trung bình cao hơn
        } else if (avgGradeThis < avgGradeOther) {
            return -1;
        } else {
            return 0;
        }
    }

    public double getAverageGrade() {
        return (mathsGrade + physicsGrade + chemistryGrade) / 3;
    }

    public double getChemistryGrade() {
        return chemistryGrade;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getId() {
        return id;
    }

    public String getLastname() {
        return lastname;
    }

    public double getMathsGrade() {
        return mathsGrade;
    }

    public double getPhysicsGrade() {
        return physicsGrade;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public String toString() {
        return "Student[" +
                "id='" + id + '\'' +
                ", lastname='" + lastname + '\'' +
                ", firstname='" + firstname + '\'' +
                ", yearOfBirth=" + yearOfBirth +
                ", mathsGrade=" + mathsGrade +
                ", physicsGrade=" + physicsGrade +
                ", chemistryGrade=" + chemistryGrade +
                ", averageGrade=" + getAverageGrade() +
                ']';
    }
}
