package buffer;

//import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Alumni {

	String name;

	String branch;

	String passingYear;

	String domain;
    String password;
	String organisation;

	ArrayList<String> tags;

	String id;

	String gmail;
	String contact;
	ArrayList<Post> posts = new ArrayList<>();

	public ArrayList<Post> getPosts() {
		return posts;
	}

	Alumni(String Name, String Branch, String PassingYear, String domain, String organisation, ArrayList<String> Tags,

			String Id, String gmail, String contact ,String password) {

//this.posts = new ArrayList<>();

		this.name = Name;

		this.branch = Branch;

		this.passingYear = PassingYear;

		this.domain = domain;

		this.organisation = organisation;

		this.tags = Tags;

		this.id = Id;

		this.gmail = gmail;

		this.contact = contact;
        
		this.password =password; 
	}


	public void displayPost(Post post) {

		System.out.println("-------------------------------------");

		System.out.println("Post ID: " + post.getId());

		System.out.println("Post Title: " + post.getTitle());

		System.out.println("Post Date: " + post.getPostDate());

		System.out.println("Deadline of Registration: " + post.getDeadlineOfRegistration());

		System.out.println("Date of Event: " + post.getDateOfEvent());

		System.out.println("Post Description: " + post.getPostDescription());

		System.out.println("Tags: " + post.getTags());

		System.out.println("-------------------------------------");

	}



	public void deletePost() {

		Scanner input = new Scanner(System.in);

		System.out.print("Enter post ID to delete: ");

		String postIdToDelete = input.nextLine();

		for (int i = 0; i < posts.size(); i++) {

			Post post = posts.get(i);

			if (post.Id.equals(postIdToDelete)) {

				posts.remove(i);

				System.out.println("Post deleted successfully!");

				return;

			}

		}

		System.out.println("Post not found.");

	}

}


