package buffer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
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

	String password;

	



	public Student(String rollNum, String name, String contactNo, String emailId, String branch, int yearOfStudy,

			double GPA, String areaOfInterest, String workExperience,String password) {

		

		this.rollNum = rollNum;

		this.name = name;

		this.password= password;

		this.contactNo = contactNo;

		this.emailId = emailId;

		this.branch = branch;

		this.yearOfStudy = yearOfStudy;

		this.GPA = GPA;

		this.areaOfInterest = areaOfInterest;

		this.workExperience = workExperience;

	

	}

}

public class StudentDB {

	 public static boolean isStrongPassword(String password) {

	        // Check length

	        if (password.length() < 8) {

	            return false;

	        }

	        

	        // Check for uppercase, lowercase, digits, and special characters using regex

	        if (!Pattern.compile("[A-Z]").matcher(password).find() ||

	            !Pattern.compile("[a-z]").matcher(password).find() ||

	            !Pattern.compile("[0-9]").matcher(password).find() ||

	            !Pattern.compile("[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]").matcher(password).find()) {

	            return false;

	        }

	        

	        return true;

	    }



	static Scanner sc = new Scanner(System.in);





//	riddhi@xyzcollege.in

//	@#*Su123sm

	static List<Student> studentsList = new ArrayList<>();



	StudentDB() {

		studentsList.add(new Student("ABC1234567", "Riddhi Sharma", "9876543210", "riddhi@xyzcollege.in",

				"Computer Science", 3, 3.8, "Software Development", "Intern at CompanyX","@#*Su123sm"));

		studentsList.add(new Student("DEF2345678", "Rohan Desh", "9876543211", "rohan@xyzcollege.in",

				"Electrical Engineering", 2, 3.5, "Data Analysis", "Data Analyst at CompanyY","@Rohan123"));

		studentsList.add(new Student("GHI3456789", "Ali Singh", "9876543212", "ali@xyzcollege.in",

				"Mechanical Engineering", 4, 3.2, "Product Management", "Product Manager at CompanyZ","Ali&21"));

		studentsList.add(new Student("KLE3456789", "Raddha Sharma", "9876543456", "raddha@xyzcollege.in",

				"Information technology", 3, 3.8, "Software Development", "Intern at CompanyX","1"));

		studentsList.add(new Student("MNO4567890", "Samir Patel", "9876543457", "samir@xyzcollege.in",

	            "Civil Engineering", 3, 3.7, "Construction Management", "Project Manager at CompanyA","Samir@123"));

	studentsList.add(new Student("PQR5678901", "Priya Gupta", "9876543458", "priya@xyzcollege.in",

	            "Chemical Engineering", 4, 3.9, "Process Engineering", "Process Engineer at CompanyB","@PriyaG"));

	

	studentsList.add(new Student("STU6789012", "Aryan Kumar", "9876543459", "aryan@xyzcollege.in",

	            "Aerospace Engineering", 2, 3.3, "Aircraft Design", "Aircraft Designer at CompanyC","Aryan123!"));

	

	studentsList.add(new Student("VWX7890123", "Neha Singh", "9876543460", "neha@xyzcollege.in",

	            "Biomedical Engineering", 3, 3.6, "Medical Device Development", "Engineer at CompanyD","Neha@567"));



	studentsList.add(new Student("YZA8901234", "Amit Jain", "9876543461", "amit@xyzcollege.in",

	            "Environmental Engineering", 4, 3.8, "Environmental Consulting", "Consultant at CompanyE","Amit&21"));

	

	studentsList.add(new Student("BCD9012345", "Sonal Gupta", "9876543462", "sonal@xyzcollege.in",

	            "Computer Engineering", 3, 3.5, "Software Testing", "QA Engineer at CompanyF","Sonal123#"));



	studentsList.add(new Student("EFG0123456", "Aarav Sharma", "9876543463", "aarav@xyzcollege.in",

	            "Mechatronics Engineering", 2, 3.4, "Robotics", "Robotics Engineer at CompanyG","Aarav@#123"));

	

	studentsList.add(new Student("HIJ1234567", "Kavya Reddy", "9876543464", "kavya@xyzcollege.in",

	            "Biotechnology", 4, 3.7, "Genetic Engineering", "Researcher at CompanyH","Kavya@567"));

	

	studentsList.add(new Student("KLM2345678", "Arjun Patel", "9876543465", "arjun@xyzcollege.in",

	            "Industrial Engineering", 3, 3.6, "Supply Chain Management", "Manager at CompanyI","Arjun123!"));



	studentsList.add(new Student("NOP3456789", "Ananya Singh", "9876543466", "ananya@xyzcollege.in",

	            "Materials Science", 4, 3.9, "Nanotechnology", "Research Scientist at CompanyJ","Ananya@#21"));



	studentsList.add(new Student("QRS4567890", "Aarav Desai", "9876543467", "aaravd@xyzcollege.in",

	            "Chemical Engineering", 3, 3.5, "Process Control", "Engineer at CompanyK","@AaravD!123"));



	}



	static void studentInput() {



		System.out.println("-------------------------------------");

		System.out.print("Enter Roll Number : ");

		String rollNum = sc.nextLine();

		System.out.print("Enter Name : ");

		String name = sc.nextLine();

		

		System.out.print("Enter Password : ");

		String pass = sc.nextLine();

		while(!isStrongPassword(pass)){

			System.out.print("Your password is weak : \n1) Re-enter Password :\n2) Exit");

			int ch = sc.nextInt();

			sc.nextLine();

			if(ch==1) 

			pass = sc.nextLine();

			else {		

				System.out.println("Successfull !");

			return;

			}

		}

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



		studentsList.add(new Student(rollNum, name, contactNo, emailId, branch, yearOfStudy, GPA, areaOfInterest, workExperience,pass));

		System.out.println("Successfull !");

	}
	
	public void updateStudent(String emailId) {
        boolean found = false;

        for (int i = 0; i < studentsList.size(); i++) {
            Student student = studentsList.get(i);
            if (student.emailId.equals(emailId)) {
                // Found the student, now update details
                System.out.println("Enter updated Name : ");
                student.name = sc.nextLine();
                System.out.println("Enter updated Contact Number : ");
                student.contactNo = sc.nextLine();
                System.out.println("Enter updated Branch : ");
                student.branch = sc.nextLine();
                System.out.println("Enter updated Year of Study : ");
                student.yearOfStudy = sc.nextInt();
                sc.nextLine();
                System.out.println("Enter updated GPA : ");
                student.GPA = sc.nextDouble();
                sc.nextLine();
                System.out.println("Enter updated Area of Interest : ");
                student.areaOfInterest = sc.nextLine();
                System.out.println("Enter updated Work Experience : ");
                student.workExperience = sc.nextLine();
                System.out.println("Student details updated successfully!");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Student with email ID " + emailId + " not found.");
        }
    }

    // Method to delete student
    public void deleteStudent(String emailId) {
        boolean found = false;

        for (int i = 0; i < studentsList.size(); i++) {
            Student student = studentsList.get(i);
            if (student.emailId.equals(emailId)) {
                // Found the student, now delete
                studentsList.remove(i);
                System.out.println("Student with email ID " + emailId + " deleted successfully!");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Student with email ID " + emailId + " not found.");
        }
    }
}
