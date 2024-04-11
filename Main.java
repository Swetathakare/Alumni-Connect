
package bufferpackage;
import java .util.*;


class AlumniDB {

	AlumniDB() {



		HashMap<String, Alumni> alumniMap = new HashMap<>();



		alumniMap.put("Priya_123",

				new Alumni("Priya Gupta", "Electrical Engineering", "2015", "Software Engineer", "Microsoft",

						new ArrayList<>(Arrays.asList("#coding", "#algorithms")), "Priya_123", "priya@example.com",

						"1234567890"));

		alumniMap.put("Aisha_234",

				new Alumni("Aisha Khan", "Electrical Engineering", "2018", "Data Analyst", "Microsoft",

						new ArrayList<>(Arrays.asList("data analysis", "statistics", "SQL")), "Aisha_234",

						"aisha@example.com", "9876543210"));

		alumniMap.put("Neha_483",

				new Alumni("Neha Patel", "Mechanical Engineering", "2012", "Product Manager", "Amazon",

						new ArrayList<>(Arrays.asList("product management", "leadership", "strategy")), "Neha_483",

						"neha@example.com", "4567890123"));

		alumniMap.put("Shruti_456",

				new Alumni("Shruti Singh", "Information Technology", "2019", "Web Developer", "Facebook",

						new ArrayList<>(Arrays.asList("web development", "front-end", "JavaScript")), "Shruti_456",

						"shruti@example.com", "7890123456"));

		alumniMap.put("Pooja_453",

				new Alumni("Pooja Sharma", "Computer Science", "2016", "Machine Learning Engineer", "Apple",

						new ArrayList<>(Arrays.asList("machine learning", "data science", "Python")), "Pooja_453",

						"pooja@example.com", "2345678901"));

		alumniMap.put("Ritu_376",

				new Alumni("Ritu Gupta", "Computer Science", "2017", "Software Developer", "TCS",

						new ArrayList<>(Arrays.asList("software development", "Java", "databases")), "Ritu_376",

						"ritu@example.com", "3456789012"));

		alumniMap.put("Swati_387",

				new Alumni("Swati Kumari", "Electrical Engineering", "2016", "Data Scientist", "Infosys",

						new ArrayList<>(Arrays.asList("data analytics", "machine learning", "Python")), "Swati_387",

						"swati@example.com", "4567890123"));

		alumniMap.put("Natasha_908",

				new Alumni("Natasha Singh", "Mechanical Engineering", "2013", "Engineering Manager", "Wipro",

						new ArrayList<>(Arrays.asList("project management", "team leadership")), "Natasha_908",

						"natasha@example.com", "5678901234"));

		alumniMap.put("Komal_399",

				new Alumni("Komal Patel", "Information Technology", "2020", "Frontend Developer", "Tech Mahindra",

						new ArrayList<>(Arrays.asList("web design", "CSS", "JavaScript")), "Komal_399",

						"komal@example.com", "6789012345"));

		alumniMap.put("Nisha_103",

				new Alumni("Nisha Sharma", "Computer Science", "2014", "AI Researcher", "Tech Mahindra",

						new ArrayList<>(Arrays.asList("artificial intelligence", "research", "Python")), "Nisha_103",

						"nisha@example.com", "7890123456"));

		alumniMap.put("Rhea_172",

				new Alumni("Rhea Gupta", "Electrical Engineering", "2019", "Business Analyst", "Capgemini",

						new ArrayList<>(Arrays.asList("business analysis", "requirements gathering")), "Rhea_172",

						"rhea@example.com", "8901234567"));

		alumniMap.put("Simran_283",

				new Alumni("Simran Singh", "Mechanical Engineering", "2015", "Product Designer", "HCL Technologies",

						new ArrayList<>(Arrays.asList("product design", "CAD", "prototyping")), "Simran_283",

						"simran@example.com", "9012345678"));

		alumniMap.put("Muskaan_283",

				new Alumni("Muskaan Verma", "Information Technology", "2018", "UX Designer", "L&T Infotech",

						new ArrayList<>(Arrays.asList("user experience", "UI design", "wireframing")), "Muskaan_283",

						"muskaan@example.com", "0123456789"));



	}



