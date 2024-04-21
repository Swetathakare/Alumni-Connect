package buffer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
	ArrayList<Post> posts;

	Alumni(String Name, String Branch, String PassingYear, String domain, String organisation, ArrayList<String> Tags,

			String Id, String gmail, String contact) {

		this.posts = new ArrayList<>();

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

	public void createPost() {

		Scanner input = new Scanner(System.in);

		System.out.print("Enter post ID: ");

		String postId = input.nextLine();

		System.out.print("Enter post title: ");

		String postTitle = input.nextLine();

		System.out.print("Enter post date (yyyy-mm-dd): ");

		String postDateInput = input.nextLine();

		LocalDate postDate = LocalDate.parse(postDateInput);

		System.out.print("Enter deadline of registration: ");

		String deadlineOfRegistration = input.nextLine();

		System.out.print("Enter date of event (yyyy-mm-dd): ");

		String dateOfEventInput = input.nextLine();

		LocalDate dateOfEvent = LocalDate.parse(dateOfEventInput);

		System.out.print("Enter post description: ");

		String postDescription = input.nextLine();

		System.out.print("Enter tags : ");

		String[] tagArray = input.nextLine().split(",");

		ArrayList<String> postTags = new ArrayList<>(List.of(tagArray));

		Post newPost = new Post(postId, postTitle, postDate, deadlineOfRegistration, dateOfEvent, postDescription,
				postTags);

		posts.add(newPost);

		System.out.println("Post created successfully!");

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
