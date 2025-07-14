package service;

import model.Student;
import java.util.*;

public class StudentManager {
    private List<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        for (Student s : students)
            if (s.getStudentId() == student.getStudentId())
                throw new IllegalArgumentException("Duplicate student ID");
        students.add(student);
    }

    public boolean deleteStudent(int id) {
        return students.removeIf(s -> s.getStudentId() == id);
    }

    public List<Student> searchByName(String name) {
        List<Student> result = new ArrayList<>();
        for (Student s : students)
            if (s.getFullName().toLowerCase().contains(name.toLowerCase()))
                result.add(s);
        return result;
    }

    public List<Student> getAllStudents() {
        return new ArrayList<>(students);
    }
}