	void createNewAlumni() {

		

			Scanner scanner = new Scanner(System.in);



			HashMap<String, Alumni> alumniMap = new HashMap<>();



			System.out.println("Enter alumni details:");

			System.out.print("Name: ");

			String name = scanner.nextLine();



			System.out.print("Branch: ");

			String branch = scanner.nextLine();



			System.out.print("Passing Year: ");

			String passingYear = scanner.next();

			scanner.nextLine();



			System.out.print("Job Profile: ");

			String jobProfile = scanner.nextLine();



			System.out.print("Tags (comma-separated): ");

			String tagsInput = scanner.nextLine();

			ArrayList<String> tags = new ArrayList<>(Arrays.asList(tagsInput.split(", ")));



			System.out.print("ID: ");

			String id = scanner.nextLine();



			System.out.print("Gmail: ");

			String gmail = scanner.nextLine();



			System.out.print("Contact: ");

			String contact = scanner.nextLine();



			alumniMap.put(id, new Alumni(name, branch, passingYear, jobProfile, "default", tags, id, gmail, contact));



}
}
class AlumniTree{
	
	
	String data ;
	LinkedList<AlumniTree> child ;
	AlumniTree root ;
	
	AlumniTree(String data){
		
		this.data = data;
		this.child = new LinkedList<>();
		
	}
	void initializeTree() {
		
		root.data = "Alumni Tree";
		root.child.add(new AlumniTree("Passing Year"));
		root.child.add(new AlumniTree("Domain"));
		root.child.add(new AlumniTree("Branch"));
		root.child.add(new AlumniTree("Organisation"));
		
	}
	
	void addPassingYear(String passYear , String Uname){
		
		AlumniTree newAlumni = new AlumniTree(Uname);
		LinkedList<AlumniTree> child = root.child;
		LinkedList<AlumniTree> temp= child;
		AlumniTree curr=null;
		for(AlumniTree at:temp){
			if(at.data.equals("Passing Year")) {
				curr=at;
			}
		}
		AlumniTree par = curr;
		child = curr.child;
		temp= child;
		curr=null;
		boolean isFound = false;
		
		for(AlumniTree at:temp){
			if(at.data.equals(passYear)) {
				isFound = true;
				curr=at;
			}
		}
		if(isFound){
			curr.child.add(newAlumni);
		}else {
			AlumniTree newYear= new AlumniTree(passYear);
			newYear.child.add(newAlumni);
			par.child.add(newYear);
		}
	}
}







class Alumni {



	String name;

	String branch;

	String passingYear;

	String domain;

	String organisation;

	ArrayList<String> tags;

	String id;

	String gmail;

	String contact;



