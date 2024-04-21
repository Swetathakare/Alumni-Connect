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
static Student studentInput() {

		System.out.println("-------------------------------------");

		System.out.print("Enter Roll Number : ");

		String rollNum = sc.nextLine();

		System.out.print("Enter Name : ");

		String name = sc.nextLine();

		System.out.print("Enter Contact Number : ");

		String contactNo = sc.nextLine();

		System.out.print("Enter Email Id : ");

		String emailId = sc.nextLine();

		System.out.print("Enter Branch : ");

		String branch = sc.nextLine();

		System.out.print("Enter Year of Study : ");

		int yearOfStudy = sc.nextInt();

		sc.nextLine();

		System.out.print("Enter GPA : ");

		double GPA = sc.nextDouble();

		sc.nextLine();

		System.out.print("Enter Area of Interest : ");

		String areaOfInterest = sc.nextLine();

		System.out.print("Enter Work Experience : ");

		String workExperience = sc.nextLine();

		System.out.println("-------------------------------------");

		return new Student(rollNum, name, contactNo, emailId, branch, yearOfStudy, GPA, areaOfInterest, workExperience);

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

class Student {

	String rollNum;
	String name;
	String contactNo;
	String emailId;
	String branch;
	int yearOfStudy;
	double GPA;
	String areaOfInterest;
	String workExperience;
	Student next;

	public Student(String rollNum, String name, String contactNo, String emailId, String branch, int yearOfStudy,
			double GPA, String areaOfInterest, String workExperience) {
		this.rollNum = rollNum;
		this.name = name;
		this.contactNo = contactNo;
		this.emailId = emailId;
		this.branch = branch;
		this.yearOfStudy = yearOfStudy;
		this.GPA = GPA;
		this.areaOfInterest = areaOfInterest;
		this.workExperience = workExperience;
		this.next = null;
	}
}
	/*public String getRollNum() {
		return rollNum;
	}

	public String getName() {
		return name;
	}

	public String getBranch() {
		return branch;
	}

	public int getYearOfStudy() {
		return yearOfStudy;
	}

	public double getGPA() {
		return GPA;
	}

	public String getContactNo() {
		return contactNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public String getAreaOfInterest() {
		return areaOfInterest;
	}

	public String getWorkExperience() {
		return workExperience;
	}

	// Setters
	public void setRollNumber(String rollNum) {
		this.rollNum = rollNum;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public void setYearOfStudy(int yearOfStudy) {
		this.yearOfStudy = yearOfStudy;
	}

	public void setGPA(double GPA) {
		this.GPA = GPA;
	}

	public String setContactNo() {
		return contactNo;
	}

	public String setEmailId() {
		return emailId;
	}

	public String setAreaOfInterest() {
		return areaOfInterest;
	}

	public String setWorkExperience() {
		return workExperience;
	}

	public Student getNext() { // for next
		return next;
	}

	public void setNext(Student next) {
		this.next = next;
	}

}*/
}
