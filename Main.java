package buffer;

import java.time.LocalDate;
import java.util.*;

public class Main {

	static Scanner sc = new Scanner(System.in);

	static AlumniDB adb = new AlumniDB();

	static boolean check(String alId, String alPass) {
		return true;
	}

	static boolean checkStudent(String username, String password) {
		// Dummy implementation for checking student credentials
		return true; // Returning true for demonstration
	}

	static void seeAlumniByPreference() {
		// Options based on alumni preferences

		System.out.println("------------------\n" + "1) Based on branch \n" + "2) Based on passing year \n"
				+ "3) Based on domain \n" + "4) Based on organization\n--------------------");
		int choice = sc.nextInt();
		sc.nextLine();
		switch (choice) {
		case 1:

			LinkedList<AlumniTree> allAlumniOfBranch = null;
			LinkedList<AlumniTree> almns = adb.seeAlumniByBranch(adb.a.root);
			int i = 0;
			for (AlumniTree id : almns) {
				System.out.println((i++ + 1) + " " + id.data);
			}
			System.out.println("Enter Your Choice :=");
			int n = sc.nextInt();
			sc.nextLine();

			i = 0;
			AlumniTree temp = null;
			for (AlumniTree id : almns) {
				temp = id;
				if (i++ == n - 1)
					break;
			}
			allAlumniOfBranch = temp.child;
			for (AlumniTree al : allAlumniOfBranch)
				adb.displayAlumniDetailsById(al.data);

			break;
		case 2:
			allAlumniOfBranch = null;
			almns = adb.seeAlumniByPassingYear(adb.a.root);
			i = 0;
			for (AlumniTree id : almns) {
				System.out.println((i++ + 1) + " " + id.data);
			}
			System.out.println("Enter Your Choice :=");
			n = sc.nextInt();
			sc.nextLine();

			i = 0;
			temp = null;
			for (AlumniTree id : almns) {
				temp = id;
				if (i++ == n - 1)
					break;
			}
			allAlumniOfBranch = temp.child;
			for (AlumniTree al : allAlumniOfBranch)
				adb.displayAlumniDetailsById(al.data);

			break;
		case 3:

			allAlumniOfBranch = null;
			almns = adb.seeAlumniByDomain(adb.a.root);
			i = 0;
			for (AlumniTree id : almns) {
				System.out.println((i++ + 1) + " " + id.data);
			}
			System.out.println("Enter Your Choice :=");
			n = sc.nextInt();
			sc.nextLine();

			i = 0;
			temp = null;
			for (AlumniTree id : almns) {
				temp = id;
				if (i++ == n - 1)
					break;
			}
			allAlumniOfBranch = temp.child;
			for (AlumniTree al : allAlumniOfBranch)
				adb.displayAlumniDetailsById(al.data);
			break;
		case 4:
			allAlumniOfBranch = null;
			almns = adb.seeAlumniByOrganisation(adb.a.root);
			i = 0;
			for (AlumniTree id : almns) {
				System.out.println((i++ + 1) + " " + id.data);
			}
			System.out.println("Enter Your Choice :=");
			n = sc.nextInt();
			sc.nextLine();

			i = 0;
			temp = null;
			for (AlumniTree id : almns) {
				temp = id;
				if (i++ == n - 1)
					break;
			}
			allAlumniOfBranch = temp.child;
			for (AlumniTree al : allAlumniOfBranch)
				adb.displayAlumniDetailsById(al.data);

			break;
		default:
			System.out.println("Invalid Choice !");
			break;
		}
	}

	public static void main(String[] args) {
		AlumniDB obj = new AlumniDB();

		// obj.display(AlumniTree.root);
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
				obj.createNewAlumni();

				System.out.println("Successfully Created Account !");

			} else if (choice == 3) {
				System.out.println("Thank you for Connecting !");
			} else {
				System.out.println("Invalid Choice !");
			}
		} else if (choice == 2) { // student
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
					System.out.println(
							"------------------\n" + "1) See all alumni \n" 
					                + "2) See alumni based on preference \n"
									+ "3) See alumni based on username \n" + "4) See all posts\n--------------------");
					choice = sc.nextInt();
                    sc.nextLine();
					// Perform action based on choice
					switch (choice) {
					case 1:
						obj.seeAllAlumni();
						break;
					case 2:
						seeAlumniByPreference();
						break;
					case 3:
						System.out.println("Enter Username");
						String uname = sc.nextLine();
						obj.displayAlumniDetailsById(uname);
						break;
					case 4:
						
						obj.printAllPosts();
						break;
					default:
						System.out.println("Invalid Choice !");
						break;
					}
				} else {
					System.out.println("Incorrect Username or Password");
				}
			} else if (choice == 2) {
				// Student s = new Student();
				// s.studentInput();
				System.out.println("Successfully Created Account !");
			} else if (choice == 3) {
				System.out.println("Thank you for Connecting !");
			} else {
				System.out.println("Invalid Choice !");
			}

		} else if (choice == 3) {
			System.out.println("Thank you for Connecting !");
		} else {
			System.out.println("Invalid Choice !");
		}

	}

}