	Alumni(String Name, String Branch, String PassingYear, String domain, String organisation, ArrayList<String> Tags,

			String Id, String gmail, String contact) {



		this.name = Name;

		this.branch = Branch;

		this.passingYear = PassingYear;

		this.domain = domain;

		this.organisation = organisation;

		this.tags = Tags;

		this.id = Id;

		this.gmail = gmail;

		this.contact = contact;

	}


}
	class Student{
		
	
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

		    public Student(String rollNum, String name, String contactNo, String emailId, String branch, int yearOfStudy, double GPA, String areaOfInterest, String workExperience) {
		        this.rollNum = rollNum;
		        this.name = name;
		        this.contactNo=contactNo;
		        this.emailId=emailId;
		        this.branch = branch;
		        this.yearOfStudy = yearOfStudy;
		        this.GPA = GPA;
		        this.areaOfInterest=areaOfInterest;
		        this.workExperience=workExperience;
		        this.next=null;
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


		    public Student getNext() { //for next
		        return next;
		    }

		    public void setNext(Student next) {
		        this.next = next;
		    }

}
public class Main {
	
	static Scanner sc = new Scanner (System.in);

	
	static boolean check(String alId,String alPass) {
		return true;
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
	static boolean checkStudent(String username, String password) {
        // Dummy implementation for checking student credentials
        return true; // Returning true for demonstration
    }
static void seeAlumniByPreference() {
        // Options based on alumni preferences
        System.out.println("------------------\n" + "1) Based on branch \n" + "2) Based on passing year \n" + "3) Based on domain \n" + "4) Based on organization\n--------------------");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                //seeAlumniByBranch();
                break;
            case 2:
                //seeAlumniByPassingYear();
                break;
            case 3:
                //seeAlumniByDomain();
                break;
            case 4:
                //seeAlumniByOrganization();
                break;
            default:
                System.out.println("Invalid Choice !");
                break;
        }

	public static void main(String[] args) {
		AlumniDB obj=new AlumniDB();

		System.out.println("------------\n"
				+ "1) Alumni\n"
				+ "2) Student\n"
				+ "3) Exit\n"
				+ "-------------");
		
		int choice= sc.nextInt();
		sc.nextLine();
		if(choice == 1){
			//Alumni
			System.out.println("-----------\n"
					+ "1) Login \n"
					+ "2) Sign Up \n"
					+ "3) Exit"
					+ "\n-------------");
			choice = sc.nextInt();
			 sc.nextLine();
			if(choice==1) {
				//Alumni login section
				
				System.out.println("Enter Id := ");
				String alId = sc.nextLine();
				System.out.println("Enter Password := ");
				String alPass= sc.nextLine();
				
				boolean isValid= check(alId,alPass);
				
				if(isValid) {
					
					//options After Successful login of Alumni
					
					System.out.println("---------------------\nLogin Successful  !\n-----------------");
					System.out.println("------------------\n"
							+ "1) Post An Event \n"
							+ "2) See Registrations \n"
							+ "\n--------------------");
					 choice = sc.nextInt();
				}else {
					System.out.println("Incorrect Id or Password");
				}
				
			}else if(choice ==2){
				obj.createNewAlumni();

				System.out.println("Successfully Created Account !");

			}else if(choice ==3) {
				System.out.println("Thank you for Connecting !");
			}else {
				System.out.println("Invalid Choice !");
			}
		}else if(choice ==2) { //student
			System.out.println("-----------\n" + "1) Login \n" + "2) Sign Up \n" + "3) Exit" + "\n-------------");
            choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                // Student login section
                System.out.println("Enter Username: ");
                String username = sc.nextLine();
                System.out.println("Enter Password: ");
                String password = sc.nextLine();

                boolean isValid = checkStudent(username, password);

                if (isValid) {
                    // Options After Successful login of Student
                    System.out.println("---------------------\nLogin Successful!\n-----------------");
                    System.out.println("------------------\n" + "1) See all alumni \n" + "2) See alumni based on preference \n" + "3) See alumni based on username \n" + "4) See all posts\n--------------------");
                    choice = sc.nextInt();

                    // Perform action based on choice
                    switch (choice) {
                        case 1:
                            //seeAllAlumni();
                            break;
                        case 2:
                            seeAlumniByPreference();
                            break;
                        case 3:
                            //seeAlumniByUsername();
                            break;
                        case 4:
                            //seeAllPosts();
                            break;
                        default:
                            System.out.println("Invalid Choice !");
                            break;
                    }
                } else {
                    System.out.println("Incorrect Username or Password");
                }
            } else if (choice == 2) {
                // Create new student account
                Student newStudent = studentInput();
                System.out.println("Successfully Created Account !");
            } else if (choice == 3) {
                System.out.println("Thank you for Connecting !");
            } else {
                System.out.println("Invalid Choice !");
            }

		}else if(choice ==3){
			System.out.println("Thank you for Connecting !");
		}else {
			System.out.println("Invalid Choice !");
		}

	}

}
