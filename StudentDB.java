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



	static List<Student> studentsList = new ArrayList<>();

	StudentDB() {
		studentsList.add(new Student("ABC1234567", "Riddhi Sharma", "9876543210", "riddhi@xyzcollege.in",
				"Computer Science", 3, 3.8, "Software Development", "Intern at CompanyX","@#*Su123sm"));
		studentsList.add(new Student("DEF2345678", "Rohan Desh", "9876543211", "rohan@xyzcollege.in",
				"Electrical Engineering", 2, 3.5, "Data Analysis", "Data Analyst at CompanyY","@Rohan123"));
		studentsList.add(new Student("GHI3456789", "Ali Singh", "9876543212", "ali@xyzcollege.in",
				"Mechanical Engineering", 4, 3.2, "Product Management", "Product Manager at CompanyZ","Ali&21"));
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

}
