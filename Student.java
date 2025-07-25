package model;

public class Student {
    private int studentId;
    private String fullName;
    private double gpa;

    public Student(int studentId, String fullName, double gpa) {
        this.studentId = studentId;
        this.fullName = fullName;
        this.setGpa(gpa);
    }

    public int getStudentId() { return studentId; }
    public String getFullName() { return fullName; }
    public double getGpa() { return gpa; }

    public void setFullName(String fullName) {
        if (fullName.length() > 50) throw new IllegalArgumentException("Name too long");
        this.fullName = fullName;
    }

    public void setGpa(double gpa) {
        if (gpa < 0.0 || gpa > 4.0) throw new IllegalArgumentException("Invalid GPA");
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return String.format("%-10d %-50s %.2f", studentId, fullName, gpa);
    }
}
