package buffer;

import java.util.regex.*;
import java.time.LocalDate;
import java.util.*;

public class Main {

	static Scanner sc = new Scanner(System.in);

	static AlumniDB adb = new AlumniDB();
	static StudentDB s = new StudentDB();

	static boolean checkEmail(String email) {

		boolean isValid = email.endsWith("@gmail.com");

		// Print reason for invalid email
		if (!isValid) {
			System.out.println("Email should end with '@gmail.com'.");
		}

		return isValid;
	}

	public static boolean isStrongPassword(String password) {
		// Check length
		if (password.length() < 8) {
			return false;
		}

		// Check for uppercase, lowercase, digits, and special characters using regex
		if (!Pattern.compile("[A-Z]").matcher(password).find() || !Pattern.compile("[a-z]").matcher(password).find()
				|| !Pattern.compile("[0-9]").matcher(password).find()
				|| !Pattern.compile("[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]").matcher(password).find()) {
			return false;
		}

		return true;
	}

	static boolean checkStudent(String username, String password) {
		for (Student s : StudentDB.studentsList) {
			if (s.emailId.equals(username) && s.password.equals(password)) {
				return true;
			}
		}
		return false;
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

		System.out.println("What would you like to do?");
		System.out.println("1.See an Alumni in detail");
		System.out.println("2.exit");
		int opt = sc.nextInt();
		if (opt == 1) {
			System.out.println("Enter id of the alumni:");
			String idd = sc.next();
			adb.displayAlumniDetailsByIdInDetails(idd);

		} else {
			// Code for exit
		}
	}

	public static void main(String[] args) {

		AlumniDB obj = new AlumniDB();
		boolean contOrNot = true;
		while (contOrNot) {

			System.out.println("------------\n" + "1) Alumni\n" + "2) Student\n" + "3) Exit\n" + "-------------");

			int choice = sc.nextInt();
			sc.nextLine();

			// If it is an Alumni

			if (choice == 1) {

				System.out.println("-----------\n" + "1) Login \n" + "2) Sign Up \n" + "3) Exit" + "\n-------------");

				choice = sc.nextInt();
				sc.nextLine();

				// Alumni login section

				if (choice == 1) {

					System.out.println("Enter Id := ");
					String alId = sc.nextLine();
					System.out.println("Enter Password := ");
					String alPass = sc.nextLine();

					obj.checkAlumni(alId, alPass);

					// options After Successful login of Alumni

					if (obj.checkAlumni(alId, alPass)) {

						System.out.println("---------------------\nLogin Successful  !\n-----------------");
						System.out.println("------------------\n" + "1) Post An Event \n" + "\n--------------------");
						choice = sc.nextInt();
						switch (choice) {

						case 1:

							adb.createPost(alId);

							break;

						default:

							System.out.println("Invalid Choice !");

						}
					}

				} else if (choice == 2) {
					obj.createNewAlumni();

					System.out.println("Successfully Created Account !");

				} else if (choice == 3) {
					System.out.println("Thank you for Connecting !");
				} else {
					System.out.println("Invalid Choice !");
				}
			}

			// student Login Section
			else if (choice == 2) {
				System.out.println("-----------\n" + "1) Login \n" + "2) Sign Up \n" + "3) Exit" + "\n-------------");
				choice = sc.nextInt();
				sc.nextLine();

				if (choice == 1) {
					// Student login section
					System.out.println("Enter Username: ");
					String username = sc.nextLine();
					System.out.println("Enter Password: ");
					String password = sc.nextLine();

					if (checkStudent(username, password)) {
						// Options After Successful login of Student
						System.out.println("---------------------\nLogin Successful!\n-----------------");
						System.out.println("------------------\n" + "1) See all alumni \n"
								+ "2) See alumni based on preference \n" + "3) See alumni based on username \n"
								+ "4) See all posts" + "\n--------------------");
						choice = sc.nextInt();
						sc.nextLine();
						// Perform action based on choice
						switch (choice) {

						case 1:

							adb.seeAllAlumni();

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

						}

					} else {

						System.out.println("Incorrect Id or Password");

					}

				} else if (choice == 2) {
					s.studentInput();

				} else if (choice == 3) {

					System.out.println("Thank you for Connecting !");

				} else {

					System.out.println("Invalid Choice !");

				}

			}
			System.out.println("Do you wish to continue exploring(Yes=1 ,No=0)");
			int c = sc.nextInt();
			if (c == 0)
				contOrNot = false;
		}
	}
}
