package buffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

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
	public void displayAlumniDetailsById(String id) {
    if (alumniMap.containsKey(id)) {
        Alumni alumni = alumniMap.get(id);

        System.out.println("-------------------------------------");
        System.out.println("Name: " + alumni.name);
        System.out.println("Branch: " + alumni.branch);
        System.out.println("Passing Year: " + alumni.passingYear);
        System.out.println("Job Profile: " + alumni.domain);
        System.out.println("Organisation: " + alumni.organisation);
        System.out.println("Tags: " + alumni.tags);
        System.out.println("Gmail: " + alumni.gmail);
        System.out.println("Contact: " + alumni.contact);
        System.out.println("-------------------------------------");
    } else {
        System.out.println("Alumni with ID " + id + " not found.");
    }
}

}

