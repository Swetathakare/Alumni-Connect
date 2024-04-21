import java.time.LocalDate;
import java .util.*;


public class Main {
	
	static Scanner sc = new Scanner (System.in);

	
	static boolean check(String alId,String alPass) {
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

	public static void main(String[] args) {
		
		AlumniDB obj=new AlumniDB();
LinkedList<Student> studentsList = new LinkedList<>();

		//dummy data for student
	studentsList.add(new Student("ABC1234567", "Riddhi Sharma", "9876543210", "riddhi@xyzcollege.in", "Computer Science", 3, 3.8, "Software Development", "Intern at CompanyX"));
        studentsList.add(new Student("DEF2345678", "Rohan Desh", "9876543211", "rohan@xyzcollege.in", "Electrical Engineering", 2, 3.5, "Data Analysis", "Data Analyst at CompanyY"));
        studentsList.add(new Student("GHI3456789", "Ali Singh", "9876543212", "ali@xyzcollege.in", "Mechanical Engineering", 4, 3.2, "Product Management", "Product Manager at CompanyZ"));

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


	
