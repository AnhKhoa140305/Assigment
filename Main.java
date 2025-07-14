import model.Student;
import service.StudentManager;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentManager manager = new StudentManager();

        while (true) {
            System.out.println("\n1. Add 2. Delete 3. Search 4. Display 5. Exit");
            int choice = Integer.parseInt(sc.nextLine());

            try {
                switch (choice) {
                    case 1:
                        System.out.print("ID: ");
                        int id = Integer.parseInt(sc.nextLine());
                        System.out.print("Name: ");
                        String name = sc.nextLine();
                        System.out.print("GPA: ");
                        double gpa = Double.parseDouble(sc.nextLine());
                        manager.addStudent(new Student(id, name, gpa));
                        break;
                    case 2:
                        System.out.print("ID to delete: ");
                        int delId = Integer.parseInt(sc.nextLine());
                        if (!manager.deleteStudent(delId))
                            System.out.println("Not found.");
                        break;
                    case 3:
                        System.out.print("Search name: ");
                        String keyword = sc.nextLine();
                        for (Student s : manager.searchByName(keyword))
                            System.out.println(s);
                        break;
                    case 4:
                        for (Student s : manager.getAllStudents())
                            System.out.println(s);
                        break;
                    case 5:
                        return;
                    default:
                        System.out.println("Invalid choice");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
