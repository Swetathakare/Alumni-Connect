package bufferpackage;

import java.util.*;

class Alumni {

	String name;
	String branch;
	int passingYear;
	String jobProfile;
	ArrayList<String> tags;
	String id;
	Post[] p;
	String gmail;
	String contact;

	Alumni(String Name, String Branch, int PassingYear, String JobProfile, ArrayList<String> Tags, String Id) {

		this.name = Name;
		this.branch = Branch;
		this.passingYear = PassingYear;
		this.jobProfile = JobProfile;
		this.tags = Tags;
		this.id = Id;
		this.p = p;
	}

	class Post {

		String Id;
		String Title;
		Date date;
		String deadlineOfRegistration;
		Date dateOfEvent;
		String postDescription;
		ArrayList<String> tags;

		public Post(String Id, String Title, Date date, String deadlineOfRegistration, Date dateOfEvent,
				String postDescription, ArrayList<String> tags) {

			this.Id = Id;
			this.Title = Title;
			this.date = date;
			this.deadlineOfRegistration = deadlineOfRegistration;
			this.dateOfEvent = dateOfEvent;
			this.postDescription = postDescription;
			this.tags = tags;

		}

	}
}

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

	public String getRollNum() {
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

}

public class Main {

	static Scanner sc = new Scanner(System.in);

	static boolean check(String alId, String alPass) {
		return true;
	}

	static Alumni alumniInput() {

		System.out.println("-------------------------------------");

		System.out.print("Enter Name             :-");
		String alName = sc.nextLine();

		System.out.print("Enter Id               :-");
		String id = sc.nextLine();

		System.out.print("Enter Branch           :-");
		String branch = sc.nextLine();

		System.out.print("Enter Passing Year     :-");
		int passingYear = sc.nextInt();
		sc.nextLine();

		System.out.print("Enter jobProfile       :-");
		String jobProfile = sc.nextLine();

		System.out.print("Enter Number of fields :-");
		int numOfDom = sc.nextInt();
		ArrayList<String> al = new ArrayList<>();

		for (int i = 0; i < numOfDom; i++) {
			String tmp = sc.nextLine();
			al.add(tmp);
		}

		System.out.print("Enter Email Id         :-");
		String emailId = sc.nextLine();

		System.out.print("Enter Phone No         :-");
		long phone = sc.nextLong();

		System.out.println("-------------------------------------");

		return new Alumni(alName, branch, passingYear, jobProfile, al, id);
	}

	public static void main(String[] args) {

		System.out.println("------------\n" + "1) Alumni\n" + "2) Student\n" + "3) Exit\n" + "-------------");

		int choice = sc.nextInt();
		sc.nextLine();
		if (choice == 1) {
			// Alumni
			System.out.println("-----------\n" + "1) Login \n" + "2) Sign Up \n" + "3) Exit" + "\n-------------");
			choice = sc.nextInt();
			sc.nextLine();
			if (choice == 1) {
				// Alumni login section

				System.out.println("Enter Id := ");
				String alId = sc.nextLine();
				System.out.println("Enter Password := ");
				String alPass = sc.nextLine();

				boolean isValid = check(alId, alPass);

				if (isValid) {

					// options After Successful login of Alumni

					System.out.println("---------------------\nLogin Successful  !\n-----------------");
					System.out.println("------------------\n" + "1) Post An Event \n" + "2) See Registrations \n"
							+ "\n--------------------");
					choice = sc.nextInt();
				} else {
					System.out.println("Incorrect Id or Password");
				}

			} else if (choice == 2) {
				// Name Branch int passingYear jobProfile tags (arraylist) id
				Alumni newAlumni = alumniInput();
				System.out.println("Successfully Created Account !");

			} else if (choice == 3) {
				System.out.println("Thank you for Connecting !");
			} else {
				System.out.println("Invalid Choice !");
			}
		} else if (choice == 2) {
			// Student
		} else if (choice == 3) {
			System.out.println("Thank you for Connecting !");
		} else {
			System.out.println("Invalid Choice !");
		}

	}

}

