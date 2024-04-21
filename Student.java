package buffer;

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
