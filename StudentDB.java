package buffer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentDB {
    List<Student> studentsList = new ArrayList<>();

    StudentDB() {
        studentsList.add(new Student("ABC1234567", "Riddhi Sharma", "9876543210", "riddhi@xyzcollege.in", "Computer Science", 3, 3.8, "Software Development", "Intern at CompanyX"));
        studentsList.add(new Student("DEF2345678", "Rohan Desh", "9876543211", "rohan@xyzcollege.in", "Electrical Engineering", 2, 3.5, "Data Analysis", "Data Analyst at CompanyY"));
        studentsList.add(new Student("GHI3456789", "Ali Singh", "9876543212", "ali@xyzcollege.in", "Mechanical Engineering", 4, 3.2, "Product Management", "Product Manager at CompanyZ"));
    }
    /*void addNewStudent() {
        // Add new student logic
    }

    public void displayStudentDetailsById(String id) {
        // Display student details by ID logic
    }

    public static void main(String[] args) {
        // Main method for testing
    }*/
}
