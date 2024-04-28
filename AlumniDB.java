package buffer;

import java.util.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;



class AlumniDB {

	static AlumniTree a = new AlumniTree("");
	public static HashMap<String, Alumni> alumniMap = new HashMap<>();

AlumniDB() {
		
	// Priya_123
	Alumni alumniPriya_123 = new Alumni("Priya Gupta", "Electrical Engineering", "2015", "Software Engineer", "Microsoft",
	    new ArrayList<>(Arrays.asList("#coding", "#algorithms")), "Priya_123", "priya@example.com", "1234567890","Priy@987");

	Post postPriya123_1 = new Post("Priya_1", "Java Coding Bootcamp", "2023-03-15", "2023-03-30", "2023-04-05",
	    "Join our Java coding bootcamp and master the fundamentals of object-oriented programming.",
	    new ArrayList<>(Arrays.asList("#Java", "#coding", "#bootcamp")));

	alumniPriya_123.posts.add(postPriya123_1);

	Post postPriya123_2 = new Post("Priya_2", "Algorithms Study Group", "2023-04-20", "2023-05-05", "2023-05-10",
	    "Join our algorithms study group to explore advanced algorithms and problem-solving techniques.",
	    new ArrayList<>(Arrays.asList("#algorithms", "#studygroup", "#problem-solving")));

    Registration r1=new Registration("ABC1234567", "Riddhi Sharma", "9876543210", "riddhi@xyzcollege.in");

    Registration r2=new Registration("DEF2345678", "Rohan Desh", "9876543211", "rohan@xyzcollege.in");

    Registration r3=new Registration("GHI3456789", "Ali Singh", "9876543212", "ali@xyzcollege.in");

    Registration r4=new Registration("KLE3456789", "Raddha Sharma", "9876543456", "raddha@xyzcollege.in");

    postPriya123_1.registeredStudents.add(r1);

    postPriya123_1.registeredStudents.add(r2);

    postPriya123_1.registeredStudents.add(r3);

    postPriya123_1.registeredStudents.add(r4);

	alumniPriya_123.posts.add(postPriya123_2);

	// Add Priya_123 to alumniMap
	alumniMap.put("Priya_123", alumniPriya_123);

	// Aisha_234
	Alumni alumniAisha_234 = new Alumni("Aisha Khan", "Electrical Engineering", "2018", "Data Analyst", "Microsoft",
	    new ArrayList<>(Arrays.asList("data analysis", "statistics", "SQL")), "Aisha_234", "aisha@example.com", "9876543210","aisha@123");

	alumniAisha_234.posts.add(new Post("Aisha_1", "Data Analysis Workshop", "2023-02-25", "2023-03-10", "2023-03-15",
	    "Join us for an insightful workshop on data analysis.", new ArrayList<>(Arrays.asList("#dataanalysis", "#statistics", "#SQL"))));
	alumniAisha_234.posts.add(new Post("Aisha_2", "Mentorship at Microsoft", "2024-04-21", "2024-04-26", "2024-04-04",
	    "Exclusive mentorship session at Microsoft HYD office for the selected students. Grab the opportunity now.",
	    new ArrayList<>(Arrays.asList("#Mentorship", "#Microsoft"))));

	alumniMap.put("Aisha_234", alumniAisha_234);

	// Neha_483
	Alumni alumniNeha_483 = new Alumni("Neha Patel", "Mechanical Engineering", "2012", "Product Manager", "Amazon",
	    new ArrayList<>(Arrays.asList("product management", "leadership", "strategy")), "Neha_483", "neha@example.com", "4567890123","neha*345");
	alumniNeha_483.posts.add(new Post("Neha_1", "Understanding concepts of project management", "2024-05-20", "2024-05-27", "2024-06-15",
		    "Know insights of project management", new ArrayList<>(Arrays.asList("#projectmanagement", "#amazon"))));
	alumniNeha_483.posts.add(new Post("Neha_2", "Effective Leadership Workshop", "2024-06-30", "2024-07-10", "2024-07-15",
		    "Join our workshop to enhance your leadership skills and learn effective management techniques.",
		    new ArrayList<>(Arrays.asList("#leadership", "#workshop", "#management"))));

		alumniNeha_483.posts.add(new Post("Neha_3", "Strategic Planning Seminar", "2024-08-15", "2024-08-25", "2024-09-05",
		    "Participate in our strategic planning seminar to develop your strategic thinking abilities and planning skills.",
		    new ArrayList<>(Arrays.asList("#strategy", "#planning", "#seminar"))));

	alumniMap.put("Neha_483", alumniNeha_483);

	// Shruti_456
	Alumni alumniShruti_456 = new Alumni("Shruti Singh", "Information Technology", "2019", "Web Developer", "Facebook",
	    new ArrayList<>(Arrays.asList("web development", "front-end", "JavaScript")), "Shruti_456", "shruti@example.com", "7890123456","shruti#234");

	alumniShruti_456.posts.add(new Post("Shruti_1", "Exploring Web Development", "2023-05-20", "2023-06-05", "2023-06-10",
		    "Join us in exploring the exciting world of web development! Learn about HTML, CSS, and JavaScript essentials.",
		    new ArrayList<>(Arrays.asList("#webdevelopment", "#HTML", "#CSS", "#JavaScript"))));
	
	alumniShruti_456.posts.add(new Post("Shruti_2", "Mastering Front-end Frameworks", "2023-06-20", "2023-07-05", "2023-07-10",
		    "Take your front-end development skills to the next level by mastering popular frameworks like React and Angular.",
		    new ArrayList<>(Arrays.asList("#frontend", "#React", "#Angular"))));

	alumniMap.put("Shruti_456", alumniShruti_456);

	// Pooja_453
	Alumni alumniPooja_453 = new Alumni("Pooja Sharma", "Computer Science", "2016", "Machine Learning Engineer", "Apple",
	    new ArrayList<>(Arrays.asList("machine learning", "data science", "Python")), "Pooja_453", "pooja@example.com", "2345678901","Poo@123");

	Post postPooja453 = new Post("Pooja_1", "Embark Your Coding Journey!", "2023-01-25", "2023-02-01", "2023-02-02",
	    "Dive deep into the world of coding and embark on your coding journey with us!", new ArrayList<>(Arrays.asList("#coding", "#beginner", "#adventure")));
	Post postPooja453_2 = new Post("Pooja_2", "Mastering Data Science", "2023-03-15", "2023-03-30", "2023-04-05",
		    "Join us to master the fundamentals of data science and unlock the power of Python for analysis!", 
		    new ArrayList<>(Arrays.asList("#datascience", "#Python", "#analytics")));
	Post postPooja453_3 = new Post("Pooja_3", "Advanced Machine Learning Workshop", "2023-05-10", "2023-05-25", "2023-06-01",
		    "Take your machine learning skills to the next level with our advanced workshop. Dive into complex algorithms and techniques!",
		    new ArrayList<>(Arrays.asList("#machinelearning", "#advanced", "#workshop")));
	//for postPooja453_3

    Registration r5=new Registration("PQR5678901", "Priya Gupta", "9876543458", "priya@xyzcollege.in");

    Registration r6=new Registration("STU6789012", "Aryan Kumar", "9876543459", "aryan@xyzcollege.in");

    Registration r7=new Registration("GHI3456789", "Ali Singh", "9876543212", "ali@xyzcollege.in");

    Registration r8=new Registration("KLE3456789", "Raddha Sharma", "9876543456", "raddha@xyzcollege.in");

    postPooja453_3.registeredStudents.add(r5);

    postPooja453_3.registeredStudents.add(r6);

    postPooja453_3.registeredStudents.add(r7);

    postPooja453_3.registeredStudents.add(r8);

	
	alumniPooja_453.posts.add(postPooja453);
	alumniPooja_453.posts.add(postPooja453_2);
	alumniPooja_453.posts.add(postPooja453_3);
	alumniMap.put("Pooja_453", alumniPooja_453);

	// Ritu_376
	Alumni alumniRitu_376 = new Alumni("Ritu Gupta", "Computer Science", "2017", "Software Developer", "TCS",
	    new ArrayList<>(Arrays.asList("software development", "Java", "databases")), "Ritu_376", "ritu@example.com", "3456789012","RItu*234");

	Post postRitu376 = new Post("Ritu_1", "Mastering Algorithms", "2023-04-10", "2023-04-15", "2023-04-16",
	    "Dive deep into the world of algorithms and sharpen your problem-solving skills. Join us on this algorithmic journey!",
	    new ArrayList<>(Arrays.asList("#algorithms", "#problem-solving", "#data-structures")));
	
	Post postRitu376_2 = new Post("Ritu_2", "Exploring Java Development", "2023-05-20", "2023-06-05", "2023-06-10",
		    "Explore the world of Java development and learn about the latest trends and techniques in building robust software applications!",
		    new ArrayList<>(Arrays.asList("#Java", "#development", "#coding")));
	
	 Registration r9=new Registration("PQR5678901", "Priya Gupta", "9876543458", "priya@xyzcollege.in");

	    Registration r10=new Registration("STU6789012", "Aryan Kumar", "9876543459", "aryan@xyzcollege.in");

	    Registration r11=new Registration("VWX7890123", "Neha Singh", "9876543460", "neha@xyzcollege.in");

	    Registration r12=new Registration("YZA8901234", "Amit Jain", "9876543461", "amit@xyzcollege.in");

	    postRitu376_2.registeredStudents.add(r9);

	    postRitu376_2.registeredStudents.add(r10);

	    postRitu376_2.registeredStudents.add(r11);

	    postRitu376_2.registeredStudents.add(r12);

	alumniRitu_376.posts.add(postRitu376);
	alumniRitu_376.posts.add(postRitu376_2);
	alumniMap.put("Ritu_376", alumniRitu_376);

	// Swati_387
	Alumni alumniSwati_387 = new Alumni("Swati Kumari", "Electrical Engineering", "2016", "Data Scientist", "Infosys",
	    new ArrayList<>(Arrays.asList("data analytics", "machine learning", "Python")), "Swati_387", "swati@example.com", "4567890123","Swati*987");

	Post postSwati387 = new Post("Swati_1", "Mastering Web Development", "2023-04-10", "2023-04-15", "2023-04-16",
	    "Dive deep into the world of web development and master HTML, CSS, and JavaScript. Join us on this coding journey!",
	    new ArrayList<>(Arrays.asList("#nodejs", "#angularjs", "#web")));

	alumniSwati_387.posts.add(postSwati387);
	alumniMap.put("Swati_387", alumniSwati_387);

	// Komal_399
	Alumni alumniKomal_399 = new Alumni("Komal Patel", "Information Technology", "2020", "Frontend Developer", "Tech Mahindra",
	    new ArrayList<>(Arrays.asList("web design", "CSS", "JavaScript")), "Komal_399", "komal@example.com", "6789012345","Ko@456mal");

	Post postKomal399 = new Post("Komal_1", "Internship Guidance in Web Development", "2023-04-10", "2023-04-15", "2023-04-16",
	    "Looking for internship opportunities in web development? Dive deep into HTML, CSS, and JavaScript skills. Join us for guidance and tips!",
	    new ArrayList<>(Arrays.asList("#internship", "#webdevelopment", "#guidance")));
	
	alumniKomal_399.posts.add(postKomal399);

	   Registration r25=new Registration("BCD9012345", "Sonal Gupta", "9876543462", "sonal@xyzcollege.in");

	    Registration r26=new Registration("YZA8901234", "Amit Jain", "9876543461", "amit@xyzcollege.in");

	    Registration r27=new Registration("EFG0123456", "Aarav Sharma", "9876543463", "aarav@xyzcollege.in");

	    Registration r28=new Registration("HIJ1234567", "Kavya Reddy", "9876543464", "kavya@xyzcollege.in");

	    postKomal399.registeredStudents.add(r25);

	    postKomal399.registeredStudents.add(r26);

	    postKomal399.registeredStudents.add(r27);

	    postKomal399.registeredStudents.add(r28);

	alumniMap.put("Komal_399", alumniKomal_399);

	// Natasha_908
	Alumni alumniNatasha_908 = new Alumni("Natasha Singh", "Mechanical Engineering", "2013", "Engineering Manager", "Wipro",
	    new ArrayList<>(Arrays.asList("project management", "team leadership")), "Natasha_908", "natasha@example.com", "5678901234","Natasha@678#");

	Post postNatasha908 = new Post("Natasha_1", "Navigating Engineering Management", "2023-04-10", "2023-04-15", "2023-04-16",
	    "Explore the world of engineering management and learn effective project management and team leadership skills. Join us for insights and guidance!",
	    new ArrayList<>(Arrays.asList("#engineeringmanagement", "#projectmanagement", "#teamleadership")));
	
	  //for postNatasha908

    

    Registration r17=new Registration("BCD9012345", "Sonal Gupta", "9876543462", "sonal@xyzcollege.in");

    Registration r18=new Registration("YZA8901234", "Amit Jain", "9876543461", "amit@xyzcollege.in");

    Registration r19=new Registration("EFG0123456", "Aarav Sharma", "9876543463", "aarav@xyzcollege.in");

    Registration r20=new Registration("DEF2345678", "Rohan Desh", "9876543211", "rohan@xyzcollege.in");

    

    postNatasha908.registeredStudents.add(r17);

    postNatasha908.registeredStudents.add(r18);

    postNatasha908.registeredStudents.add(r19);

    postNatasha908.registeredStudents.add(r20);

	alumniNatasha_908.posts.add(postNatasha908);
	alumniMap.put("Natasha_908", alumniNatasha_908);

	// Nisha_103
	Alumni alumniNisha_103 = new Alumni("Nisha Sharma", "Computer Science", "2014", "AI Researcher", "Tech Mahindra",
	    new ArrayList<>(Arrays.asList("artificial intelligence", "research", "Python")), "Nisha_103", "nisha@example.com", "7890123456","Nisha#234");

	Post postNisha103_1 = new Post("Nisha_1", "AI Research Symposium", "2023-03-15", "2023-03-20", "2023-03-25",
	    "Join us for an AI research symposium featuring talks from leading experts and hands-on workshops in Python and machine learning.",
	    new ArrayList<>(Arrays.asList("#AIresearch", "#Python", "#machinelearning")));
	
	//for post4

    Registration r13=new Registration("PQR5678901", "Priya Gupta", "9876543458", "priya@xyzcollege.in");

    Registration r14=new Registration("YZA8901234", "Amit Jain", "9876543461", "amit@xyzcollege.in");

    Registration r15=new Registration("ABC1234567", "Riddhi Sharma", "9876543210", "riddhi@xyzcollege.in");

    Registration r16=new Registration("DEF2345678", "Rohan Desh", "9876543211", "rohan@xyzcollege.in");

    

    postNisha103_1.registeredStudents.add(r13);

    postNisha103_1.registeredStudents.add(r14);

    postNisha103_1.registeredStudents.add(r15);

    postNisha103_1.registeredStudents.add(r16);

    

	alumniNisha_103.posts.add(postNisha103_1);

	// Add Nisha_103 to alumniMap
	alumniMap.put("Nisha_103", alumniNisha_103);

	// Rhea_172
	Alumni alumniRhea_172 = new Alumni("Rhea Gupta", "Electrical Engineering", "2019", "Business Analyst", "Capgemini",
	    new ArrayList<>(Arrays.asList("business analysis", "requirements gathering")), "Rhea_172", "rhea@example.com", "8901234567","Rhea*$345");

	Post postRhea172_1 = new Post("Rhea_1", "Business Analysis Workshop", "2023-04-05", "2023-04-10", "2023-04-15",
	    "Enhance your business analysis skills with our comprehensive workshop covering industry best practices and tools.",
	    new ArrayList<>(Arrays.asList("#businessanalysis", "#workshop", "#careerdevelopment")));
	
	// registrations for postRhea172_1
	
	  Registration r21=new Registration("BCD9012345", "Sonal Gupta", "9876543462", "sonal@xyzcollege.in");

	    Registration r22=new Registration("YZA8901234", "Amit Jain", "9876543461", "amit@xyzcollege.in");

	    Registration r23=new Registration("EFG0123456", "Aarav Sharma", "9876543463", "aarav@xyzcollege.in");

	    Registration r24=new Registration("HIJ1234567", "Kavya Reddy", "9876543464", "kavya@xyzcollege.in");

       

	    postRhea172_1.registeredStudents.add(r21);

	    postRhea172_1.registeredStudents.add(r22);

	    postRhea172_1.registeredStudents.add(r23);

	    postRhea172_1.registeredStudents.add(r24);

	alumniRhea_172.posts.add(postRhea172_1);

	// Add Rhea_172 to alumniMap
	alumniMap.put("Rhea_172", alumniRhea_172);

	// Simran_283
	Alumni alumniSimran_283 = new Alumni("Simran Singh", "Mechanical Engineering", "2015", "Product Designer", "HCL Technologies",
	    new ArrayList<>(Arrays.asList("product design", "CAD", "prototyping")), "Simran_283", "simran@example.com", "9012345678","Simran#234@");

	Post postSimran283_1 = new Post("Simran_1", "Prototyping Workshop", "2023-05-10", "2023-05-15", "2023-05-20",
	    "Join our prototyping workshop to learn about CAD tools and techniques for creating innovative product designs.",
	    new ArrayList<>(Arrays.asList("#prototyping", "#workshop", "#CAD")));

	alumniSimran_283.posts.add(postSimran283_1);

	// Add Simran_283 to alumniMap
	alumniMap.put("Simran_283", alumniSimran_283);

	// Muskaan_283
	Alumni alumniMuskaan_283 = new Alumni("Muskaan Verma", "Information Technology", "2018", "UX Designer", "L&T Infotech",
	    new ArrayList<>(Arrays.asList("user experience", "UI design", "wireframing")), "Muskaan_283", "muskaan@example.com", "0123456789","Muska@n456");

	Post postMuskaan283_1 = new Post("Muskaan_1", "UI Design Workshop", "2023-06-05", "2023-06-10", "2023-06-15",
	    "Learn the principles of effective UI design and wireframing in our hands-on workshop led by industry experts.",
	    new ArrayList<>(Arrays.asList("#UIDesign", "#workshop", "#UX")));
	
	

	alumniMuskaan_283.posts.add(postMuskaan283_1);

	// Add Muskaan_283 to alumniMap
	alumniMap.put("Muskaan_283", alumniMuskaan_283);


		
		a.initializeTree();
	    System.out.println(a.data);
	    for(String alumniK : alumniMap.keySet()) {
	 	   
	 	   Alumni currAlumni = alumniMap.get(alumniK);
	 	   a.addBranch(currAlumni.branch, alumniK);
	 	   a.addPassingYear(currAlumni.passingYear, alumniK);
	 	   a.addDomain(currAlumni.domain, alumniK);
	 	   a.addOrganisation(currAlumni.organisation, alumniK);
	 	   

	}
}
void display(AlumniTree root) {
	if (root == null)
		return;

	System.out.println(root.data);
	LinkedList<AlumniTree> child = root.child;
	if (child != null) {
		for (AlumniTree tmp : child)
			display(tmp);
	}

}

static LinkedList<AlumniTree> seeAlumniByBranch(AlumniTree root) {

	LinkedList<AlumniTree> child = root.child;

	for (AlumniTree curr : child) {
		if (curr.data == "Branch") {
			return curr.child;
		}
	}
	return null;

}

static LinkedList<AlumniTree> seeAlumniByDomain(AlumniTree root) {

	LinkedList<AlumniTree> child = root.child;

	for (AlumniTree curr : child) {
		if (curr.data == "Domain") {
			return curr.child;
		}
	}
	return null;

}

void printAllPosts() {
	for (Alumni alumni : alumniMap.values()) {
		for (Post post : alumni.getPosts()) {
			if (alumni.getPosts() != null) {
				System.out.println("Alumni Name: " + alumni.name);
				System.out.println("Posts:");

				System.out.println("Post ID: " + post.getId());
				System.out.println("Title: " + post.getTitle());
				System.out.println("Date of Event: " + post.getPostDate());
				System.out.println("Deadline of registration: " + post.getDeadlineOfRegistration());
				System.out.println("Description: " + post.getPostDescription());
				System.out.println("Tags: " + post.getTags());
				System.out.println("-----------------------------");
			}
		}
	}
}

static LinkedList<AlumniTree> seeAlumniByOrganisation(AlumniTree root) {

	LinkedList<AlumniTree> child = root.child;

	for (AlumniTree curr : child) {
		if (curr.data == "Organisation") {
			return curr.child;
		}
	}
	return null;

}

static LinkedList<AlumniTree> seeAlumniByPassingYear(AlumniTree root) {

	LinkedList<AlumniTree> child = root.child;

	for (AlumniTree curr : child) {
		if (curr.data == "Passing Year") {
			return curr.child;
		}
	}
	return null;
}
//add in AlumniDB and remove earlier method from alumni





public void createPost(String alId) {

Scanner input = new Scanner(System.in);

System.out.print("Enter post ID: ");

String postId = input.nextLine();

System.out.print("Enter post title: ");

String postTitle = input.nextLine();

System.out.print("Enter post date (yyyy-mm-dd): ");

String postDate = input.nextLine();

System.out.print("Enter deadline of registration: ");

String deadlineOfRegistration = input.nextLine();

System.out.print("Enter date of event (yyyy-mm-dd): ");

String dateOfEvent = input.nextLine();

System.out.print("Enter post description: ");

String postDescription = input.nextLine();

System.out.print("Enter tags : ");

String[] tagArray = input.nextLine().split(",");

ArrayList<String> postTags = new ArrayList<>(Arrays.asList(tagArray));

// Create the new post

Post newPost = new Post(postId, postTitle, postDate, deadlineOfRegistration, dateOfEvent, postDescription, postTags);

// Update the database with the new post

if (AlumniDB.alumniMap.containsKey(alId)) {

Alumni alumni = AlumniDB.alumniMap.get(alId);

alumni.posts.add(newPost);

alumniMap.put(alId,alumni);

System.out.println("Post added to the database successfully!");

} else {

System.out.println("Alumni with ID " + alId + " not found.");

}

System.out.println("Post created successfully!");

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
	
	System.out.print("Password : ");

	String p = scanner.nextLine();

	alumniMap.put(id, new Alumni(name, branch, passingYear, jobProfile, "default", tags, id, gmail, contact,p));

}

public void seeAllAlumni() {
	for (String id : alumniMap.keySet()) {
		displayAlumniDetailsById(id);
	}
}

boolean checkAlumni(String alId, String alPass) {
	if(alumniMap.containsKey(alId)) {
		Alumni  a= alumniMap.get(alId);
		if(a.password.equals(alPass)) return true;
		else System.out.println("Incorrect Password!");
	}
	return false;
}
public void displayAlumniDetailsByIdInDetails(String id) {

	if (alumniMap.containsKey(id)) {

		Alumni alumni = alumniMap.get(id);


		System.out.println("-------------------------------------");

		System.out.println("Id          : " + alumni.id);

		System.out.println("Name        : " + alumni.name);

		System.out.println("Branch      : " + alumni.branch);

		System.out.println("Passing Year: " + alumni.passingYear);

		System.out.println("Job Profile : " + alumni.domain);

		System.out.println("Organisation: " + alumni.organisation);

		System.out.println("Tags        : " + alumni.tags);

		System.out.println("Gmail       : " + alumni.gmail);

		System.out.println("Contact     : " + alumni.contact);



		

		for (Post post : alumni.getPosts()) {

			if (alumni.getPosts() != null) {

		

				System.out.println("Posts:");



				System.out.println("Post ID: " + post.getId());

				System.out.println("Title: " + post.getTitle());

				System.out.println("Date of Event: " + post.getPostDate());

				System.out.println("Deadline of registration: " + post.getDeadlineOfRegistration());

				System.out.println("Description: " + post.getPostDescription());

				System.out.println("Tags: " + post.getTags());

				System.out.println("-----------------------------");

			}

		}

		

		System.out.println("-------------------------------------");

		

	} else {

		System.out.println("Alumni with ID " + id + " not found.");

	}

}

public void displayAlumniDetailsById(String id) {
	if (alumniMap.containsKey(id)) {
		Alumni alumni = alumniMap.get(id);

		System.out.println("-------------------------------------");
		System.out.println("Id          : " + alumni.id);
		System.out.println("Name        : " + alumni.name);
		System.out.println("Branch      : " + alumni.branch);
		System.out.println("Passing Year: " + alumni.passingYear);
		System.out.println("Job Profile : " + alumni.domain);
		System.out.println("-------------------------------------");
	} else {
		System.out.println("Alumni with ID " + id + " not found.");
	}
}

