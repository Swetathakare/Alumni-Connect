package buffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

class AlumniDB {

	static AlumniTree a = new AlumniTree("");
	static HashMap<String, Alumni> alumniMap = new HashMap<>();

AlumniDB() {
		
		alumniMap.put("Priya_123",

				new Alumni("Priya Gupta", "Electrical Engineering", "2015", "Software Engineer", "Microsoft",

						new ArrayList<>(Arrays.asList("#coding", "#algorithms")), "Priya_123", "priya@example.com",

						"1234567890","Priya@1234"));

	    Alumni alumni = new Alumni("Aisha Khan", "Electrical Engineering", "2018", "Data Analyst", "Microsoft",new ArrayList<>(Arrays.asList("data analysis", "statistics", "SQL")), "Aisha_234", "aisha@example.com", "9876543210","Aisha!234");

	    alumni.posts.add(new Post("1", "Data Analysis Workshop", "25-02-2023", "10-03-2023","15-03-2023", "Join us for an insightful workshop on data analysis.", new ArrayList<>(Arrays.asList("#dataanalysis", "#statistics", "#SQL"))));

	    alumniMap.put("Aisha_234",alumni);  

		alumniMap.put("Neha_483",

				new Alumni("Neha Patel", "Mechanical Engineering", "2012", "Product Manager", "Amazon",

						new ArrayList<>(Arrays.asList("product management", "leadership", "strategy")), "Neha_483",

						"neha@example.com", "4567890123","Neha_483@!"));

		

	

		alumniMap.put("Shruti_456",

				new Alumni("Shruti Singh", "Information Technology", "2019", "Web Developer", "Facebook",

						new ArrayList<>(Arrays.asList("web development", "front-end", "JavaScript")), "Shruti_456",

						"shruti@example.com", "7890123456","Shruti456#"));



		

		ArrayList<String> postTags = new ArrayList<>(Arrays.asList("#coding", "#beginner", "#adventure"));

        Post post = new Post("6", "Embark Your Coding Journey!","25-01-2023", "01-02-2023","02-02-2023","ArE",postTags);

        



        // Creating an Alumni object and adding it to alumniMap

        alumni = new Alumni("Pooja Sharma", "Computer Science", "2016", "Machine Learning Engineer", "Apple",

                new ArrayList<>(Arrays.asList("machine learning", "data science", "Python")), "Pooja_453",

                "pooja@example.com", "2345678901"," Pooja_453$!" );

        alumni.posts.add(post);



        alumniMap.put("Pooja_453", alumni);



        postTags = new ArrayList<>(Arrays.asList ("#algorithms", "#problem-solving", "#data-structures"));

        Post post2 = new Post("2", "Mastering Algorithms", "10-04-2023", "15-04-2023", "16-04-2023",

                "Dive deep into the world of algorithms and sharpen your problem-solving skills. Join us on this algorithmic journey!", postTags);

	    alumni=new Alumni("Ritu Gupta", "Computer Science", "2017", "Software Developer", "TCS",

				new ArrayList<>(Arrays.asList("software development", "Java", "databases")), "Ritu_376",

				"ritu@example.com", "3456789012","Ritu_376&123");

	    alumni.posts.add(post2);

		alumniMap.put("Ritu_376",alumni);


		alumni=new Alumni("Swati Kumari", "Electrical Engineering", "2016", "Data Scientist", "Infosys",

				new ArrayList<>(Arrays.asList("data analytics", "machine learning", "Python")), "Swati_387",

				"swati@example.com", "4567890123","Swati_387*2024");

		  postTags = new ArrayList<>(Arrays.asList ("#nodejs", "#angularjs", "#web"));

		  alumni.posts.add( new Post("3", "Mastering Web Development", "10-04-2023", "15-04-2023", "16-04-2023",

	                "Dive deep into the world of web development and master HTML, CSS, and JavaScript. Join us on this coding journey!",

	                postTags));

		  alumniMap.put("Swati_387",alumni);

		  

		  	  

	    alumni=new Alumni("Komal Patel", "Information Technology", "2020", "Frontend Developer", "Tech Mahindra",

				new ArrayList<>(Arrays.asList("web design", "CSS", "JavaScript")), "Komal_399",

				"komal@example.com", "6789012345"," Komal_399@pwd");

	    alumni.posts.add( new Post("4", "Internship Guidance in Web Development", "10-04-2023", "15-04-2023", "16-04-2023",

                "Looking for internship opportunities in web development? Dive deep into HTML, CSS, and JavaScript skills. Join us for guidance and tips!",

                postTags));

		alumniMap.put("Komal_399",alumni);

		alumni=new Alumni("Natasha Singh", "Mechanical Engineering", "2013", "Engineering Manager", "Wipro",

				new ArrayList<>(Arrays.asList("project management", "team leadership")), "Natasha_908",

				"natasha@example.com", "5678901234","Natasha_908!");

		alumni.posts.add(new Post("5", "Navigating Engineering Management", "10-04-2023", "15-04-2023", "16-04-2023",

	                "Explore the world of engineering management and learn effective project management and team leadership skills. Join us for insights and guidance!",

	                new ArrayList<>(Arrays.asList("#engineeringmanagement", "#projectmanagement", "#teamleadership"))));

		 alumniMap.put("Natasha_908",alumni);

		

		

		alumniMap.put("Nisha_103",

				new Alumni("Nisha Sharma", "Computer Science", "2014", "AI Researcher", "Tech Mahindra",

						new ArrayList<>(Arrays.asList("artificial intelligence", "research", "Python")), "Nisha_103",

						"nisha@example.com", "7890123456", "Nisha_103#pwd"));

		alumniMap.put("Rhea_172",

				new Alumni("Rhea Gupta", "Electrical Engineering", "2019", "Business Analyst", "Capgemini",

						new ArrayList<>(Arrays.asList("business analysis", "requirements gathering")), "Rhea_172",

						"rhea@example.com", "8901234567","Rhea_172%pass"));

		alumniMap.put("Simran_283",new Alumni("Simran Singh", "Mechanical Engineering", "2015", "Product Designer", "HCL Technologies",

						new ArrayList<>(Arrays.asList("product design", "CAD", "prototyping")), "Simran_283",

						"simran@example.com", "9012345678","Simran_283@2024"));

		alumniMap.put("Muskaan_283",

				new Alumni("Muskaan Verma", "Information Technology", "2018", "UX Designer", "L&T Infotech",

						new ArrayList<>(Arrays.asList("user experience", "UI design", "wireframing")), "Muskaan_283",

						"muskaan@example.com", "0123456789","Muskaan_283&123"));


		
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

	LinkedList<AlumniTree> seeAlumniByBranch(AlumniTree root) {

		LinkedList<AlumniTree> child = root.child;

		for (AlumniTree curr : child) {
			if (curr.data == "Branch") {
				return curr.child;
			}
		}
		return null;

	}

	LinkedList<AlumniTree> seeAlumniByDomain(AlumniTree root) {

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

	LinkedList<AlumniTree> seeAlumniByOrganisation(AlumniTree root) {

		LinkedList<AlumniTree> child = root.child;

		for (AlumniTree curr : child) {
			if (curr.data == "Organisation") {
				return curr.child;
			}
		}
		return null;

	}

	LinkedList<AlumniTree> seeAlumniByPassingYear(AlumniTree root) {

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

	ArrayList<String> postTags = new ArrayList<>(List.of(tagArray));

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
			//System.out.println("Organisation: " + alumni.organisation);
			//System.out.println("Tags        : " + alumni.tags);
			//System.out.println("Gmail       : " + alumni.gmail);
			//System.out.println("Contact     : " + alumni.contact);
			System.out.println("-------------------------------------");
		} else {
			System.out.println("Alumni with ID " + id + " not found.");
		}
	}
	
	
}