	public void deleteAlumniDetailsById(String id) {

	if (alumniMap.containsKey(id)){

		

		Alumni alumni = alumniMap.get(id);

		a.deleteBranch(alumni.branch,alumni.name);

		a.deleteDomain(alumni.domain,alumni.name);

		a.deleteOrganisation(alumni.organisation,alumni.name);

		a.deletePassingYear(alumni.passingYear,alumni.name);

		alumni.posts=null;

		alumniMap.remove(id);



	}}
	
	public void updateAlumniDetails(String alumniId) {
	    Scanner scanner = new Scanner(System.in);
	    
	    if (alumniMap.containsKey(alumniId)) {
	        Alumni alumni = alumniMap.get(alumniId);
	        
	        System.out.println("Enter updated details for alumni " + alumniId + ":");
	        
	        System.out.print("Name: ");
	        String name = scanner.nextLine();
	        
	        System.out.print("Branch: ");
	        String branch = scanner.nextLine();
	        
	        System.out.print("Passing Year: ");
	        String passingYear = scanner.nextLine();
	        
	        System.out.print("Job Profile: ");
	        String jobProfile = scanner.nextLine();
	        
	        System.out.print("Organisation: ");
	        String organisation = scanner.nextLine();
	        
	        System.out.print("Tags (comma-separated): ");
	        String tagsInput = scanner.nextLine();
            ArrayList<String> tags = new ArrayList<>(Arrays.asList(tagsInput.split(",")));

	        
	        System.out.print("Gmail: ");
	        String gmail = scanner.nextLine();
	        
	        System.out.print("Contact: ");
	        String contact = scanner.nextLine();
	        
	        // Update alumni details
	        alumni.name=name;
	        alumni.branch= branch;
	        alumni.passingYear=passingYear;
	        alumni.domain =jobProfile;
	        alumni.organisation=organisation;
	        alumni.tags=tags;
	        alumni.gmail=gmail;
	        alumni.contact=contact;
	        
	        // Put the updated alumni back into the map
	        alumniMap.put(alumniId, alumni);
	        System.out.println("Alumni details updated successfully!");
	    } else {
	        System.out.println("Alumni with ID " + alumniId + " not found.");
	    }
	}
}
